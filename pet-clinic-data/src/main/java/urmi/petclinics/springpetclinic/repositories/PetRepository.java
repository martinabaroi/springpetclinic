package urmi.petclinics.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import urmi.petclinics.springpetclinic.model.Pet;



public interface PetRepository extends CrudRepository<Pet, Long> {

}
