package com.project.persistence;

import com.project.domain.Contact;
import com.project.domain.Notes;
import com.project.persistence.base.IMapper;

import java.util.List;

/**
 * Интерфейс для работы с бд contact
 */

public interface ContactMapper extends IMapper<Contact> {
    /**
     * Получить контактную информацию выбранного пользователя
     * @param id: id пользователя, контактную информацию которого ищем
     * @return контактная информация пользователя
     */
    public Contact findByUserId(Long id);
}
