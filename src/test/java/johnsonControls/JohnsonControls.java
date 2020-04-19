package johnsonControls;



public class JohnsonControls {

	int section;
	String firstName, lastName, email;
	
	

	public JohnsonControls(int section,String firstName,String lastName,String email){
		
		this.section = section;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String printStudentDetails(){
		
		return this.section+" "+this.firstName+" "+this.lastName+" "+this.email;
	}
	
	

}
