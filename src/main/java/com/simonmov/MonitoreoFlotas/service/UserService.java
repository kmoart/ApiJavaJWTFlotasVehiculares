package com.simonmov.MonitoreoFlotas.service;

import com.simonmov.MonitoreoFlotas.domain.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findById(Integer id);

    Iterable<User> findAll();

    User save(User user);

    void deleteById(Integer id);
}
