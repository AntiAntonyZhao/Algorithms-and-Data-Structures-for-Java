import java.util.*;

public class A2_Q2 {

	public static int change(int[] denominations) {
		int minCE = Integer.MAX_VALUE; // minimum counter example
		List<Integer> counter_examples = new ArrayList<Integer>();
		int max2Coins = denominations[denominations.length-1]+denominations[denominations.length-2];
		int[] dP = dPTable(denominations, max2Coins);
		for(int i=0; i<=max2Coins; i++) {
			int g = greedy(denominations, i);
			int d = dP[i];
			if (g != d) {
				counter_examples.add(i);
			}
		}
		for(int i =0; i<counter_examples.size(); i++) {
			minCE = Math.min(minCE, counter_examples.get(i)); 
		}
		if(minCE<Integer.MAX_VALUE) {
			return minCE;
		}else {
			return -1;
		}
	}
	private static int[] dPTable(int[] denominations, int amount) {
	    int[] dTable = new int[amount + 1];
	    Arrays.fill(dTable, Integer.MAX_VALUE);
	    dTable[0] = 0;
	    for (int i = 1; i <= amount; i++) {
	        for (int c = 0; c < denominations.length; c++) {
	            if (denominations[c] < i) {
	                int subResult = dTable[i - denominations[c]]; // check if previous calculations has been made
	                if (subResult != Integer.MAX_VALUE && subResult + 1 < dTable[i]) {
	                    dTable[i] = subResult + 1;
	                }
	            }
	            if(denominations[c] == i){
	            	dTable[i] = 1;
	            }
	        }
	    }
	    return dTable;
	}
private static int greedy(int[] denominations, int amount) {
		int count = 0;
		if(amount == 0) {
			return 0;
		}else if(amount <0) {
			return -1;
		}else {
			for (int i = denominations.length-1; i >-1; i--) {
				int count1 = amount / denominations[i];
				count += count1;
				amount -= count1 * denominations[i];
			}
			if(amount == 0) {
				return count;
			}else {
				return -1;
			}
		}
	}
}
