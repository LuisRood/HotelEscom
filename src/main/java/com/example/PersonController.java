
package com.example;

import com.example.dao.PersonaDao;
import com.example.domain.Persona;
import com.example.services.PersonaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/personas")
public class PersonController {
    @Autowired
    private PersonaDao personadao;
    @Autowired
    private PersonaService personaService;
    //@GetMapping
    @RequestMapping(value="/",method=RequestMethod.GET)
    public List<Persona> list(){
        return personaService.getPersonas();
        //return personadao.findAll();
    }
    //@PostMapping
    @RequestMapping(value="/",method=RequestMethod.POST)
    public Persona add(@RequestBody Persona p){
        return personadao.save(p);
    }
    //@GetMapping("/{id}")
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Optional<Persona> listId(@PathVariable("id")int id){
        return personadao.findById(id);
    }
    //@PutMapping(path = {"/{id}"})
    @RequestMapping(value="/{id}",method=RequestMethod.PUT)
    public Persona edit(@RequestBody Persona p,@PathVariable("id")int id){
        personadao.findById(id);
        return personadao.save(p);
    }
    //@DeleteMapping(path = "/{id}")
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable("id")int id){
        personadao.deleteById(id);
    }
}
