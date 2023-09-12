package com.backend.integrador.service;

import com.backend.integrador.dto.entrada.modificacion.TurnoModificacionEntradaDto;
import com.backend.integrador.dto.entrada.turno.TurnoEntradaDto;
import com.backend.integrador.dto.salida.turno.TurnoSalidaDto;
import com.backend.integrador.exceptions.BadRequestException;
import com.backend.integrador.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ITurnoService {
    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException;

    List<TurnoSalidaDto> listarTurnos();

    TurnoSalidaDto buscarTurnoPorId(Long id);

    void eliminarTurno(Long id) throws ResourceNotFoundException;

    TurnoSalidaDto modificarTurno(TurnoModificacionEntradaDto turnoModificacionEntradaDto) throws ResourceNotFoundException;

}
