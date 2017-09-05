package com.project.service;

import java.util.List;
import java.util.stream.Collectors;

import com.project.domain.Lists;
import com.project.service.base.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.domain.Notes;
import com.project.persistence.NotesMapper;


@Service("notesService")
public class NotesServiceImpl extends DBService<Notes> implements NotesService {

    @Autowired
    private NotesMapper _mapper;

    public void setNotesMapper(NotesMapper notesMapper){
        this._mapper = notesMapper;
    }

    protected NotesMapper getMapper(){
        return _mapper;
    }

    public Notes findByName(String name) {
        Notes notes = _mapper.findByName(name);
        return notes;
    }

    public List<Notes> findByListId(Long id){
        List<Notes> notes = _mapper.findByListId(id);
        return notes;
    }

    public boolean contains(Long id,Long n_id){
        List<Long> idCollection =  findByListId(id).stream().map((Notes it) -> it.getId()).collect(Collectors.toList());
        return idCollection.contains(n_id);
    }

}
