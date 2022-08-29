package urmi.petclinics.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import urmi.petclinics.springpetclinic.model.Owner;
import urmi.petclinics.springpetclinic.model.Pet;
import urmi.petclinics.springpetclinic.model.PetType;
import urmi.petclinics.springpetclinic.model.Vet;
import urmi.petclinics.springpetclinic.services.OwnerService;
import urmi.petclinics.springpetclinic.services.PetTypeService;
import urmi.petclinics.springpetclinic.services.VetService;
import urmi.petclinics.springpetclinic.services.map.OwnerServiceMap;
import urmi.petclinics.springpetclinic.services.map.VetServiceMap;


@Component
public class DataLoader implements CommandLineRunner { //here CommandLineRunner is spring's class.when application will start first time, 
	//before starting main class code, it start first CommandLineRunner class. 
	//here in this project we want that some owners and vets service data will loaded from before so that  we check out work easily.
	
	

	private final OwnerService ownerService;    //interface 
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService ) {
		this.ownerService = ownerService; //here we just inject and by@service annotation spring put ownerservicemap here.
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		
//		ownerService = new OwnerServiceMap();  //in interface we put implement class //this time in ownerservicemap wasnt @service annotation,
												//so we have to create by new.
//		vetService  = new VetServiceMap();
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType saveDogPetType = petTypeService.save(dog);  //save in map
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType saveCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("urmi");
		owner1.setLastName("baroi");
		owner1.setAddress("639 chestnut");
		owner1.setCity("oxford");
		owner1.setTelephone("12453");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(saveDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet); //bring Set<Pet> by getpets() . than in sets, add pet
		
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("sunny");
		owner2.setLastName("pereira");
		owner2.setAddress("180 college ave");
		owner2.setCity("eaton");
		owner2.setTelephone("929292");
		
		Pet fionasCat = new Pet();
		fionasCat.setName("Just Cat");
		fionasCat.setOwner(owner2);
		fionasCat.setBirthDate(LocalDate.now());
		fionasCat.setPetType(saveCatPetType);
		owner2.getPets().add(fionasCat);
		
		ownerService.save(owner2);
		
//		Owner owner3 = null;
//		ownerService.save(owner3); //exception will be thrown. we didnt catch that exception so app wont run again. 
		
		System.out.println("Loaded owners");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("pussy");
		vet1.setLastName("dog");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("lussy");
		vet2.setLastName("cat");
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets");
		
		
		
		
		
	}

}
