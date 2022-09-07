package urmi.petclinics.springpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import urmi.petclinics.springpetclinic.model.Owner;
import urmi.petclinics.springpetclinic.model.PetType;
import urmi.petclinics.springpetclinic.repositories.OwnerRepository;
import urmi.petclinics.springpetclinic.repositories.PetRepository;
import urmi.petclinics.springpetclinic.repositories.PetTypeRepository;
import urmi.petclinics.springpetclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService  {
	
	private final OwnerRepository ownerRepository;
	private final PetRepository petRepository;
	private final PetTypeRepository petTypeRepository;
	
	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository  ) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner findById(Long id) {
		
		 Optional<Owner> optionalOwner = ownerRepository.findById(id);
		 
//		 if(optionalOwner.isPresent()) {
//			 return optionalOwner.get();
//		 }
//		 else {
//			 return null;
//		 }
		 
		 return optionalOwner.orElse(null); //shortut of comment section
	}

	@Override
	public Owner save(Owner object) {
		
		return ownerRepository.save(object);
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
		
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

}
