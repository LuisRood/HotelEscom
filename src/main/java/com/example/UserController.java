/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import com.example.dao.RolDao;
import com.example.domain.Persona;
import com.example.domain.Rol;
import com.example.services.PersonaService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author e-lfrodriguez
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private PersonaService personaService;
    @Autowired
    private RolDao roldao;
    //@PostMapping
    @RequestMapping(value="/",method=RequestMethod.POST)
    /*Metodo para guardar usuario*/
    public Persona guardarUsuario(@RequestBody Persona persona) throws Exception{
        persona.setPassword(passwordEncoder.encode(persona.getPassword()));
        Set<Rol> roles = new HashSet<>();
        persona.getPersonaRol().forEach(rol->{
            roles.add(rol);
        });
        return personaService.savePersona(persona, roles);
    }
    
    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public Persona actualizarUsuario(@RequestBody Persona persona,@PathVariable int id) throws Exception{
        Set<Rol> roles = new HashSet<>();
        persona.getPersonaRol().forEach(rol -> {
            roles.add(rol);
        });
        return personaService.updatePersonaPersona(persona, roles);
    }
    @GetMapping("/{username}")
    @RequestMapping(value="/{username}",method=RequestMethod.GET)
    public Persona obtenerUsuario(@PathVariable("username") String username){
        /*Aqui simplemente estamos obteniendo nuestro usuario a partir de su nombre de usuario*/
        return personaService.getPersona(username);
    }
    
    //@DeleteMapping("/{usuarioId}")
    @RequestMapping(value="/{usuarioId}",method=RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable("usuarioId") int usuarioId){
        /*Eliminamos al usuario a partir de su Id */
        personaService.deletePersona(usuarioId);
    }
    @RequestMapping(value="/cliente/",method=RequestMethod.POST)
    /*Metodo para guardar usuario*/
    public Persona guardarUsuarioCliente(@RequestBody Persona persona) throws Exception{
        /*Obtenemos la contraseña del usuario, para despues encriptarla y asignarla*/
        persona.setPassword(passwordEncoder.encode(persona.getPassword()));
        /*Creamos nuestro Set de UsuarioRol, para los roles del usuario*/
        Set<Rol> roles = new HashSet<>();
        /*Creamos un rol*/
        /*Nuestro registro solo permite guardar usuarios, mas no admisnitradores*/
        /*Creamos nuestro UsuarioRol*/
        /*Al cual le especifiamos nuestro usuario y el rol que tendra*/
        /*Y al final simplemente lo agregamos nuestro conjunto de usuarios-roles*/
        roles.add(roldao.findById(3).get());
        /*Y al final llamamos a nuestro servicio usuario y lo guardamos*/
        return personaService.savePersona(persona, roles);
    }
}
