package urmi.petclinics.springpetclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {
	
	@Column(name = "discription")
	private String discrption;

	public String getDiscrption() {
		return discrption;
	}

	public void setDiscrption(String discrption) {
		this.discrption = discrption;
	}
	
	
}
