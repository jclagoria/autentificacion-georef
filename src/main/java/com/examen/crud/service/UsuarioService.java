package com.examen.crud.service;

import com.examen.crud.entity.Usuario;
import com.examen.crud.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
/**
 * Clase por la cual se permite el acceso a los datos de un Usuario en la base de datos, en este caso.
 * @author: jclagoria
 */
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    /**
     * Metodo por el cual se optiene un Optional<Usuario> segun el nombre ingresado
     * Posibles valores, pueden retornar un objeto de tipoOptional<Usuario> con los
     * datos del usuario encontrado o un objeto nullo.
     *
     * @param nombreUsuario
     * @return Optional<Usuario>
     */
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    /**
     * Metodo apra validar si un usuario ya se encuentra registrado en el sistema con
     * ese nombre de usuario
     * Posibles valores:
     * False: Si no existe el usario
     * true: si existe.
     *
     * @param nombreUsuario
     * @return boolean
     */
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    /**
     * Metodo apra validar si el mail que reporta el usaurio
     * ya se encuentra registrado en el sistema.
     * Posibles valores:
     * False: Si no existe el usario
     * true: si existe.
     *
     * @param email
     * @return boolean
     */
    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    /**
     * Metodo por la cual se registra en la base de datos un nuevo usuario.
     * Espera como parametro un objeto de tipo Usuario en el cual contiene
     * toda la informacion de dicho usuario.
     *
     * @param usuario
     */
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
