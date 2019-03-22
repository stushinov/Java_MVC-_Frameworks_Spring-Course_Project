package org.tushinov.auth.model;

public class RegisterBindingModel extends BaseAuthenticationBindingModel {

    private String confirmPassword;

    public String getConfirmPassword() {
        return this.confirmPassword;
    }
}
