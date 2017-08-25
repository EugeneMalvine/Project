package com.project.persistence;

import com.project.domain.Lists;
import com.project.persistence.base.IMapper;
import com.project.persistence.base.INamedMapper;

import java.util.List;

/**
 * Интерфейс для работы с бд list
 */
public interface ListsMapper extends INamedMapper<Lists> {

    /**
     * Получить все списки тодо выбранного пользователя
     * @param id: id поьзователя, списки тодо которого необходимо получить
     * @return списки тодо
     */
    List<Lists> findByUserId(Long id);

    /**
     * Удалить список с id включая все его записи
     * @param id: id удаляемого списка
     */
    void deepDelete(Long id);

}
