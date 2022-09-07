package urmi.petclinics.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;


import urmi.petclinics.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
