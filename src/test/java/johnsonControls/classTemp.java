package johnsonControls;

public class classTemp {
	
	private classTemp(int data) {
		
		System.out.println("Constructor called..");
	}
	
	protected static classTemp create(int data) {
		
		classTemp obj = new classTemp(data);
		return obj;
		
		
	}
	
	public void myMethod() {
		
		System.out.println("Method called..");
	}

}
