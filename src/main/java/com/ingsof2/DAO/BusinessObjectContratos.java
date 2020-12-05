package com.ingsof2.DAO;

import java.util.List;

public interface BusinessObjectContratos<T> {//borrar

    List<T> readAll();

    List<T> readVigentes();

    T ReadOne(T t);

    int create(T t);

    int update(T t);

    int delete(T t);

}
