import java.util.HashMap;

public class ProductArray {
	
	public static int[] returnProductArray(int[] nums) {
		
		int[] productArray;
		int product;
		
		// check array is not empty 
		if (nums.length == 0 || nums == null) {
			return null;
		} else {
			productArray = new int[nums.length];
			product = 1;
		}
		
		// get the product of all the integers in the array
		for (int i = 0; i < nums.length; i++) {
			product *= nums[i];
		} 
		
		// set the ith element of the productArray to the product divided by the ith element in the nums array
		for (int i = 0; i < nums.length; i++) {
			productArray[i] = product / nums[i];
		}
		
		return productArray;
	}
	
	public static int[] returnProductArrayNoDivide(int[] nums) {
		
		int[] productArray;
		int product;
		
		// check array is not empty 
		if (nums.length == 0 || nums == null) {
			return null;
		} else {
			productArray = new int[nums.length];
		}
	
		// productArray[i] contains the product of all the elements to the left
		// but at index 0, there are no elements to the left so it equals 0
	    productArray[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			// productArray[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all 
            // elements to the left of index 'i'
			productArray[i] = productArray[i - 1] * nums[i - 1];
		}
		
		// product contains the product of all the elements to the right
        // but for the last element in productArray, there are no elements to the right,
        // so product equals 1
		product = 1;
		for (int i = nums.length - 1; i > 0; i--) {
			// For the index 'i', product would contain the 
            // product of all elements to the right. We update it accordingly
			product = product * nums[i];
			productArray[i - 1] = product * productArray[i - 1];
		}
		
		return productArray;
		
	}

	public static void main(String[] args) {
		int[] arr = {4, 2, 5, 1};
		int[] newArr = returnProductArrayNoDivide(arr);
//		for (int i = 0; i < newArr.length; i++) {
//			System.out.print(Integer.toString(newArr[i]) + ", ");
//		}
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(Integer.toString(newArr[i]) + ", ");
		}
	}
	
	
}
