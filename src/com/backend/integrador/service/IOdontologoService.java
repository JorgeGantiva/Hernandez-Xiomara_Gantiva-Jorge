package com.backend.integrador.service;


import com.backend.integrador.dto.entrada.modificacion.OdontologoModificacionEntradaDto;
import com.backend.integrador.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.integrador.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.integrador.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {
    List<OdontologoSalidaDto> listarOdontologos();


    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);

    OdontologoSalidaDto buscarOdontologoPorId(Long id);

    void eliminarOdontologo(Long id) throws ResourceNotFoundException;

    OdontologoSalidaDto actualizarOdontologo(OdontologoModificacionEntradaDto odontologoModificacionEntradaDto) throws ResourceNotFoundException;

}