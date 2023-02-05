package working_array_01;

public class Array {
	public static void main(String[] args) {
		int nums[] = { 2, 0, 1, 3};
		int evenSum = 0, oddSum = 0; 
		int i;
		int n;
		for (i = 0; i < 4; i++) {
			n = nums[i];
			System.out.printf("nums[%d] = %d%n", i , n);
			if (i % 2 == 0) {
				evenSum += n;
			} else {
				oddSum += n;
			}
		}
		
		System.out.println("Even indices sum: " + evenSum);
		System.out.println("Odd indices sum: " + oddSum);
	}
}
