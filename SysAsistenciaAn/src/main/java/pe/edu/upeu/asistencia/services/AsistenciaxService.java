/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.asistencia.services;

import java.util.List;
import java.util.Map;
import pe.edu.upeu.asistencia.dtos.AsistenciaxDto;
import pe.edu.upeu.asistencia.models.Asistenciax;

/**
 *
 * @author DELL
 */
public interface AsistenciaxService {
    Asistenciax save(AsistenciaxDto.AsistenciaxCrearDto entidad);

    List<Asistenciax> findAll();

    Map<String, Boolean> delete(Long id);

    List<Asistenciax> getEntidadById(Long id);
    
    Asistenciax getEntidadByIdent(Long id);

    Asistenciax update(AsistenciaxDto.AsistenciaxCrearDto entidad, Long id);     
}
