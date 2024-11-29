/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.asistencia.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.asistencia.models.Image;
import pe.edu.upeu.asistencia.services.ImageService;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/image")
public class ImageController {


    
    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        // Lógica para guardar la imagen           
        try {
        String fileName = file.getOriginalFilename();

        Path filePath = Paths.get(fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);            
            imageService.saveImage(file);
        } catch (Exception e) {
            System.err.println("Error:"+e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Imagen guardada con éxito");
    }

    // Otros métodos REST si son necesarios
    @GetMapping("/get/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        Image imageData = imageService.findById(id);

        if (imageData!=null) {
            Image img = imageData;
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.parseMediaType(String.valueOf(img.getType())))
                    .body(img.getPic());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
