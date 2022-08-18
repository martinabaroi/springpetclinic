package urmi.petclinics.springpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractionMapService<T, ID>  {
	
	protected Map<ID, T> map = new HashMap<>();			//will create this map automatically when this class's method will call by another class's method.
	
	
	Set<T> findAll() {
		Set<T> valuesOfMap = new HashSet<>(map.values());  //this method will return a set of values of map only not keys value.
		return valuesOfMap;
	}

	T findById(ID id) {
		T object = map.get(id);   
		return object;
	}
	
	T save(ID id, T object) {
		map.put(id, object);
		return object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}
	
	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
}
