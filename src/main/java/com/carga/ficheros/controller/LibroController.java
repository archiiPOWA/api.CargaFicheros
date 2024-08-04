package com.carga.ficheros.controller;


import com.carga.ficheros.model.Libro;
import com.carga.ficheros.repository.LibroRepository;
import com.carga.ficheros.service.LibroService;
import com.carga.ficheros.service.LibroServiceImpl;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LibroController {

    @Autowired
    LibroService libroService;

  @PostMapping("/libro")
    public ResponseEntity<Libro> saveLibro(@RequestPart Libro libro, @RequestPart MultipartFile file) throws IOException {
      return new ResponseEntity<>(libroService.save(libro, file), HttpStatus.CREATED);
  }

@GetMapping("/libro")
    public ResponseEntity<List<Libro>> setLibro(){
      return new ResponseEntity<>(libroService.getLibro(), HttpStatus.OK);
}

@GetMapping("/libro/{id}")
    public ResponseEntity<Libro> getLibro(@PathVariable Long id){
      return new ResponseEntity<>(libroService.get(id), HttpStatus.OK);
}

@PutMapping("/libro/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestPart Libro libro, @RequestPart MultipartFile file) throws IOException{
      return new ResponseEntity<>(libroService.update(id, libro, file), HttpStatus.OK);
}

@DeleteMapping("/libro/{id}")
    public ResponseEntity<Libro> deleteLibro(@PathVariable Long id){
    libroService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
}


}



