package org.tushinov.auth.model.binding;

public abstract class BaseAuthenticationBindingModel {

    private String username, email, password;

    public final String getUsername() {
        return this.username;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }
}
