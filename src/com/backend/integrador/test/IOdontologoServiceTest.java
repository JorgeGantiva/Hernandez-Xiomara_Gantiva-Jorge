package com.backend.integrador.test;

import com.backend.integrador.dao.impl.OdontologoDaoH2;
import com.backend.integrador.entity.Odontologo;
import com.backend.integrador.service.IOdontologoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IOdontologoServiceTest {

    IOdontologoService IOdontologoService = new IOdontologoService(new OdontologoDaoH2());


    @Test
    void deberiaAgregarUnOdontologo(){
        Odontologo odon1 = new Odontologo(33464, "Astrid", "Beltran", 50);
        Odontologo odontologoInsertado = IOdontologoService.registrarOdontologo(odon1);

        assertNotNull(odontologoInsertado.getId());
    }

    @Test
    void deberiaEncontrarElOdontologoConId1(){
        assertNotNull(IOdontologoService.buscarOdontologoPorId(1));
    }

    @Test
    public void deberiaHaberUnaListaNoVacia(){
        List<Odontologo> odontologosTest = IOdontologoService.listarTodosLosOdontologos();
        assertFalse(odontologosTest.isEmpty());
        assertTrue(odontologosTest.size() >= 1);

    }

}
