/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.services;

import com.example.domain.Consumo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author LuisRodríguez
 */
public interface ConsumoService {
    public Optional<Consumo> getConsumo(Integer id);
    public List<Consumo> getConsumos();
}
