package com.carga.ficheros.service;

import com.carga.ficheros.model.Libro;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LibroService {

    Libro save(Libro libro, MultipartFile file);

    List<Libro> getLibro();

    Libro get(Long id);

    Libro update(Long id, Libro libro, MultipartFile file);

    void delete(Long id);


}
