package urmi.petclinics.springpetclinic.services.map;

import java.util.Set;

import urmi.petclinics.springpetclinic.model.Owner;
import urmi.petclinics.springpetclinic.model.Pet;
import urmi.petclinics.springpetclinic.services.CrudService;

public class PetServiceMap extends AbstractionMapService<Pet, Long> implements CrudService<Pet, Long> {

	@Override
	public Pet findById(Long id) {
		Pet pet = super.findById(id);
		return pet;
	}

	@Override
	public Pet save(Pet object) {
		Pet pet = super.save(object.getId(), object);
		return pet;
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> petSet = super.findAll();
		return petSet;
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);

	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}
