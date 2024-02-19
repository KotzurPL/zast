package pl.kotzur.zast.auth;

public record ChangePasswordRequest(

        String email,

        String oldPassword,

        String newPassword,

        String confirmedPassword

) {
}
