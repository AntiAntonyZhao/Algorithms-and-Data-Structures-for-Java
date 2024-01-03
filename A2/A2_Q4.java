import java.util.*;

public class A2_Q4 {
	
	public static double swaps(int[] passengers) {
        int[] tmp = new int[passengers.length];
        return (double)mergeSort(passengers, tmp, 0, passengers.length-1);
    }
    
    private static double mergeSort(int[] input, int[] tmp, int left, int right) {
    	double minSwaps = 0.0;
    	if (left >= right) return 0; // wrong input
        int mid = (left + right) / 2; // split by 2
        minSwaps += mergeSort(input, tmp, left, mid);  // update Swaps from left part
        minSwaps += mergeSort(input, tmp, mid+1, right);  // update Swaps from right part 
        minSwaps += merge(input, tmp, left, mid+1, right); // update Swaps from putting them together
        return minSwaps;
    }
    
    private static double merge(int[] input, int[] tmp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = i; // key
        double minSwaps = 0.0;
        while (i <= mid-1 && j <= right) { 
            if (input[i] <= input[j]) {
                tmp[k++] = input[i++];
            } else { // (input[i] > input[j])
                tmp[k++] = input[j++];
                minSwaps += (mid - i);
            }
        }
        while (i <= mid-1) { // for i not reaching mid-1
            tmp[k++] = input[i++];
        }
        while (j <= right) { // for j not reach right
            tmp[k++] = input[j++];
        }
//        for (i = left; i <= right; i++) {
//        	input[i] = tmp[i];
//        }
        System.arraycopy(tmp, left, input, left, right - left + 1); // alternative way of updating the array
        return minSwaps;
    }
}
