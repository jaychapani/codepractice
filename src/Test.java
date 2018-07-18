import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

	public static void main(String arg[]) {
		// Person p = new Employee(); // upcasting
		// p.walk();
		System.out.println(steps(0, 0, 4, "M",1));
		
	}

	public static int steps(int source, int step, int dest, String str, int i) {
		// base cases
		System.out.println(i + " - source:" + source + " step:" + step + " dest:" + dest + " str:" + str);

		if (Math.abs(source) > (dest))
			return Integer.MAX_VALUE;
		if (source == dest)
			return step;

		// at each point we can go either way

		// if we go on positive side
		int pos = steps(source + step + 1, step + 1, dest, "P", ++i);

		// if we go on negative side
		int neg = steps(source - step - 1, step + 1, dest, "N", ++i);

		// minimum of both cases
		return Math.min(pos, neg);
	}
}

class Person {

	Person() {
		System.out.println("Person constructor...");
	}

	void walk() {
		System.out.println("Can Run….");
	}
}

class Employee extends Person {

	Employee() {
		System.out.println("Employee constructor...");
	}

	void walk() {
		System.out.println("Running Fast…");
	}

}
//
//// interface (Product)
// public interface Logger {
// public void log(String message);
// }
//
//// concrete implementation of the Logger (Product)
// public class XMLLogger implements Logger {
// public void log(String message) {
// // log to xml
// System.err.println("logging");
// }
// }
//
//// the abstract Creator
// public abstract class AbstractLoggerCreator {
// // the factory method
// public abstract Logger createLogger();
//
// // the operations that are implemented for all LoggerCreators
// // like anOperation() in our diagram
// public Logger getLogger() {
// // depending on the subclass, we'll get a particular logger.
// Logger logger = createLogger();
// // could do other operations on the logger he
// rereturn logger;
// }
// }
//
//// ConcreteCreator
// public class XMLLoggerCreator extends AbstractLoggerCreator {
// @Override
// public Logger createLogger() {
// XMLLogger logger = new XMLLogger();
// return logger;
// }
// }
//
// public class Client {
// private void someMethodThatLogs(AbstractLoggerCreator logCreator) {
// Logger logger = logCreator.createLogger();
// logger.log("message");
// }
//
// public static void main(String[] args) {
// // for the purposes of this example, create an XMLLoggerCreator
// // directly,
// // but this would normally be passed to constructor for use.
// AbstractLoggerCreator creator = new XMLLoggerCreator();
// Client client = new Client();
// client.someMethodThatLogs(creator);
// }
// }