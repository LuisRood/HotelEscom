/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author LuisRodríguez
 */
@Entity
@Table(name = "Persona")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class
//        , property = "id")
public class Persona implements Serializable,UserDetails{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "apellidoP",nullable = false)
    private String apellidoP;
    @Column(name = "apellidoM", nullable = false)
    private String apellidoM;
    @Column(name = "correo",nullable = false, unique = true)
    private String correo;
    @Column(name = "telefono",nullable = false,unique = true)
    private String telefono;
    @Column(name = "contrasenia",nullable = false)
    private String contrasenia;
    @Column(name = "usuario",nullable = false,unique = true)
    private String usuario;

    @ManyToMany( fetch = FetchType.EAGER, targetEntity = Rol.class)
    @JoinTable(name = "Personarol",
            joinColumns = { @JoinColumn(name = "idpersona") },
            inverseJoinColumns = { @JoinColumn(name = "idrol") })
        @JsonIgnoreProperties("personaRol")
    //@JsonManagedReference
    private Set<Rol> personaRol = new HashSet<>();
    
    @OneToOne(mappedBy = "idpersona"   , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("idpersona")
    //@JsonIgnore
    @JsonManagedReference
    private Empleado empleado;
    //@JsonIgnore
    @OneToOne(mappedBy = "idpersona"   , fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JsonIgnoreProperties("idpersona")
    @JsonManagedReference
    private Cliente cliente;

    public Persona() {
    }

    public Persona(Integer id, String nombre, String apellidoP, String apellidoM, String correo, String telefono, String contrasenia, String usuario, Empleado empleado) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.usuario = usuario;
        this.empleado = empleado;
    }

    public Set<Rol> getPersonaRol() {
        return personaRol;
    }

    public void setPersonaRol(Set<Rol> personaRol) {
        this.personaRol = personaRol;
    }
   
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /*public String getContrasenia() {
        return contrasenia;
    }*/

    public void setPassword(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /*public String getUsuario() {
        return usuario;
    }*/

    public void setUsername(String usuario) {
        this.usuario = usuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> authorities = new HashSet<>();
        this.personaRol.forEach(rol->{
            authorities.add(new Authority(rol.getDescripcion()));
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.contrasenia;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    
}
