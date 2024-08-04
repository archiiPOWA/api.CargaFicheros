package com.carga.ficheros.service;

import com.carga.ficheros.model.Libro;
import com.carga.ficheros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService {


    @Autowired
    LibroRepository libroRepository;

    @Autowired
    UploadService uploadService;

    String url = "http://localhost:8080/upload/";

    //METODO PARA GUARDAR LIBRO
    @Override
    public Libro save(Libro libro, MultipartFile file) throws IOException {
        String nombre = uploadService.saveUpload(file);
        libro.setNombre(nombre);
        return libroRepository.save(libro);
    }
//METODO PARA OBTENER LISTA DE LIBROS
    @Override
    public List<Libro> getLibro() {
        List<Libro> libros = libroRepository.findAll();
        libros = libros.stream().map(libro -> {
            libro.setNombre(url + libro.getNombre());
            return libro;
        }).collect(Collectors.toList());
        return libros;
    }

 //METODO PARA OBTENER LIBRO POR ID
    @Override
    public Libro get(Long id) {
        Libro libro = libroRepository.findById(id).get(); //cree variable libro que busca por  su parametro id y lo obtiene con metodo get
        libro.setNombre(url + libro.getNombre() ); //ahora en la varible libro seteamos url + el nombre que se obtiene a traves del metodo
        return libro;
    }
 //METODO PARA ACTUALIZAR UN LIBRO
    @Override
    public Libro update(Long id, Libro libro, MultipartFile file) throws IOException{
        libro.setId(id); //primero le paso el id
        String nombre = uploadService.saveUpload(file); // cargo la variable nombre con el archivo guardado
        //validacion para eliminar el archivo modificado
        Libro libro1 = libroRepository.findById().get(); //obtengo su id
        if(!libro.getNombre().equals(nombre)){ //si libro tiene distintos nombres
            uploadService.deleteUpload(libro1.getNombre()); //borra el libro que fue modificado
        }
        libro.setNombre(nombre); // modificar el nombre
        return libroRepository.save(libro);
    }
//METODO PARA ELIMINAR UN LIBRO
    @Override
    public void delete(Long id) {
        Libro libro = libroRepository.findById(id).get(); // creo un libro y recibe el id
        String nombre = libro.getNombre(); //obtenemos el nombre del libro que vamos a eliminar
        libroRepository.delete(libro);

    }
}
