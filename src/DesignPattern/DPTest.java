package DesignPattern;

public class DPTest {

	public static void main(String[] args) {
		new Child();
	}

}

class Parent {
	Parent() {
		System.out.println("Parent called!!!");
	}
}

class Child extends Parent {
	Child() {
		super();
		System.out.println("Child called!!!");
	}

	static{
		//If static is there block will be called first
		System.out.println("Static Block called!!");
	}
	{
		//If static is there block will be called first
		System.out.println("Block called!!");
	}
}