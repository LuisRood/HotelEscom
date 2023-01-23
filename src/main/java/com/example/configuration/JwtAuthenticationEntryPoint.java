/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.configuration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author LuisRodríguez
 */
@Component
/*Interceptamos las solicitudes HTTP*/
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    /*Implementamos de AuthenticationEntryPoint por lo tanto implementamos el metodo commence
    el cual se encarga de evitar que los usuarios no accedan a un recurso donde no tienen
    permiso de acceder*/
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Usuario no autorizado");
    }
    
}
