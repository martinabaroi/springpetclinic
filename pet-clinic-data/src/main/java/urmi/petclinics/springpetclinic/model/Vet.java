package urmi.petclinics.springpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {
	
	private Set<Speciality> specialities = new HashSet<>();  //id, discription

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
	
	
}
