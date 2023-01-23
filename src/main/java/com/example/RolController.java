/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import com.example.dao.RolDao;
import com.example.domain.Rol;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LuisRodríguez
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private RolDao roldao;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Rol> list(){
        return (List<Rol>) roldao.findAll();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Optional<Rol> getRol(@PathVariable("id")int id){
        return roldao.findById(id);
    }
    
}
