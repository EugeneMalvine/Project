package com.project.domain.response;

/*
базовый класс для передачи данных о странице ( для пагинации)
 */

import java.util.List;

/**
 * Created by Denis on 24.08.2017.
 */
public class PageResponse<T> {
    //данные
    public List<T> data;
    //номер текущей страницы
    public int currentPage;
    //количество страниц
    public int ammountOfPage;
    //количество данных в бд
    public int fullSize;
    //размер страницы
    public int pageSize;


}
