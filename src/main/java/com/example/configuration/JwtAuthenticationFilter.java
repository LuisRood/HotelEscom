/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.configuration;

import com.example.impl.UserDetailsServiceImp;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author LuisRodríguez
 */
@Component
/*Interceptamos las solucitudes al servidor*/
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    @Autowired
    private UserDetailsServiceImp userDetailsService;
    @Autowired
    private JwtUtils jwtUtils;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*Hash utilizado para encriptar el Token*/
        String requestTokenHeader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;
        
        /*Si nuestro token contiente algo y al mismo tiempo empieza con "Bearer "(Es un tipo de token)*/
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            /*Lo unico que hacemos es quitar la parte de Bearer a nuestro token*/
            jwtToken = requestTokenHeader.substring(7);
            try{
                /*De nuestra clase JwtUtils llamamos a extractUsername para obtener nuestro usuario*/
                username = this.jwtUtils.extractUsername(jwtToken);
            }catch (ExpiredJwtException exception){
                System.out.println("El token ha expirado");
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            System.out.println("Token invalido , no empieza con bearer string");
        }
        /*Si nuestro usuario es diferente de nulo y que las credenciales sean nulas*/
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            /*Le pasamos los detalles y validamos si existe el usuario*/
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            /*Validamos el token con el userDetails*/
            if(this.jwtUtils.validateToken(jwtToken,userDetails)){
                /*Ahora creamos una instacia de usernamepaswdauthentoken y le pasamos userDetails, las credenciales nulas
                y ahora si le pasamos las credenciales/roles*/ 
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                /*Establecemos los detalles y le pasamos el request del Servlet*/
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                /*Establecemos una autenticacion y le pasamos el token del usuario*/
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }else{
            System.out.println("El token no es valido");
        }
        /*Ejecutamos el filtro*/
        filterChain.doFilter(request,response);
    }
}
