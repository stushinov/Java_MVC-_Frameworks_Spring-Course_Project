package org.tushinov.auth.service;

import org.tushinov.auth.model.binding.RegisterBindingModel;

public interface UserService {
    void register(RegisterBindingModel registerBindingModel);
}
