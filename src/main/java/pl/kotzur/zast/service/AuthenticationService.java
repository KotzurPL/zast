package pl.kotzur.zast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kotzur.zast.auth.AuthenticationRequest;
import pl.kotzur.zast.auth.AuthenticationResponse;
import pl.kotzur.zast.auth.ChangePasswordRequest;
import pl.kotzur.zast.auth.RegisterRequest;
import pl.kotzur.zast.config.JwtService;
import pl.kotzur.zast.model.entity.Account;
import pl.kotzur.zast.model.entity.Person;
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
            var jwtToken = jwtService.generateToken(account);
            return AuthenticationResponse
                    .builder()
                    .token(jwtToken)
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
        var jwtToken = jwtService.generateToken(account);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public Object changePassword(ChangePasswordRequest changePasswordRequest) {
        String email = changePasswordRequest.email();
        Optional<Account> account = accountRepository.findByEmail(email);
        boolean haveAccount = account.isPresent();
        boolean isNewPasswordTheSame = changePasswordRequest.newPassword()
                .equals(changePasswordRequest.confirmedPassword());
        //boolean isOldPasswordCorrect = authenticationManager.authenticate(new );
        if (haveAccount && isNewPasswordTheSame) {

        }

        throw new RuntimeException();
    }
}
