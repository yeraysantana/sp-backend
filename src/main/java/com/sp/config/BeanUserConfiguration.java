package com.sp.config;

import com.sp.users.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanUserConfiguration {
    private Logger logger = LoggerFactory.getLogger(BeanUserConfiguration.class);

    @Bean
    public UserService userBeanService(){
        logger.info("-> addUserBeanService...");
        return new UserService();
    }
}
