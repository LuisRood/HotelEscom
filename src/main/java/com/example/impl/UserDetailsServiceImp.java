/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.impl;

import com.example.dao.PersonaDao;
import com.example.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author LuisRodríguez
 */
@Service
public class UserDetailsServiceImp implements UserDetailsService{

    @Autowired
    private PersonaDao personaDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona = this.personaDao.findByUsuario(username);
        if(persona == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return persona;
    }
    
}
