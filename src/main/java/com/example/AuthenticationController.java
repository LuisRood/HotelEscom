/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import com.example.configuration.JwtUtils;
import com.example.domain.JwtRequest;
import com.example.domain.JwtResponse;
import com.example.domain.Persona;
import com.example.impl.UserDetailsServiceImp;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LuisRodríguez
 */
@CrossOrigin(origins = "*",maxAge=3600)
@RestController
@RequestMapping("/")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserDetailsServiceImp userDetailsService;
    
    @Autowired
    private JwtUtils jwtUtils;
    
    //@PostMapping("/generate-token")
    @RequestMapping(value="/generate-token",method=RequestMethod.POST)
    /*Metodo para generar nuestro token*/
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        /*Nuestro dominio recibe un usuario y una contraseña*/
        try{
            /*Tratamos de autenticar, con nuestor usuario y contraseña*/
            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (Exception exception){
            exception.printStackTrace();
            throw new Exception("Usuario no encontrado");
        }
        /*Obtenemos los datos de nuestro usuario*/
        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        /*Generamos un token*/
        String token = this.jwtUtils.generateToken(userDetails);
        /*Devolvemos que se genero correctamente nuestro token*/
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void autenticar(String username,String password) throws Exception {
        try{
            /*Utilizamos la interfaz AuthenticationManager para validar nuestras credenciales*/
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }
    }
    //@GetMapping("/actual-usuario")
    @RequestMapping(value="/actual-usuario",method=RequestMethod.GET)
    /*Clase para obtener el usuario que esta loggeado actualmente*/
    public Persona obtenerUsuarioActual(Principal principal){
        return (Persona) this.userDetailsService.loadUserByUsername(principal.getName());
    }
}
