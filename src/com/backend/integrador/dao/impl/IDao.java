package com.backend.integrador.dao.impl;

import java.util.List;

public interface IDao<T>{
    T registrar(T t);
    T buscarPorId(int id);
    void eliminar(int id);
    List<T> listarTodos();

}
