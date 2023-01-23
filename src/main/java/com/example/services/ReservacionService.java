/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.services;

import com.example.domain.Reservacion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author LuisRodríguez
 */
public interface ReservacionService {
    public Optional<Reservacion> getReservacion(Integer id);
    public Reservacion doReservacion(Reservacion reservacion);
    public List<Reservacion> getReservacionByCliente(Integer id);
}
