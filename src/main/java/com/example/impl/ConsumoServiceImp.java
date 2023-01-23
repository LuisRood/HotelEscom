/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.impl;

import com.example.dao.ConsumoDao;
import com.example.domain.Consumo;
import com.example.services.ConsumoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LuisRodríguez
 */
@Service
public class ConsumoServiceImp implements  ConsumoService{
    @Autowired
    ConsumoDao consumoDao;
    @Override
    public Optional<Consumo> getConsumo(Integer id) {
        return consumoDao.findById(id);
    }

    @Override
    public List<Consumo> getConsumos() {
        return consumoDao.findAll();
    }
    
}
