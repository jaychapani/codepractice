package designpattern;

public class DesignPatternTest {

	public static void main(String[] args) {

		Image image = new ProxyImage("test_10mb.jpg");

		System.out.println("after obj create.");
		// image will be loaded from disk
		image.display();
		System.out.println("after first display");

		// image will not be loaded from disk
		image.display();

	}

}

class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	@Override
	public void display() {
		System.out.println("Displaying " + fileName);
	}

	private void loadFromDisk(String fileName) {
		System.out.println("Loading " + fileName);
	}
}

class ProxyImage implements Image {

	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		realImage.display();
	}
}