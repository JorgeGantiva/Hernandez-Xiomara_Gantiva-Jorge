package com.backend.integrador.main.java.Hernandez-Xiomara_Gantiva-Jorge.ClinicaOdontologica.repository;

import com.backend.integrador.main.java.Hernandez-Xiomara_Gantiva-Jorge.ClinicaOdontologica.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {
}