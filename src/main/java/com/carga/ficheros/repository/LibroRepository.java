package com.carga.ficheros.repository;

import com.carga.ficheros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository  extends JpaRepository<Libro,Long> {
}
