package org.tushinov.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tushinov.auth.entity.Role;
import org.tushinov.auth.entity.User;
import org.tushinov.auth.repository.UserRepository;

import javax.annotation.PostConstruct;


@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findOneByUsernameOrEmail(username, username).orElseThrow(() ->
                new UsernameNotFoundException("No such user exists!"));
    }

    @PostConstruct
    private void seedAdmin() {
        final String ADMIN_USERNAME = "Admin";
        if (!userExists(ADMIN_USERNAME)){
            this.userRepository.saveAndFlush(
                    new User(ADMIN_USERNAME, "admin@admin.com",
                    this.passwordEncoder.encode("12345678"),
                    new Role("ADMIN"), new Role("USER"))
            );
            System.err.println("Admin has been seeded!");
        }

    }

    private boolean userExists(String username) {
        try {
            this.loadUserByUsername(username);
        } catch (UsernameNotFoundException unfe) {
            return false;
        }
        return true;
    }
}
