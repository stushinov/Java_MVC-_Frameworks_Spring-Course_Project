package org.tushinov.auth.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends UuidEntity implements UserDetails {

    @NotEmpty(message = "Username should not be empty!")
    @Length(min = 4, max = 55, message = "Username should be between 4 and 55 characters!")
    @Column(name = "username", unique = true, nullable = false, updatable = false)
    private String username;

    @NotEmpty(message = "Email can not be empty!")
    @Column(name = "email", unique = true, nullable = false, updatable = false)
    private String email;

    @NotEmpty(message = "Password should not be empty!")
    @Length(min = 4, message = "Password should be at least 4 characters long!")
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> authorities;

    @Column(name = "is_account_non_expired", nullable = false)
    private boolean isAccountNonExpired;

    @Column(name = "is_account_non_locked", nullable = false)
    private boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired", nullable = false)
    private boolean isCredentialsNonExpired;

    @Column(name = "is_enabled", nullable = false)
    private boolean isEnabled;

    public User() { this.setAccountDefaults(); }

    public User(String username, String email, String password, Role... roles){
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = Set.of(roles);
        this.setAccountDefaults();
    }

    public Set<Role> getAuthorities() {
        return Collections.unmodifiableSet(this.authorities);
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    private void setAccountDefaults(){
        this.isAccountNonExpired = true;
        this.isCredentialsNonExpired = true;
        this.isAccountNonLocked = true;
        this.isEnabled = true;
    }
}
