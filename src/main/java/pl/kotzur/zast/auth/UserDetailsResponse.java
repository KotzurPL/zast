package pl.kotzur.zast.auth;

import java.util.List;

public record UserDetailsResponse(

        String email,

        boolean active,

        String firstName,

        String secondName,

        String lastName,

        String shortName,

        List<String> roles

) {
}
