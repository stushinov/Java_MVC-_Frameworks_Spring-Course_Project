package org.tushinov.auth.service;

import org.tushinov.auth.model.service.RoleServiceModel;

public interface RoleService {

    RoleServiceModel findRoleByName(String name);
}
