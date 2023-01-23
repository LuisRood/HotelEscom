/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.dao;

import com.example.domain.Cliente;
import com.example.domain.Reservacion;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

/**
 *
 * @author LuisRodríguez
 */
public interface ReservacionDao extends JpaRepository<Reservacion, Integer>{
    public List<Reservacion> findByCliente(Cliente cliente);
    @Procedure("CancelarR")
    public void deleteReservacion(Integer id_cliente,Date fecha_inicial,Integer id_reservacion);
}
