package net.me.june.dev.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    private static Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

    public static LoginVO getUsers() {
        LoginVO loginVO = (LoginVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.debug("user = {}",loginVO);
        return loginVO;
    }
}
