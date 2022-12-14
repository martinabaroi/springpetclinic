package urmi.petclinics.springpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import urmi.petclinics.springpetclinic.model.Owner;
import urmi.petclinics.springpetclinic.model.Pet;
import urmi.petclinics.springpetclinic.model.PetType;
import urmi.petclinics.springpetclinic.model.Speciality;
import urmi.petclinics.springpetclinic.model.Vet;
import urmi.petclinics.springpetclinic.model.Visit;
import urmi.petclinics.springpetclinic.services.OwnerService;
import urmi.petclinics.springpetclinic.services.PetTypeService;
import urmi.petclinics.springpetclinic.services.SpecialityService;
import urmi.petclinics.springpetclinic.services.VetService;
import urmi.petclinics.springpetclinic.services.VisitService;
import urmi.petclinics.springpetclinic.services.map.OwnerMapService;
import urmi.petclinics.springpetclinic.services.map.VetMapService;


@Component
public class DataLoader implements CommandLineRunner { //here CommandLineRunner is spring's class.when application will start first time, 
	//before starting main class code, it start first CommandLineRunner class. 
	//here in this project we want that some owners and vets service data will loaded from before so that  we check out work easily.
	
	

	private final OwnerService ownerService;    //interface 
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
		this.ownerService = ownerService; //here we just inject and by@service annotation spring put ownerservicemap here.
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
		
//		ownerService = new OwnerServiceMap();  //in interface we put implement class //this time in ownerservicemap wasnt @service annotation,
												//so we have to create by new.
//		vetService  = new VetServiceMap();
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size(); //by findall will get set of pettype //by size will get pettype size of which got from findall
		
		if(count == 0) { //when we start out program first type, than count will  be 0 , than loadData method will run. // second type count wont be 0
			loadData(); 	
		}
	//this formula written so that when we save in database this loadData method can run only one time, because there willl be save data permanantly.
	// but here we save in map so how many time we run this app, always count will be 0 beacuse data saved in map temporary and everytime we save this data when will run.
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType saveDogPetType = petTypeService.save(dog);  //save in map
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType saveCatPetType = petTypeService.save(cat);
		
		
		Speciality radiology = new Speciality();
		radiology.setDiscrption("Radiology");	
		Speciality savedRadiology = specialityService.save(radiology);   //savedRadiology = id,String
		
		Speciality surgery = new Speciality();
		surgery.setDiscrption("surgery");
		Speciality savedSurgery= specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDiscrption("dentistry");
		Speciality savedDentistry= specialityService.save(dentistry);
		
		
		Owner owner1 = new Owner();
		owner1.setFirstName("urmi");
		owner1.setLastName("baroi");
		owner1.setAddress("639 chestnut");
		owner1.setCity("oxford");
		owner1.setTelephone("12453");
		
		//here dont need to save pet because in owner class's pet properties we said cascadetype.all. 
		//so when we save pet in owner automatically pet saved in pet table.
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
		
		Visit catVisit = new Visit();
		catVisit.setPet(fionasCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDiscription("snizzy kitty");
		
		visitService.save(catVisit);
		
//		Owner owner3 = null;
//		ownerService.save(owner3); //exception will be thrown. we didnt catch that exception so app wont run again. 
		
		System.out.println("Loaded owners");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Cathi");
		vet1.setLastName("pola");
		vet1.getSpecialities().add(savedRadiology);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Paul");
		vet2.setLastName("karli");
		vet2.getSpecialities().add(savedSurgery);
		
		vetService.save(vet2);
		
		System.out.println("Loaded vets");
	}

}
