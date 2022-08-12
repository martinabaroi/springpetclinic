package urmi.petclinics.springpetclinic.services;

import java.util.Set;

import urmi.petclinics.springpetclinic.model.Owner;

//we create this interface because, before creating it we had to write some same method in ownerservice, petservice and vetservice.so avoiding this repeatation we create a interface
//named CurdService and extends(we dont need implement just extends is allright here) it in all service.
public interface CrudService<T, ID>  {
	
	T findById(ID id);
	T save(T object);
	Set <T> findAll();
	void delete(T object);
	void deleteById(ID id);

}
