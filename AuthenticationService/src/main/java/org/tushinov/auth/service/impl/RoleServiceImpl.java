package org.tushinov.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tushinov.auth.entity.Role;
import org.tushinov.auth.model.service.RoleServiceModel;
import org.tushinov.auth.repository.RoleRepository;
import org.tushinov.auth.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleServiceModel findRoleByName(String name) {
        Role role = this.roleRepository.findOneByName(name);
        RoleServiceModel roleServiceModel = new RoleServiceModel();
        roleServiceModel.setRoleId(role.getId());
        return roleServiceModel;
    }
}
