package com.project.service;
import java.util.List;
import com.project.domain.Notes;
import com.project.service.base.IDBService;

public interface NotesService extends IDBService<Notes>{

    public Notes findByName(String name);

    public List<Notes> findByListId(Long id);

     //есть в ли в списке с id запись с n_id
    public boolean contains(Long id,Long n_id);

}
