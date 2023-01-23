/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.services;

import com.example.domain.Persona;
import com.example.domain.Rol;
import java.util.List;
import java.util.Set;

/**
 *
 * @author LuisRodríguez
 */
public interface PersonaService {
    public Persona savePersona(Persona persona,Set<Rol> personaRoles) throws Exception;
    public Persona updatePersonaPersona(Persona persona,Set<Rol> personaRoles) throws Exception;
    public Persona getPersona(String persona);
    public List<Persona> getPersonas();
    public void deletePersona(Integer id);
    
}
