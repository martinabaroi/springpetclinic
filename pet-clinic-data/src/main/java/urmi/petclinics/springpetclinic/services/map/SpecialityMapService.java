package urmi.petclinics.springpetclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import urmi.petclinics.springpetclinic.model.Pet;
import urmi.petclinics.springpetclinic.model.Speciality;
import urmi.petclinics.springpetclinic.services.SpecialityService;

@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractionMapService<Speciality, Long>  implements SpecialityService{

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {	
		return super.save(object);
	}

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public void delete(Speciality object) {
		super.delete(object);
		
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
		
	}

}
