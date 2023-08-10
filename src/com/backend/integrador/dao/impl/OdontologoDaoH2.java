package com.backend.integrador.dao.impl;

import com.backend.integrador.dao.impl.H2Connection;
import com.backend.integrador.dao.impl.IDao;
import com.backend.integrador.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologo1 = null;
        try{
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (N_MATRICULA,NOMBRE,APELLIDO) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, odontologo.getNumeroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.execute();

            odontologo1 = new Odontologo(odontologo.getNumeroMatricula(), odontologo.getNombre(), odontologo.getApellido());

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }

            connection.commit();
            if (odontologo1 == null) LOGGER.error("No fue posible registrar al odontologo");
            else LOGGER.info("Se ha registrado el odontologo: " + odontologo1);


        } catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if(connection != null){
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception){
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                LOGGER.error("Ha ocurrido un error al intentar cerrar la base de datos. " + e.getMessage());
                e.printStackTrace();
            }
        }

        return odontologo1;
    }

    @Override
    public Odontologo buscarPorId(int id) {
        Connection connection = null;
        Odontologo odontologo = null;

        try{
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGO WHERE ID = ?", id);
            //ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                odontologo = crearObjetoOdontologo(rs);
            }

            if(odontologo == null) LOGGER.error("No se ha encontrado el odontologo con id: " + id);
            else LOGGER.info("Se ha encontrado el odontologo: " + odontologo);



        } catch (Exception e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex){
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }


        return odontologo;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE ID = ?");
            ps.setInt(1, id);
            ps.execute();
            connection.commit();
            LOGGER.info("Se ha eliminado el odontologo con id: " + id);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Tuvimos un problema");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la base de datos. " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Odontologo odontologo = crearObjetoOdontologo(rs);
                odontologos.add(odontologo);
            }

            LOGGER.info("Listado de todos los odontologos: " + odontologos);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la base de datos. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologos;
    }

    private Odontologo crearObjetoPaciente(ResultSet resultSet) throws SQLException {
        int idOdontologo = resultSet.getInt("id");
        String nombreOdontologo = resultSet.getString("nombre");
        String apellidoOdontologo = resultSet.getString("apellido");
        int numeroMatriculaOdontologo = resultSet.getInt("N_Matricula");


        return new Odontologo(idOdontologo, nombreOdontologo, apellidoOdontologo, numeroMatriculaOdontologo);
    }
}

