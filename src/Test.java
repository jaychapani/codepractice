import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {
	
	public static void main(String arg[]) throws Exception {
		
		/*int n = 3;
		int target = 2;

		int[] arr = new int[] { 1,3,5 };*/
		

		Scanner in = null;
		try {
			in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

			int n = in.nextInt();
			
			int[] arr = new int[n];
			
			for (int x = 1; x <= n; x++) {

				int a = in.nextInt();
				arr[x] = a;
			}
			
			int target = in.nextInt();
			
			in.close();
			
			int count = 0;
			Arrays.sort(arr); // Sort array elements

			int l = 0;
			int r = 0;
			while (r < n) {
				if (arr[r] - arr[l] == target) {
					count++;
					l++;
					r++;
				} else if (arr[r] - arr[l] > target)
					l++;
				else 
					r++;
			}
			
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		

		
		// Person p = new Employee(); // upcasting
		// p.walk();
		// System.out.println(steps(0, 0, 4, "M",1));

//		int low = 0, high = 233;
//		for (int i = 0; i <= 9; i++)
//			bfs(low, high, i);

		/*int x[] = { 1, 2, 5 };

		change(x);
		
		System.out.println("--->" + solve(x));

		int[][] courses = { { 100, 200 }, { 200, 1300 }, { 1150, 1250 }, { 2000, 3200 } };

		Arrays.sort(courses, (a, b) -> a[1] - b[1]);

		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

		int time = 0;
		for (int[] c : courses) {
			if (time + c[0] <= c[1]) {
				queue.offer(c[0]);
				time += c[0];
			} else if (!queue.isEmpty() && queue.peek() > c[0]) {
				time += c[0] - queue.poll();
				queue.offer(c[0]);
			}
		}

		System.out.println(queue.size());*/
	}

	private static void change(int[] x) {
		for (int i = 0; i < x.length; i++) {
			x[i]++;
		}
	}

	public static long solve(int[] arr) {
		if (arr.length <= 1) {
			return 0;
		}

		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int k = (i + 1) % arr.length;
			sum += arr[i] % arr[k];
			sum += arr[k] % arr[i];
		}

		sum = (long) (sum % (Math.pow(10, 9) + 7));

		return sum;
	}

	public static void bfs(int low, int high, int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		while (!q.isEmpty()) {
			int stepNum = q.poll();
			if (stepNum <= high && stepNum >= low) {
				System.out.print(stepNum + " ");
			}
			if (stepNum == 0 || stepNum > high)
				continue;
			int lastDigit = stepNum % 10;
			int stepNumA = stepNum * 10 + (lastDigit - 1);
			int stepNumB = stepNum * 10 + (lastDigit + 1);
			if (lastDigit == 0)
				q.add(stepNumB);
			else if (lastDigit == 9)
				q.add(stepNumA);
			else {
				q.add(stepNumA);
				q.add(stepNumB);
			}
		}
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
		System.out.println("New Person constructor...");
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
