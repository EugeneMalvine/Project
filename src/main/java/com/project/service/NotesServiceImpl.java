package com.project.service;

import java.util.List;
import java.util.stream.Collectors;

import com.project.domain.Lists;
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

    public List<Notes> findByListId(Long id){
        List<Notes> notes = notesMapper.findByListId(id);
        return notes;
    }

    public Notes findById(Long id){
        Notes notes = notesMapper.findById(id);
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

    public Notes insert(Notes notes) {
        notesMapper.insert(notes);
        return notes;
    }

    public Notes update(Notes notes) {
        notesMapper.update(notes);
        return notes;
    }

    public void delete(Notes notes) {
        Long notesId = notes.getId();
        delete(notesId);
    }

    public void delete(Long id){
        notesMapper.delete(id);
    }

    public boolean contains(Long id,Long n_id){
        List<Long> idCollection =  findByListId(id).stream().map((Notes it) -> it.getId()).collect(Collectors.toList());
        return idCollection.contains(n_id);
    }

    public void clear(){
        List<Notes> notess = notesMapper.findAll();
        for (int i=0;i < notess.size();i++) {
            delete(notess.get(i));
        }
    }
}
