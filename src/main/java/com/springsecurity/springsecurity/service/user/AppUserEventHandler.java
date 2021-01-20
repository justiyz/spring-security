package com.springsecurity.springsecurity.service.user;

import com.springsecurity.springsecurity.data.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@RepositoryEventHandler
@Component
@Slf4j
public class AppUserEventHandler {

    @Autowired
    AppUserService appUserService;

    @HandleBeforeCreate
    public void handleBeforeCreate(AppUser appUser){
        log.info("AppUser object --> {}", appUser);
        appUserService.registerUser(appUser);
    }
}
