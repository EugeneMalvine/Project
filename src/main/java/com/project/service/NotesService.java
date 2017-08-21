package com.project.service;
import java.util.List;
import com.project.domain.Notes;

public interface NotesService {

    public List<Notes> findAll();

    public Notes findByName(String name);

    public Notes findByListName(String listname);

    public Notes save(Notes notes);

    public void delete(Notes notes);

    //To clear collections
    public void clear();
}
