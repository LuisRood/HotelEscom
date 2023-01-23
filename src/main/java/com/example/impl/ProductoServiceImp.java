/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.impl;

import com.example.dao.ProductoDao;
import com.example.domain.Producto;
import com.example.services.ProductoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LuisRodríguez
 */
@Service
public class ProductoServiceImp implements ProductoService{
    @Autowired
    public ProductoDao productoDao;

    @Override
    public Producto saveProducto(Producto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Optional<Producto> getProducto(Integer id) {
        return productoDao.findById(id);
    }

    @Override
    public List<Producto> getProductos() {
        return productoDao.findAll();
    }
    
    
}
