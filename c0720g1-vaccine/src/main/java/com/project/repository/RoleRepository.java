package com.project.repository;

import com.project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {

    /**
     *LuyenNT code
     */
    @Query(value = "select * from role",nativeQuery = true)
    List<Role> finAllRole();

    /**
     *Nguyen Van Linh
     */
    @Modifying
    @Query(value = "insert into account_role(account_id,role_id) values (?1,?2)", nativeQuery = true)
    void setDefaultRole(int accountId, Integer roleId);
}
