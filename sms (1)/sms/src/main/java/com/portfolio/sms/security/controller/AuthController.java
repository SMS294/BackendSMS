package com.portfolio.sms.security.controller;

import com.portfolio.sms.security.dto.JwtDto;
import com.portfolio.sms.security.dto.LoginUsuario;
import com.portfolio.sms.security.dto.NuevoUsuario;
import com.portfolio.sms.security.entity.Rol;
import com.portfolio.sms.security.entity.Usuario;
import com.portfolio.sms.security.enums.RolNombre;
import com.portfolio.sms.security.jwt.JwtProvider;
import com.portfolio.sms.security.service.RolService;
import com.portfolio.sms.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity( new Mensaje( "campos mal puestos o email invalido" ), HttpStatus.BAD_REQUEST );

        if (usuarioService.existsByNombreUsuario( nuevoUsuario.getNombreUsuario() ))
            return new ResponseEntity( new Mensaje( "Ese nombre de usuario ya existe" ), HttpStatus.BAD_REQUEST );

        if (usuarioService.existsByEmail( nuevoUsuario.getEmail() ))
            return new ResponseEntity( new Mensaje( "Ese email ya existe" ), HttpStatus.BAD_REQUEST );

        Usuario usuario =
                new Usuario( nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario()
                        , nuevoUsuario.getEmail(),
                        passwordEncoder.encode( nuevoUsuario.getPassword() ) );

        Set<Rol> roles = new HashSet<>();
        roles.add( rolService.getByRolNombre( RolNombre.ROLE_USER ).get() );

        if (nuevoUsuario.getRoles().contains( "admin" ))
            roles.add( rolService.getByRolNombre( RolNombre.ROLE_ADMIN ).get() );
        usuario.setRoles( roles );
        usuarioService.save( usuario );

        return new ResponseEntity( new Mensaje( "Usuario guardado" ), HttpStatus.CREATED );

    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity( new Mensaje( "campos mal puestos" ), HttpStatus.BAD_REQUEST );

        Authentication authentication =
                authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                        loginUsuario.getNombreUsuario(), loginUsuario.getPassword() ) );

        SecurityContextHolder.getContext().setAuthentication( authentication );
        String jwt = jwtProvider.generateToken( authentication );

        JwtDto jwtDto = new JwtDto( jwt );

        return new ResponseEntity<>( jwtDto, HttpStatus.OK );
    }

}