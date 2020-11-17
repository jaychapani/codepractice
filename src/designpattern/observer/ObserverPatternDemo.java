package designpattern.observer;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		
		Item item = new Item();

		User user1 = new User(item,"Jay");
		User user2 = new User(item,"Pooja");
		
		item.addObserver(user1);
		item.addObserver(user2);
		
		item.setInStock(true);
		
	}

}
