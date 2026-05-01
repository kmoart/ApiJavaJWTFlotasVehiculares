package com.simonmov.MonitoreoFlotas.repository;

import com.simonmov.MonitoreoFlotas.domain.User;
import com.simonmov.MonitoreoFlotas.enums.RoleList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    Optional<User> findByUserName(String userName);

    boolean existsByUserName(String userName);
}
