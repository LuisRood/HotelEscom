/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.impl;

import com.example.domain.Empleado;
import com.example.services.EmpleadoService;
import com.example.dao.EmpleadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LuisRodríguez
 */
@Service
public class EmpleadoServiceImp implements EmpleadoService{

    @Autowired
    private EmpleadoDao empleadoDao;
    
    @Override
    public Empleado saveEmpleado(Empleado empleado) throws Exception {
        Empleado empleadoTemp = null;
        return empleadoTemp;
    }

    @Override
    public Empleado getEmpleado(String empleado) {
        return null;
    }

    @Override
    public void deleteEmpleado(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
