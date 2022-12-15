package com.springSecurity.SecurityApplication.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.springSecurity.SecurityApplication.security.ApplicationUserRole.*;
@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDAO {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
       return getApplicationUsers().stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }
    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "david",
                        passwordEncoder.encode("password"),
                        ADMIN.grantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "michael",
                        passwordEncoder.encode("password"),
                        ADMINTRAINEE.grantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "jim",
                        passwordEncoder.encode("password"),
                        STUDENT.grantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );
          return applicationUsers;
    }
}
