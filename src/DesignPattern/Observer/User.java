package DesignPattern.Observer;

public class User implements Observer {

	private Observable observable = null;
	private String name;
	
	public User(Observable observable, String name){
		this.observable = observable;
		this.name = name;
	}
	
	@Override
	public void update() {
		System.out.println(this.name + " has been updated with "
				+ "email notification!!!");
	}

}
