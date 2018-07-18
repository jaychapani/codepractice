package DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class Item implements Observable {
	
	private boolean inStock = false;
	
	private List<Observer> userList = new ArrayList<Observer>();

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
		if(inStock){
			notifyObserver();
		}
	}

	@Override
	public void addObserver(Observer o) {
		userList.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		userList.remove(o);
	}

	@Override
	public void notifyObserver() {
		
		for (Observer user : userList) {
			user.update();
		}

	}

}
