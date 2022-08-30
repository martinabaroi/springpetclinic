package urmi.petclinics.springpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import urmi.petclinics.springpetclinic.model.Pet;
import urmi.petclinics.springpetclinic.model.Speciality;
import urmi.petclinics.springpetclinic.model.Vet;
import urmi.petclinics.springpetclinic.services.CrudService;
import urmi.petclinics.springpetclinic.services.SpecialityService;
import urmi.petclinics.springpetclinic.services.VetService;


@Service
public class VetServiceMap extends AbstractionMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;
	
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}
	
	@Override
	public Vet findById(Long id) {
		Vet vet = super.findById(id);
		return vet;
	}

	@Override
	public Vet save(Vet object) {
//		Vet vet = super.save( object);
//		return vet;
		
		if(object.getSpecialities().size() > 0) {  //if a vet, have one and more specialities
			Set<Speciality> specialities = object.getSpecialities();
					specialities.forEach(speciality -> {
				if(speciality.getId() == null) {  //if speciality didnt have any id thats mean this speciality didnt save before .so have to save Speciality for getting id.
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		
		return super.save( object); //here save vet object.
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> VetSet = super.findAll();
		return VetSet;
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
