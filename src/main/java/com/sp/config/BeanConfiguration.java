package com.sp.config;

import com.sp.services.groups.GroupService;
import com.sp.services.ledgerentries.LedgerEntryService;
import com.sp.services.users.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    private Logger logger = LoggerFactory.getLogger(BeanConfiguration.class);

    @Bean
    public UserService userBeanService(){
        logger.info("-> userBeanService...");
        return new UserService();
    }

    @Bean
    public GroupService groupBeanService(){
        logger.info("-> groupBeanService...");
        return new GroupService();
    }

    @Bean
    public LedgerEntryService ledgerEntryBeanService(){
        logger.info("-> paymentBeanService...");
        return new LedgerEntryService();
    }
}
