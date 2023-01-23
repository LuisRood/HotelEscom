/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import com.example.dao.ClienteDao;
import com.example.dao.HabitacionDao;
import com.example.dao.ReservacionDao;
import com.example.domain.Cliente;
import com.example.domain.Habitacion;
import com.example.domain.Reservacion;
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
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/reservacion")
public class ReservacionController {
    @Autowired
    public ReservacionDao reservacionDao;
    @Autowired
    public HabitacionDao habitacionDao;
    @Autowired
    public ClienteDao clienteDao;
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Reservacion saveReservacion(@RequestBody Reservacion reservacion){
        System.out.println("Desde aqui");
        for(Habitacion habitacion:reservacion.getContieneHabitaciones()){
            habitacion.setDisponible(0);
        }
        return reservacionDao.save(reservacion);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public List<Reservacion> getReservacionCliente(@PathVariable("id") int id){
        Optional<Cliente> cliente = clienteDao.findById(id);
        return reservacionDao.findByCliente(cliente.get());
    }
    
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void borrarReservacion(@PathVariable("id") int id){
        Optional<Reservacion> reservacion = reservacionDao.findById(id);
        Optional<Cliente> cliente = clienteDao.findById(reservacion.get().getCliente().getId());
        reservacionDao.deleteReservacion(cliente.get().getId(), reservacion.get().getFechainicial(), id);
    }
}
