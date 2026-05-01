package com.simonmov.MonitoreoFlotas.service;

import com.simonmov.MonitoreoFlotas.domain.Role;
import com.simonmov.MonitoreoFlotas.domain.User;
import com.simonmov.MonitoreoFlotas.dtos.NewUserDto;
import com.simonmov.MonitoreoFlotas.enums.RoleList;
import com.simonmov.MonitoreoFlotas.jwt.JwtUtil;
import com.simonmov.MonitoreoFlotas.repository.RoleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserServiceSecurity userServiceSecurity;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtUtil;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthService(UserServiceSecurity userServiceSecurity,
                       RoleRepository roleRepository,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil,
                       AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userServiceSecurity = userServiceSecurity;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public String authenticate(String username, String password){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username,password);

        Authentication authResult =
                authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authResult);

         return jwtUtil.generateToken(authResult);

    }

    public void registerUser(NewUserDto newUserDto){
        if(userServiceSecurity.existByUserName(newUserDto.getUserName())){
            throw new IllegalArgumentException("El nombre de usuario ya existe");
        }

        Role roleUser = roleRepository.findByName(RoleList.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role no encontrado"));

        User user = new User(newUserDto.getUserName(),
                passwordEncoder.encode(newUserDto.getPassword()),roleUser);

        userServiceSecurity.save(user);
    }
}
