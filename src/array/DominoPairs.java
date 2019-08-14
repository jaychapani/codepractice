package array;

public class DominoPairs {

	public static void main(String[] args) {

		int a[][] = new int[][] { { 1, 2 }, { 2, 1 }, {1,2}, { 3, 4 }, { 5, 6 } };

		System.out.println(numEquivDominoPairs(a));

	}

	public static int numEquivDominoPairs(int[][] dominoes) {
		
		int[] a = new int[100];
		int res = 0;
		
		for(int i = 0; i < dominoes.length; i++){
               
            	int current = dominoes[i][0] * 10 + dominoes[i][1];
            	int reverse = dominoes[i][1] * 10 + dominoes[i][0];
            	
            	if(a[current] == 0 && a[reverse] == 0) {
            		a[current] = 1;
            	}else if(a[current] > 0) {
            		a[current]++;
            	}else {
            		a[reverse]++;
            	}
        }
		
		for(int x:a) {
			if(x>1) {
				res+= (x*(x-1))/2;
			}
		}
		
		return res;
	}

}
