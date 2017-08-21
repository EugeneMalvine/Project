package com.project.persistence;
import java.util.List;
import com.project.domain.Notes;

public interface NotesMapper {

    public List<Notes> findAll();

    public Notes findByName(String name);

    public Notes findByListId(Long id);

    public void insert(Notes notes);

    public void update(Notes notes);

    public void delete(Long id);
}
