package urmi.petclinics.springpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import urmi.petclinics.springpetclinic.model.Owner;
import urmi.petclinics.springpetclinic.services.CrudService;
import urmi.petclinics.springpetclinic.services.OwnerService;


@Service
public class OwnerServiceMap extends AbstractionMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findById(Long id) {
		Owner owner = super.findById(id);  //super is used to call a super class's method.
		return owner;
	}

	@Override
	public Owner save(Owner object) {
		Long id = object.getId();
		Owner owner = super.save(id, object);
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

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
