/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author LuisRodríguez
 */
@Data
public class Authority implements GrantedAuthority{
    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }
    
    
}
