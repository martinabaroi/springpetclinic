package urmi.petclinics.springpetclinic.services;

import java.util.Set;

import urmi.petclinics.springpetclinic.model.Vet;

public interface VetService {
	
	Vet findById(Long id);
	Vet save(Vet vet);
	Set <Vet> findAll();
}
