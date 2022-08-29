package urmi.petclinics.springpetclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import urmi.petclinics.springpetclinic.model.Owner;
import urmi.petclinics.springpetclinic.model.Pet;
import urmi.petclinics.springpetclinic.model.PetType;
import urmi.petclinics.springpetclinic.services.OwnerService;
import urmi.petclinics.springpetclinic.services.PetService;
import urmi.petclinics.springpetclinic.services.PetTypeService;


@Service  //can't write service in interface class.only have to write in implement class
public class OwnerServiceMap extends AbstractionMapService<Owner, Long> implements OwnerService {
	
	
	private final PetTypeService petTypeService;
	private final PetService petService;
	
	public OwnerServiceMap(PetTypeService petTypeService, PetService petService ) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}
	

	@Override
	public Owner findById(Long id) {
		Owner owner = super.findById(id);  //super is used to call a super class's method.
		return owner;
	}

	@Override
	public Owner save(Owner object) {    //Owner -> Pet -> PetType 
									//for saving owner we have to need id of Pet and PetType.. so first we have to save PetType and than Pet for getting auto id.
			
		
		if(object != null) {
			if(object.getPets() != null) {  
				Set<Pet> pets = object.getPets(); //an owner can have one Pet or  lots of Pets 
				pets.forEach(pet -> {   //from lots of pets get one by one Pet by for each loop.
					if(pet.getPetType() != null) {  //here Pet object have  a variable petType. and petType is another object.						
						if(pet.getPetType().getId() == null) {   //if petType object's id is null than we enter into the if 
							PetType savedPetType = petTypeService.save(pet.getPetType());   //save the petType and will get id auto from the database.
							pet.setPetType(savedPetType); //than set this petType object into pet Object.
						}
					} else {
						throw new RuntimeException("PetType is required");
					}
					
					if(pet.getId() == null) {  //if Pet object's id is null than we enter into the if 
						Pet savedPet = petService.save(pet); //save the Pet and will get id auto from the database
						pet.setId(savedPet.getId()); //than set  pet's id into the Pet.
					}
				});
				
			}
			
			return super.save(object); //now we save owner object because in above we first save petType for getting id -> than with full PetType object we set it in Pet object
									// than save pet for getting id of pet -> with full Pet object save it in owner.
		} else {
			return null;
		}
		//from save method we will get either null or owner type object
		
		
		
		
//		Owner owner = super.save(object);
//		return  owner;
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
