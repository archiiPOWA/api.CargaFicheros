package com.carga.ficheros.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;


@Service
public class UploadService {
    //En este servicio estan implementados los metodos para Guardar y Eliminar

    //METODO PARA GUARDAR
    private final String url = "upload/"; //creo la variable url con la direccion de la carpeta destino
    public String saveUpload(MultipartFile file) throws IOException{
      if(!file.isEmpty() ) {//validamos que no sea vacio
        byte [] bytes = file.getBytes(); //leo el archivo y lo guardo en un array deTipo byte
        String encode = URLEncoder.encode(Objects.requireNonNull(file.getOriginalFilename()), StandardCharsets.UTF_8 ); //con esta linea aseguramos que el nombre del  fichero no tenga espacios en blancos
        Path path = Paths.get(url +encode); //  creo la variable que obtiene la ruta del archivo con su nombre en encode en este caso
        Files.write(path, bytes); //escribe donde se guardan la ruta y los bytes del archivo
        return encode; //devolvemos el nombre del fichero
    }
    return null; //devolvera null si el archivo es vacio
    }

    //METODO PARA ELIMINAR ARCHIVO
    public void deleteUpload(String nombre){
        File file = new File(url + nombre);
        file.delete();
    }


}
