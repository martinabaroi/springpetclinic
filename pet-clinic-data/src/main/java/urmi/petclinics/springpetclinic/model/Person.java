package urmi.petclinics.springpetclinic.model;

public class Person extends BaseEntity {

	private static final long serialVersionUID = 8314456677110935145L;
	private String firstName;
	private String lastName;
	
	public Person() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
