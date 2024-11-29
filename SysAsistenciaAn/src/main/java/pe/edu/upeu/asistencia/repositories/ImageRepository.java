/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.asistencia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.asistencia.models.Image;

/**
 *
 * @author DELL
 */
public interface ImageRepository extends JpaRepository<Image, Long>{
    
}
