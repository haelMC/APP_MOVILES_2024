/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.asistencia.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.asistencia.dtos.AsistenciaxDto;
import pe.edu.upeu.asistencia.exceptions.AppException;
import pe.edu.upeu.asistencia.exceptions.ResourceNotFoundException;
import pe.edu.upeu.asistencia.mappers.AsistenciaxMapper;
import pe.edu.upeu.asistencia.models.Asistenciax;
import pe.edu.upeu.asistencia.repositories.AsistenciaxRepository;

/**
 *
 * @author DELL
 */
@RequiredArgsConstructor
@Service
@Transactional
public class AsistenciaxServiceImp implements AsistenciaxService{

    @Autowired
    private AsistenciaxRepository asisRepository;
    
    @Autowired
    private ActividadService actividadService;
    
    private final AsistenciaxMapper asistenciaxMapper;
    
    @Override
    public Asistenciax save(AsistenciaxDto.AsistenciaxCrearDto entidad) {
               Asistenciax varEnt=asistenciaxMapper.asistenciaxCrearDtoToAsistenciax(entidad);
        varEnt.setActividadId(actividadService.getActividadById(entidad.actividadId()));

        try {
            return asisRepository.save(varEnt);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Asistenciax> findAll() {
            try {
            return asisRepository.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Asistenciax entidadx = asisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materialesx not exist with id :" + id));

        asisRepository.delete(entidadx);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;       
    }

    @Override
    public List<Asistenciax> getEntidadById(Long id) {        
        try {
            return asisRepository.findByActividadId(id);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }              
    }
   
    @Override
   public Asistenciax getEntidadByIdent(Long id) {        
        Asistenciax findActividad = asisRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Activiad not exist with id :" + id));
        return findActividad;                  
    }

    @Override
    public Asistenciax update(AsistenciaxDto.AsistenciaxCrearDto entidad, Long id) {
        Asistenciax entidadx = asisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo not exist with id :" + id));
        entidadx.setFecha(entidad.fecha());
        entidadx.setHoraReg(entidad.horaReg());
        entidadx.setOfflinex(entidad.offlinex());
        return asisRepository.save(entidadx);        
    }
    
}
