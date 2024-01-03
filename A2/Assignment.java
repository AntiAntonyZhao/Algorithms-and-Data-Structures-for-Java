import java.util.*;

class Assignment implements Comparator<Assignment>{
	int number;
	int weight;
	int deadline;

	protected Assignment() {
	}

	protected Assignment(int number, int weight, int deadline) {
		this.number = number;
		this.weight = weight;
		this.deadline = deadline;
	}

	/**
	 * This method is used to sort to compare assignment objects for sorting. 
	 */
	@Override
	public int compare(Assignment a1, Assignment a2) {
		// TODO Implement this
		int weightCompare = Integer.compare(a2.weight, a1.weight);
		if (weightCompare != 0) {
			return weightCompare;
		}else {
			int deadlineCompare = Integer.compare(a1.deadline, a2.deadline);
			if(deadlineCompare !=0) {
				return deadlineCompare;
			}else {
				return 0;
			}
		}
	}
}
