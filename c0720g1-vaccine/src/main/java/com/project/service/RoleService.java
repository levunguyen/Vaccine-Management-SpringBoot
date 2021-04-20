package com.project.service;

import com.project.entity.Role;

import java.util.List;

public interface RoleService {
    /**
     * HungDH
     */
    List<Role> findAllRole();


    /**
     * LuyenNT
     *Nguyen Van Linh
     */
    void setDefaultRole(int accountId, Integer roleId);



    /**
     * LuyenNT
     *
     * @return
     */
    List<Role> getAllRoles();


}
