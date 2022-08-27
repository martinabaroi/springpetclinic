package urmi.petclinics.springpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.management.RuntimeErrorException;

import urmi.petclinics.springpetclinic.model.BaseEntity;

public abstract class AbstractionMapService<T extends BaseEntity, ID extends Long>  { //for auto generic id T must be extends BaseEntity and Id must be extends Long
	
	protected Map<Long, T> map = new HashMap<>();			//will create this map automatically when this class's method will call by another class's method.
	//key must be Long for auto id
	
	Set<T> findAll() {
		Set<T> valuesOfMap = new HashSet<>(map.values());  //this method will return a set of values of map only not keys value.
		return valuesOfMap;
	}

	T findById(ID id) {
		T object = map.get(id);   //this method will return a model find by id from map. (here map is like database)
		return object;
	}
	
	T save(T object) {
		if( object != null) {
			if(object.getId() == null) { //if we dont give any id when create the object, than it will be null
				object.setId(getNextId()); //set here id from auto method.
			}
			
			map.put(object.getId(), object); 
		  	//this method save  key(id) and value(object) in map.
		}
		else {	//if Object object3 = null; we make a null object than exception will throw.
			throw new RuntimeException("object can not be null"); //app will be off because we throw this exception didnt catch
		}
		
		return object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	private Long getNextId() { //for auto id this method will call.
		Long a = null;
		try {
			a =Collections.max(map.keySet()) + 1; //max means from the keySet the max number will return and than add 1.
		}
		catch(NoSuchElementException e) {  
			a = 1L; //for first time, if in keyset there will be no id set, than  id will be 1
		}
	
		return  a; 
		
	}
}
