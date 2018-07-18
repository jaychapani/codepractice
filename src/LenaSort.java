import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LenaSort {

	static int cnt = 0;

	public static void main(String[] args) {

		Integer[] arr = new Integer[] { 3,2,1,4,5 };

		long[] mins = new long[21];
		long[] maxes = new long[21];
		mins[2] = 1;
		maxes[2] = 1;
		for (int i = 3; i <= 20; i++) {
			mins[i] = i - 1 + mins[(i - 1) / 2] + mins[(i - 1) - (i - 1) / 2];
			maxes[i] = maxes[i - 1] + i - 1;
		}

		System.out.println("lena_sort:: " + Arrays.toString(lena_sort(arr)) + " cnt :: " + cnt);

	}

	public static Integer[] lena_sort(Integer[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		int pivot = nums[0];
		List<Integer> less = new ArrayList<Integer>();
		List<Integer> more = new ArrayList<Integer>();
		for (int i = 1; i < nums.length; ++i) {
			// Comparison
			cnt++;
			if (nums[i] < pivot) {
				less.add(nums[i]);
			} else {
				more.add(nums[i]);
			}
		}
		Integer[] sorted_less = lena_sort(less.toArray(new Integer[0]));
		Integer[] sorted_more = lena_sort(more.toArray(new Integer[0]));

		List<Integer> ans = new ArrayList<Integer>();

		ans.addAll(Arrays.asList(sorted_less));
		ans.add(pivot);
		ans.addAll(Arrays.asList(sorted_more));

		return ans.toArray(new Integer[0]);
	}

}
