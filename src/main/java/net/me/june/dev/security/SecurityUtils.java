package net.me.june.dev.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtils {

    private static Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

    public static User getUsers() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.debug("user = {}",user);
        return user;
    }
}
