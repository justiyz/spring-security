package com.springsecurity.springsecurity.service;

import com.springsecurity.springsecurity.data.models.AppUser;
import com.springsecurity.springsecurity.data.models.Roles;
import com.springsecurity.springsecurity.data.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByUsername(username);

        if (appUser == null){
            throw new UsernameNotFoundException("");
        }

        return new User(appUser.getUsername(), appUser.getPassword(), getAuthorities(appUser.getRoles()));
    }



    public Collection<? extends GrantedAuthority> getAuthorities(List<Roles> authorities) {
        return getGrantedAuthority(authorities);
    }


    private List<GrantedAuthority> getGrantedAuthority(List<Roles> roles){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Roles role: roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(String.valueOf(roles)));
        }
        return grantedAuthorities;
    }


}
