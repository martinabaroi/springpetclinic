package urmi.petclinics.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import urmi.petclinics.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastName(String lastName);
}
