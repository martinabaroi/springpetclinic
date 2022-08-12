package urmi.petclinics.springpetclinic.services;

import java.util.Set;

import urmi.petclinics.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
	
}
