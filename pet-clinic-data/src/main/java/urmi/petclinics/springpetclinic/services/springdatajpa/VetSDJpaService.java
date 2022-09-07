package urmi.petclinics.springpetclinic.services.springdatajpa;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import urmi.petclinics.springpetclinic.model.Vet;
import urmi.petclinics.springpetclinic.repositories.VetRepository;
import urmi.petclinics.springpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
	
	private final VetRepository vetRepository;
	
	public VetSDJpaService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Vet findById(Long id) {
		Optional<Vet> optionalVet = vetRepository.findById(id);
		 
//		 if(optionalOwner.isPresent()) {
//			 return optionalOwner.get();
//		 }
//		 else {
//			 return null;
//		 }
		 
		 return optionalVet.orElse(null); //shortut of comment section
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		vetRepository.deleteById(id);
		
	}

}
