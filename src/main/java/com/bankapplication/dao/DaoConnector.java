package com.bankapplication.dao;

public interface DaoConnector<T> {
    T create(T t);
}
