package com.api.crud.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.UsuarioModel;
import com.api.crud.services.UsuarioService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping()
    public ArrayList<UsuarioModel> getUsuarios(){
        return this.usuarioService.getUsuarios();
    }
    
    @PostMapping()
    public UsuarioModel saveUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.saveUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Optional<UsuarioModel> getUsuarioById(@PathVariable("id") Long id){
        return this.usuarioService.getById(id);
    }

    @PutMapping("/{id}")
    public UsuarioModel updateUsuairoById(@RequestBody UsuarioModel request, @PathVariable("id") Long id){
        return this.usuarioService.updateById(request, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUsuarioById(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.deleteUsuario(id);

        if(ok){
            return "El usuario con id: " + id + " fue eliminado";
        }else{
            return "El usuario con el id: " + id + " no ha podido ser eliminado.";
        }
    }
    
}
