package pl.kotzur.zast.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import pl.kotzur.zast.model.entity.Account;

public class AuthUtils {

    public static Account getAccount() {
        return  (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
