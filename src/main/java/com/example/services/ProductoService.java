/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.services;

import com.example.domain.Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author LuisRodríguez
 */
public interface ProductoService {
    public Producto saveProducto(Producto producto);
    public Optional<Producto> getProducto(Integer id);
    public List<Producto> getProductos();
}
