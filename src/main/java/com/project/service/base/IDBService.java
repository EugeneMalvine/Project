package com.project.service.base;

import com.project.domain.Contact;

import java.util.List;

/**
 * Created by Denis on 25.08.2017.
 * Интерфейс сервиса, обращающегося через маппер к бд
 */
public interface IDBService<T> {
    List<T> findAll();

    List<T> findRange(int from,int ammount);

    T findById(Long id);

    T save(T data);

    void delete(Long id);

    void delete(T data);

    T insert(T data);

    T update(T notes);

    void clear();

    Long size();
}
