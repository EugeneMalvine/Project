package com.project.persistence;
import java.util.List;
import com.project.domain.Notes;
import com.project.persistence.base.IMapper;
import com.project.persistence.base.INamedMapper;

public interface NotesMapper extends INamedMapper<Notes> {

    /**
     * Получить все записи тодо из выбранного списка тодо
     * @param id: id списка тодо, записи которого необходимо получить
     * @return список записей тодо
     */
    public List<Notes> findByListId(Long id);

}
