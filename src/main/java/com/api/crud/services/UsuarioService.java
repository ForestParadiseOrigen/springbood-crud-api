package com.api.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.UsuarioModel;
import com.api.crud.repositories.IUsuarioRepository;

@Service
public class UsuarioService {
    
    // Realizamos la inyección de las dependencias que se importaron en IUsuarioRepository.
    @Autowired
    IUsuarioRepository usuarioRepository;

    // Encargado de trar a todos los usuarios de la base de datos.
    public ArrayList<UsuarioModel> getUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel saveUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> getById(Long id){
        return usuarioRepository.findById(id);
    }

    public UsuarioModel updateById(UsuarioModel request, Long id){
        UsuarioModel usuario = usuarioRepository.findById(id).get();

        usuario.setNombres(request.getNombres());
        usuario.setApellidos(request.getApellidos());
        usuario.setCargo(request.getCargo());
        usuario.setCorreo(request.getCorreo());

        return usuario;
    }

    public Boolean deleteUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
