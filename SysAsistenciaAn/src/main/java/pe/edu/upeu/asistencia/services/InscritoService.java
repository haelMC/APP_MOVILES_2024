/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.asistencia.services;

import java.util.List;
import java.util.Map;
import pe.edu.upeu.asistencia.models.Inscrito;

/**
 *
 * @author DELL
 */
public interface InscritoService {

    Inscrito save(Inscrito activiad);

    List<Inscrito> findAll();

    Map<String, Boolean> delete(Long id);

    Inscrito getEntidadById(Long id);

    Inscrito update(Inscrito activiad, Long id);
}
