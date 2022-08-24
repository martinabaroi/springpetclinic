package urmi.petclinics.springpetclinic.services.map;

import java.util.Set;

import urmi.petclinics.springpetclinic.model.Pet;
import urmi.petclinics.springpetclinic.model.Vet;
import urmi.petclinics.springpetclinic.services.CrudService;
import urmi.petclinics.springpetclinic.services.VetService;

public class VetServiceMap extends AbstractionMapService<Vet, Long> implements VetService {

	@Override
	public Vet findById(Long id) {
		Vet vet = super.findById(id);
		return vet;
	}

	@Override
	public Vet save(Vet object) {
		Vet vet = super.save(object.getId(), object);
		return vet;
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
