package org.tushinov.auth.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
public class Role extends UuidEntity implements GrantedAuthority {

    @NotEmpty(message = "Can not create a role with no name!")
    @Column(name = "roles", nullable = false, unique = true)
    private String name;

    public Role() { }
    public Role(String name){ this.name = name; }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
