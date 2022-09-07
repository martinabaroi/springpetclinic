package urmi.petclinics.springpetclinic.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass		//Instead of putting all these properties in every entity, we can place these properties in a base entity (annotate base entity with MappedSuperclass annotation).	
						//we dont need any table in database for this baseenity so didnt write @Entity.
public class BaseEntity implements Serializable {  

	@Id				//when any entity extends this class. that entity primary key will be this id and id will be auto generated so put @Id anootation here.
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
