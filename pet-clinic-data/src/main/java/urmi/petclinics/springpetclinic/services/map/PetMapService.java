package urmi.petclinics.springpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import urmi.petclinics.springpetclinic.model.Owner;
import urmi.petclinics.springpetclinic.model.Pet;
import urmi.petclinics.springpetclinic.services.CrudService;
import urmi.petclinics.springpetclinic.services.PetService;



@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractionMapService<Pet, Long> implements PetService {

	@Override
	public Pet findById(Long id) {
		Pet pet = super.findById(id);
		return pet;
	}

	@Override
	public Pet save(Pet object) {
		Pet pet = super.save( object);
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
