package urmi.petclinics.springpetclinic.services;

import java.util.Set;

import urmi.petclinics.springpetclinic.model.Owner;


//normally service class never extends any repository or crudservice. but here ownerservice extends because previously it saves in map by ownerservice
//so ownerservice need to extends crudservice. there was no repo than. 
//so now when we save in database we just call ownerservice method save their calling reposiory method.
public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
	
}
