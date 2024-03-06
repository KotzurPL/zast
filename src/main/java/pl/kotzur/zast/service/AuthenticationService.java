package pl.kotzur.zast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kotzur.zast.auth.*;
import pl.kotzur.zast.config.JwtService;
import pl.kotzur.zast.model.entity.Account;
import pl.kotzur.zast.model.entity.Person;
import pl.kotzur.zast.model.entity.Role;
import pl.kotzur.zast.repository.AccountRepository;
import pl.kotzur.zast.repository.PersonRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AccountRepository accountRepository;
    private final PersonRepository personRepository;

    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        String firstName = registerRequest.getFirstName();
        String lastName = registerRequest.getLastName();
        var person = personRepository.findAllByFirstNameAndLastName(firstName, lastName);
        if (person.isPresent() && !haveAccount(person.get())) {
            var account = Account
                    .builder()
                    .email(registerRequest.getEmail())
                    .password(passwordEncoder.encode(registerRequest.getPassword()))
                    .active(true)
                    .person(person.get())
                    .build();
            accountRepository.save(account);
            var jwtAccessToken = jwtService.generateAccessToken(account);
            var jwtRefreshToken = jwtService.generateRefreshToken(account);
            return AuthenticationResponse
                    .builder()
                    .accessToken(jwtAccessToken)
                    .refreshToken(jwtRefreshToken)
                    .build();
        }
        throw new NoSuchElementException("Person not found or have account!");
    }

    private boolean haveAccount(Person person) {
        return accountRepository.findAccountByPerson(person).isPresent();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        var account = accountRepository
                .findByEmail(authenticationRequest.getEmail())
                .orElseThrow();
        var jwtAccessToken = jwtService.generateAccessToken(account);
        var jwtRefreshToken = jwtService.generateRefreshToken(account);
        return AuthenticationResponse
                .builder()
                .accessToken(jwtAccessToken)
                .refreshToken(jwtRefreshToken)
                .build();
    }

    public Object changeOwnPassword(ChangePasswordRequest changePasswordRequest) {
        String email = changePasswordRequest.email();
        String oldPassword = changePasswordRequest.oldPassword();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, oldPassword)
        );
        Optional<Account> optionalAccount = accountRepository.findByEmail(email);
        boolean haveAccount = optionalAccount.isPresent();
        boolean isNewPasswordTheSame = changePasswordRequest.newPassword()
                .equals(changePasswordRequest.confirmedPassword());
        boolean changeOwnPassword = AuthUtils.getAccount().getEmail().equals(email);

        if (haveAccount && isNewPasswordTheSame && changeOwnPassword) {
            Account account = optionalAccount.get();
            account.setPassword(passwordEncoder.encode(changePasswordRequest.newPassword()));
            accountRepository.save(account);
        }


        return null;
    }

    public UserDetailsResponse getUserDetails() {
        Account account = AuthUtils.getAccount();
        String email = account.getEmail();
        Account accountDB = accountRepository.findByEmail(email).get();
        return new UserDetailsResponse(
                accountDB.getEmail(),
                accountDB.isActive(),
                accountDB.getPerson().getFirstName(),
                accountDB.getPerson().getSecondName(),
                accountDB.getPerson().getLastName(),
                accountDB.getPerson().getShortName(),
                accountDB.getPerson().getRoles()
                        .stream()
                        .map(role -> role.getShortName().toString())
                        .toList()
        );
    }
}
