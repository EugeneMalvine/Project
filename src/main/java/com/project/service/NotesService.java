package com.project.service;
import java.util.List;
import com.project.domain.Notes;

public interface NotesService {

    public List<Notes> findAll();

    public Notes findByName(String name);

    public List<Notes> findByListId(Long id);

    public Notes findById(Long id);

    public Notes save(Notes notes);

    public Notes update(Notes notes);

    public void delete(Notes notes);

    public void delete(Long id);

    //есть в ли в списке с id запись с n_id
    public boolean contains(Long id,Long n_id);

    //To clear collections
    public void clear();
}
