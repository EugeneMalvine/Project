package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.domain.Notes;
import com.project.persistence.NotesMapper;


@Service("notesService")
@Transactional
public class NotesServiceImpl implements NotesService {
    private static NotesMapper notesMapper;

    public void setNotesMapper(NotesMapper notesMapper){
        this.notesMapper = notesMapper;
    }

    public List<Notes> findAll() {
        List<Notes> notess = notesMapper.findAll();
        return notess;
    }

    public Notes findByName(String name) {
        Notes notes = notesMapper.findByName(name);
        return notes;
    }

    public Notes findByListName(String listname) {
        Notes notes = notesMapper.findByListName(listname);
        return notes;
    }

    public Notes save(Notes notes) {
        if (notes.getId() == null) {
            insert(notes);
        } else {
            update(notes);
        }
        return notes;
    }

    private Notes insert(Notes notes) {
        notesMapper.insert(notes);
        return notes;
    }

    private Notes update(Notes notes) {
        notesMapper.update(notes);
        return notes;
    }

    public void delete(Notes notes) {
        Long notesId = notes.getId();
        notesMapper.delete(notesId);
    }

    public void clear(){
        List<Notes> notess = notesMapper.findAll();
        for (int i=0;i < notess.size();i++) {
            delete(notess.get(i));
        }
    }
}
