package com.example.smpetclinic.services.map;

import com.example.smpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long>{

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(this.map.values());
    }

    T findById(ID id){
        return this.map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(this.getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object can not be null!");
        }
        return object;
    }

    void deleteById(ID id){
        this.map.remove(id);
    }

    void delete(T object){
        this.map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId(){
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch(NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
