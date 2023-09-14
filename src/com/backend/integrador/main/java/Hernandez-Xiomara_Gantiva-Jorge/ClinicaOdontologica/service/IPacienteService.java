package com.backend.integrador.service;


import com.backend.integrador.dto.entrada.modificacion.PacienteModificacionEntradaDto;
import com.backend.integrador.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.integrador.dto.salida.paciente.PacienteSalidaDto;
import com.backend.integrador.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {
    List<PacienteSalidaDto> listarPacientes();

    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);

    PacienteSalidaDto buscarPacientePorId(Long id);

    void eliminarPaciente(Long id) throws ResourceNotFoundException;

    PacienteSalidaDto modificarPaciente(PacienteModificacionEntradaDto pacienteModificado) throws ResourceNotFoundException;


}
