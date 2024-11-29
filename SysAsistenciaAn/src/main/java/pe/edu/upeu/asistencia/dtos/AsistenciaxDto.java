/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.asistencia.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.asistencia.models.Actividad;

/**
 *
 * @author DELL
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AsistenciaxDto {
  Long id;  
  @JsonFormat(pattern = "yyyy-MM-dd")
  LocalDate fecha;  
  @JsonFormat(pattern = "HH:mm:ss")
  LocalTime horaReg;
  String latituda;
  String longituda;  
  String tipo;
  int calificacion;
  String cui;
  String tipoCui; 
  String entsal;
  Long subactasisId;
  String offlinex;  
  @JsonIgnoreProperties({"asistenciaxs", "inscritos", "subactasisxs", "materialesxs"})
  Actividad actividadId; 
  
  public record AsistenciaxCrearDto(Long id,LocalDate fecha, LocalTime horaReg,
        String latituda,String longituda,String tipo,int calificacion, String cui,String tipoCui, String entsal,
        Long subactasisId, String offlinex,  Long actividadId){}
}
