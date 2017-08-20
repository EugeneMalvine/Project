package com.project.domain.response;

import com.project.domain.Person;

import java.util.List;

/**
 * Created by Denis on 20.08.2017.
 */
//структура для хранения ответа на запрос страницы данных из person
public class PersonPageResponse {
    //данные
    public List<Person> data;
    //номер текущей страницы
    public int currentPage;
    //количество страниц
    public int ammountOfPage;
    //количество данных в бд
    public int ammountOfPerson;
    //размер страницы
    public int pageSize;
}
