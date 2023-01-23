/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.impl;

import com.example.dao.PersonaDao;
import com.example.dao.RolDao;
import com.example.domain.Persona;
import com.example.domain.Rol;
import com.example.services.PersonaService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LuisRodríguez
 */
@Service
public class PersonaServiceImp implements PersonaService{
    
    @Autowired
    private PersonaDao personaDao;
    @Autowired
    private RolDao roldao;
    
    @Override
    public Persona savePersona(Persona persona,Set<Rol> personaRoles) throws Exception {
        Persona personaTemp = personaDao.findByUsuario(persona.getUsername());
        if(personaTemp != null){
            System.out.println("La persona ya existe");
            throw new Exception("La persona ya existe");
        }else{
            for(Rol personaRol:personaRoles){
                roldao.save(personaRol);
            }
            persona.getPersonaRol().addAll(personaRoles);
            personaTemp = personaDao.save(persona);
        }
        return personaTemp;
    }
    @Override
    public Persona updatePersonaPersona(Persona persona, Set<Rol> personaRoles) throws Exception {
        Persona personaTemp = personaDao.findByUsuario(persona.getUsername());
        if(personaTemp == null){
            System.out.println("La persona no existe");
            throw new Exception("La persona no existe");
        }else{
            
            persona.getPersonaRol().addAll(personaRoles);
            personaTemp = personaDao.save(persona);
        }
        return personaTemp;
    }

    @Override
    public Persona getPersona(String persona) {
        return personaDao.findByUsuario(persona);
    }

    @Override
    public void deletePersona(Integer id) {
        personaDao.deleteById(id);
    }

    @Override
    public List<Persona> getPersonas() {
        return  personaDao.findAll();
    }

    
}
