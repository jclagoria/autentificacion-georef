package com.examen.crud.controller;

import com.examen.crud.dto.MensajeDto;
import com.examen.crud.dto.NuevoUsuarioDto;
import com.examen.crud.entity.Usuario;
import com.examen.crud.enums.RolNombre;
import com.examen.crud.security.jwt.JwtProvider;
import com.examen.crud.service.UsuarioService;
import com.examen.crud.dto.JwtDto;
import com.examen.crud.dto.LoginUsuarioDto;
import com.examen.crud.entity.Rol;
import com.examen.crud.service.RolService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@CrossOrigin
public class AuthController {

    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private UsuarioService usuarioService;
    private RolService rolService;
    private JwtProvider jwtProvider;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuarioDto nuevoUsuario, BindingResult bindingResult){

        logger.info("AuthController --> nuevo ");

        if(bindingResult.hasErrors()) {
            logger.error("Datos no validos, por favor valide los mismos.");
            return new ResponseEntity(new MensajeDto("Datos no validos, por favor valide los mismos."), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            logger.error("Nombre usuario ya existente");
            return new ResponseEntity(new MensajeDto("Nombre usuario ya existente"), HttpStatus.BAD_REQUEST);
        }
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            logger.error("Ese email ya existe");
            return new ResponseEntity(new MensajeDto("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        }
        Usuario usuario =
                new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getEmail(),
                        passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());

        usuario.setRoles(roles);

        usuarioService.save(usuario);
        return new ResponseEntity(new MensajeDto("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuarioDto loginUsuario, BindingResult bindingResult){

        logger.info("AuthController --> login ");

        if(bindingResult.hasErrors()) {
            logger.error("Datos no validos, ingreese nuevamente sus datos");
            return new ResponseEntity(new MensajeDto("Datos no validos, ingreese nuevamente sus datos"), HttpStatus.BAD_REQUEST);
        }

        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
