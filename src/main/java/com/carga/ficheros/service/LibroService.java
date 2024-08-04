package com.carga.ficheros.service;

import com.carga.ficheros.model.Libro;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface LibroService {

     Libro save(Libro libro, MultipartFile file) throws IOException;

    List<Libro> getLibro(); //obtener todos los ficheros en una lista

    Libro get(Long id); // obtiene un solo fichero por  su id

    Libro update(Long id, Libro libro, MultipartFile file) throws IOException; // metodo para actualizar un fichero

    void delete(Long id); //borra un fichero por su id


}
