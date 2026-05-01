package com.simonmov.MonitoreoFlotas.repository;

import com.simonmov.MonitoreoFlotas.domain.Role;
import com.simonmov.MonitoreoFlotas.enums.RoleList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {

    Optional<Role> findByName(RoleList name);
}
