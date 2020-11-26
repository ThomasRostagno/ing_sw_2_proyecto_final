package com.ingsof2.DAO;

import com.ingsof2.Objetos.*;

import java.util.List;

public interface BusinessObject<T> {
    List<T> readAll();

    T ReadOne(T t);

    int create (T t);

    int update (T t);

    int delete (T t);

}
