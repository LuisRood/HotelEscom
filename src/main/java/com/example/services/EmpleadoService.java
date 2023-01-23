/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.services;

import com.example.domain.Empleado;

/**
 *
 * @author LuisRodríguez
 */
public interface EmpleadoService {
    public Empleado saveEmpleado(Empleado empleado) throws Exception;
    public Empleado getEmpleado(String empleado);
    public void deleteEmpleado(Integer id);
}
