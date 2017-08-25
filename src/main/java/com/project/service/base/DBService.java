package com.project.service.base;

import com.project.domain.IEntity;
import com.project.persistence.PersonMapper;
import com.project.persistence.base.IMapper;

import java.util.List;

/**
 * Created by Denis on 25.08.2017.
 */
public abstract class DBService<T extends IEntity> implements IDBService<T> {

    protected IMapper<T> mapper;

    protected void setMapper(IMapper<T> mapper){
        this.mapper = mapper;
    }

    @Override
    public List<T> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<T> findRange(int from,int ammount){
        return mapper.findRange(from,ammount);
    }

    @Override
    public T findById(Long id){
        return mapper.findById(id);
    }

    @Override
    public T save(T data) {
        if (data.getId() == null) {
            insert(data);
        } else {
            update(data);
        }
        return data;
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }

    @Override
    public void delete(T data) {
        delete(data.getId());
    }

    @Override
    public void clear() {
        mapper.clear();
    }

    @Override
    public T insert(T data){
        mapper.insert(data);
        return data;
    }

    @Override
    public T update(T data)
    {
        mapper.update(data);
        return data;
    }

    @Override
    public Long size(){
        Long size =  mapper.size();
        return size;
    }

}
