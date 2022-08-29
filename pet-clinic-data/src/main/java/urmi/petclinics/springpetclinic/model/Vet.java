package urmi.petclinics.springpetclinic.model;

import java.util.Set;

public class Vet extends Person {
	
	private Set<Speciality> specialities;  //id, discription

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		this.specialities = specialities;
	}
	
	
}
