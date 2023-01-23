/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example;

import com.example.domain.Producto;
import com.example.services.ProductoService;
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
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @RequestMapping(value="/",method=RequestMethod.GET)
    public List<Producto> list(){
        return productoService.getProductos();
    }
    @RequestMapping(value="/",method=RequestMethod.POST)
    public Producto add(@RequestBody Producto producto){
        return productoService.saveProducto(producto);
    }
    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Optional<Producto> get(@PathVariable("id")int id){
        return productoService.getProducto(id);
    }
    
    
}
