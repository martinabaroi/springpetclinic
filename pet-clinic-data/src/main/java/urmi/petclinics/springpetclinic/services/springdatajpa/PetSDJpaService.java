package urmi.petclinics.springpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import urmi.petclinics.springpetclinic.model.Pet;
import urmi.petclinics.springpetclinic.repositories.PetRepository;
import urmi.petclinics.springpetclinic.services.PetService;

@Service
@Profile("springdatajpa")
public class PetSDJpaService implements PetService {
	
	private PetRepository petRepository;
	
	public PetSDJpaService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Override
	public Pet findById(Long id) {
		Optional<Pet> optionalPet = petRepository.findById(id);
		 
//		 if(optionalOwner.isPresent()) {
//			 return optionalOwner.get();
//		 }
//		 else {
//			 return null;
//		 }
		 
		 return optionalPet.orElse(null); //shortut of comment section
	}

	@Override
	public Pet save(Pet object) {
		return petRepository.save(object);
	}

	@Override
	public Set<Pet> findAll() {
		Set<Pet> pets = new HashSet<>();
		petRepository.findAll().forEach(pets::add);
		return pets;
	}

	@Override
	public void delete(Pet object) {
		petRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
		
	}

}
