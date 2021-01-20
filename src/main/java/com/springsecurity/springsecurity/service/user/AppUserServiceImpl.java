package com.springsecurity.springsecurity.service.user;

import com.springsecurity.springsecurity.data.models.AppUser;
import com.springsecurity.springsecurity.data.models.Roles;
import com.springsecurity.springsecurity.data.repositories.AppUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AppUserServiceImpl implements AppUserService{

    BCryptPasswordEncoder bCryptPasswordEncoder;
    AppUserRepository appUserRepository;

    public AppUserServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, AppUserRepository appUserRepository){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.appUserRepository = appUserRepository;
    }


    @Override
    public void registerUser(AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUser.setRoles(List.of(Roles.ROLE_USER));
    }
}
