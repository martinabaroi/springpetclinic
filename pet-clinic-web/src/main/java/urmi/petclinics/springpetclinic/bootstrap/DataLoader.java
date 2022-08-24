package urmi.petclinics.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import urmi.petclinics.springpetclinic.model.Owner;
import urmi.petclinics.springpetclinic.model.Vet;
import urmi.petclinics.springpetclinic.services.OwnerService;
import urmi.petclinics.springpetclinic.services.VetService;
import urmi.petclinics.springpetclinic.services.map.OwnerServiceMap;
import urmi.petclinics.springpetclinic.services.map.VetServiceMap;


@Component
public class DataLoader implements CommandLineRunner { //here CommandLineRunner is spring's class.when application will start first time, 
	//before starting main class code, it start first CommandLineRunner class. 
	//here in this project we want that some owners and vets service data will loaded from before so that  we check out work easily.
	
	

	private final OwnerService ownerService;    //interface 
	private final VetService vetService;
	
	public DataLoader(OwnerService ownerService, VetService vetService ) {
		this.ownerService = ownerService; //here we just inject and by@service annotation spring put ownerservicemap here.
		this.vetService = vetService;
		
//		ownerService = new OwnerServiceMap();  //in interface we put implement class //this time in ownerservicemap wasnt @service annotation,
												//so we have to create by new.
//		vetService  = new VetServiceMap();
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("urmi");
		owner1.setLastName("baroi");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner1.setId(2L);
		owner1.setFirstName("sunny");
		owner1.setLastName("pereira");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded owners");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("pussy");
		vet1.setLastName("dog");
		
		Vet vet2 = new Vet();
		vet1.setId(2L);
		vet1.setFirstName("lussy");
		vet1.setLastName("cat");
		
		System.out.println("Loaded vets");
		
		
		
		
		
	}

}