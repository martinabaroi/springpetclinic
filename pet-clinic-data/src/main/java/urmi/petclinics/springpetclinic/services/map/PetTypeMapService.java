package urmi.petclinics.springpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import urmi.petclinics.springpetclinic.model.PetType;
import urmi.petclinics.springpetclinic.services.PetTypeService;


@Service   //can't write service in interface class.only have to write in implement class
public class PetTypeMapService  extends AbstractionMapService<PetType, Long>  implements PetTypeService {

	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		return super.save(object);
	}

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}

	@Override
	public void delete(PetType object) {
		super.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
