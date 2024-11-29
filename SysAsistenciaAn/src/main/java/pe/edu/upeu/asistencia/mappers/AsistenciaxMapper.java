/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.asistencia.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.upeu.asistencia.dtos.AsistenciaxDto;
import pe.edu.upeu.asistencia.models.Asistenciax;

/**
 *
 * @author DELL
 */
@Mapper(componentModel = "spring")
public interface AsistenciaxMapper {
    
    AsistenciaxDto toAsistenciaxDto(Asistenciax endtidad);
    
    @Mapping(target = "actividadId", ignore = true)
    Asistenciax asistenciaxCrearDtoToAsistenciax(AsistenciaxDto.AsistenciaxCrearDto entidadCrearDto);
    
}
