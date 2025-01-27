package com.carga.ficheros.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;

@Entity
@Table(name = "Libros")


    public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    public Libro(){
        }

        public Libro(Long id, String nombre, String categoria){
        this.id=id;
        this.nombre=nombre;
        this.categoria=categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
