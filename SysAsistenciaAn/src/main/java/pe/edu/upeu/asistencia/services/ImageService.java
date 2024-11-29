/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.asistencia.services;

import java.io.IOException;
import java.util.Base64;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.upeu.asistencia.exceptions.AppException;
import pe.edu.upeu.asistencia.models.Image;
import pe.edu.upeu.asistencia.repositories.ImageRepository;

/**
 *
 * @author DELL
 */
@RequiredArgsConstructor
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void saveImage(MultipartFile file) throws IOException {
        Image img = new Image();
        img.setName(file.getOriginalFilename());
        img.setType(file.getContentType());
        
        //byte[] bytes = file.getBytes();
        //String encodedString = Base64.getEncoder().encodeToString(bytes);
        
        img.setPic(file.getBytes());
        System.out.println("nombre:"+file.getOriginalFilename());
        try {
            imageRepository.save(img);
        } catch (Exception e) {
            System.out.println("v:"+e.getMessage());
        }
        
    }
    
    public Image findById(long id) {
        Image user = imageRepository.findById(id)
            .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
    return user;
    }
}

