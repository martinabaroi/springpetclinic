package urmi.petclinics.springpetclinic.services;

import java.util.Set;

import urmi.petclinics.springpetclinic.model.Pet;

public interface PetService {

	Pet findById(Long id);
	Pet save(Pet pet);
	Set <Pet> findAll();
}
