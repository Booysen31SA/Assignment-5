package com.Booysen31SA.services;

import java.util.Set;

public interface IService <T, ID>{
    T create(T t);
    T read(ID id);
    T update (T t);
    void delete(ID id);
    Set<T> getAll();
}
