package urmi.petclinics.springpetclinic.model;

import java.util.Set;

public class Owner extends Person {   //id, firstname, lastname , pets

	private Set<Pet> pets;  //pets= pettype , owner, birthdate

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	
	
}
