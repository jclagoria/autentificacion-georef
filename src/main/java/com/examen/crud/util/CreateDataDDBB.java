package com.examen.crud.util;

import com.examen.crud.entity.Usuario;
import com.examen.crud.enums.RolNombre;
import com.examen.crud.service.UsuarioService;
import com.examen.crud.entity.Rol;
import com.examen.crud.service.RolService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class CreateDataDDBB implements CommandLineRunner {

    private RolService rolService;
    private UsuarioService usuarioService;
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        createRol();
        createUser();
    }

    private void createRol() {
        Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
        Rol rolUser = new Rol(RolNombre.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
    }

    private void createUser() {

        Usuario usuario =
                new Usuario("usuario test", "usuarioTest", "usuariotest@gmail.com",
                        passwordEncoder.encode("pass1234"));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);

    }

}
