import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		System.out.println(in.nextLine().replaceAll(" ", "").toCharArray());
		
		double pCnt = 0;
		double nCnt = 0;
		double zCnt = 0;

//		for (int i = 0; i < N; i++) {
//			int num = in.nextInt();
//			if (num > 0) {
//				pCnt++;
//			} else if (num < 0) {
//				nCnt++;
//			} else {
//				zCnt++;
//			}
//		}

		DecimalFormat df = new DecimalFormat("0.000000");
		
		System.out.println(df.format(pCnt / N));
		System.out.println(df.format(nCnt / N));
		System.out.println(df.format(zCnt / N));
	}

}
