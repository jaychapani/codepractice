package array;

import java.util.Arrays;

public class Candies {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(distributeCandies(90,4)));

	}

	public static int[] distributeCandies(int candies, int num_people) {
        int a[] = new int[num_people];
        
        int i = 0;
        
        while(candies > 0){
            
            if(candies <= i){
                a[i % num_people] += candies;
                break;
            }
            
            a[i % num_people] += ++i;
            candies -= i;
        }
    
        return a;
    }
}
