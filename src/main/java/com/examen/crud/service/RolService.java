package com.examen.crud.service;

import com.examen.crud.enums.RolNombre;
import com.examen.crud.repository.RolRepository;
import com.examen.crud.entity.Rol;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
/**
 * Clase por la cual se permite la administracion de los Roles definidos en el sistema.
 * @author: jclagoria
 */
public class RolService {

    private RolRepository rolRepository;

    /**
     * Metodo por el cual se obtienen un objeto de tipo Optional<Rol> segun el nombre del rol.
     * El parametro de entrada para la busqeuda es de tipo Enum
     *      *
     * @param rolNombre
     * @return Optional<Rol>
     */
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    /**
     *
     *
     * @param rol
     */
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
