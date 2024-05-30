package gsf.springframework.services.map;

import gsf.springframework.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map=new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){

        if(object!=null)
        {
            if(object.getId()==null)
                {
                    object.setId(getNextID());
                }
                map.put(object.getId(), object);
        }
        else
        {
            throw new RuntimeException("Object Cannot be null");
        }

        return object;
    }


    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

    private Long getNextID(){
        Long nextID=null;

        try{
            nextID= Collections.max(map.keySet())+1;
        }
        catch (NoSuchElementException e)
        {
            nextID=1L;
        }
        return nextID;
    }
}
