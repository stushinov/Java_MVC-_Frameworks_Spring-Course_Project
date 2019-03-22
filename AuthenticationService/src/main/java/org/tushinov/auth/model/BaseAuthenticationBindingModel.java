package org.tushinov.auth.model;

public abstract class BaseAuthenticationBindingModel {

    private String username, password;

    public final String getUsername() {
        return this.username;
    }

    public final String getPassword() {
        return this.password;
    }
}
