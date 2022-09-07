package urmi.petclinics.springpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import urmi.petclinics.springpetclinic.model.PetType;
import urmi.petclinics.springpetclinic.repositories.PetTypeRepository;
import urmi.petclinics.springpetclinic.services.PetTypeService;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
	
	private final PetTypeRepository petTypeRepository;
	
	public  PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public PetType findById(Long id) {
		Optional<PetType> optionalPetType = petTypeRepository.findById(id);
		 
//		 if(optionalOwner.isPresent()) {
//			 return optionalOwner.get();
//		 }
//		 else {
//			 return null;
//		 }
		 
		 return optionalPetType.orElse(null); //shortut of comment section
	}

	@Override
	public PetType save(PetType object) {
		
		return petTypeRepository.save(object);
	}

	@Override
	public Set<PetType> findAll() {
		Set<PetType> petTypes = new HashSet<>();
		petTypeRepository.findAll().forEach(petTypes::add);
		return petTypes;
	}

	@Override
	public void delete(PetType object) {
		petTypeRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		petTypeRepository.deleteById(id);
		
	}

}
