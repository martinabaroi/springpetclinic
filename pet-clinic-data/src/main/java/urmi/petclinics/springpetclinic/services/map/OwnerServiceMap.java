package urmi.petclinics.springpetclinic.services.map;

import java.util.Set;

import urmi.petclinics.springpetclinic.model.Owner;
import urmi.petclinics.springpetclinic.services.CrudService;

public class OwnerServiceMap extends AbstractionMapService<Owner, Long> implements CrudService<Owner, Long> {

	@Override
	public Owner findById(Long id) {
		Owner owner = super.findById(id);
		return owner;
	}

	@Override
	public Owner save(Owner object) {
		Owner owner = super.save(object.getId(), object);
		return  owner;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> OwnerSet = super.findAll();
		return OwnerSet;
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
