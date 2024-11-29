/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.asistencia.controllers;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upeu.asistencia.dtos.AsistenciaxDto;
import pe.edu.upeu.asistencia.models.Asistenciax;
import pe.edu.upeu.asistencia.services.AsistenciaxService;
import pe.edu.upeu.asistencia.utils.ErrorLogger;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/asis/asistenciax")
public class AsistenciaxController {
    @Autowired
    private AsistenciaxService asistenciaxService;   
    
    ErrorLogger logg=new ErrorLogger("AsistenciaxController");
    
    Logger logger = LoggerFactory.getLogger(AsistenciaxController.class);
    
    @GetMapping(value = "/list")
    public ResponseEntity<List<Asistenciax>> listMaterialesx() {
        List<Asistenciax> actDto = asistenciaxService.findAll();
        return ResponseEntity.ok(actDto);
        // return new ResponseEntity<>(actDto, HttpStatus.OK);
    }  
    
    @PostMapping("/crear")
    public ResponseEntity<Asistenciax> createMaterialesx(@RequestBody AsistenciaxDto.AsistenciaxCrearDto entidadx) {   
        
        logger.info("VER:"+entidadx);
        Asistenciax data = asistenciaxService.save(entidadx);
        
        return ResponseEntity.ok(data);
    }    
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<Asistenciax>> getEntidadxById(@PathVariable Long id) {
        List<Asistenciax>  entidadx = asistenciaxService.getEntidadById(id);
        return ResponseEntity.ok(entidadx);
    }    
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMaterialesx(@PathVariable Long id) {
        Asistenciax entidadx = asistenciaxService.getEntidadByIdent(id);
        return ResponseEntity.ok(asistenciaxService.delete(entidadx.getId()));
    }   
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<Asistenciax> updateMaterialesx(@PathVariable Long id,
            @RequestBody AsistenciaxDto.AsistenciaxCrearDto entidadxDetails) {
        Asistenciax updatedEntidadx = asistenciaxService.update(entidadxDetails, id);
        return ResponseEntity.ok(updatedEntidadx);
    }    
}
