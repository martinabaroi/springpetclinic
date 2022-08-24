package urmi.petclinics.springpetclinic.controllers;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import urmi.petclinics.springpetclinic.model.Vet;
import urmi.petclinics.springpetclinic.services.VetService;



@Controller
public class VetController {
	
	private final VetService vetService;
	
	public VetController(VetService vetService) {
		this.vetService = vetService;
	}
	
	@RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
	public String listVets(Model model) {
		Set<Vet> vetList = vetService.findAll();
		model.addAttribute("vets", vetList);
		
		return "vets/index";
	}
}
