// Java implementation of the approach 
import java.util.*; 

class SlidingWindow 
{ 

	// Function to print the maximum for 
	// every k size sub-array 
	static void print_max(int a[], int n, int k) 
	{ 
		// max_upto array stores the index 
		// upto which the maximum element is a[i] 
		// i.e. max(a[i], a[i + 1], ... a[max_upto[i]]) = a[i] 

		int[] max_upto = new int[n]; 

		// Update max_upto array similar to 
		// finding next greater element 
		Stack<Integer> s = new Stack<>(); 
		s.push(0); 
		for (int i = 1; i < n; i++) 
		{ 
			while (!s.empty() && a[s.peek()] < a[i]) 
			{ 
				max_upto[s.peek()] = i - 1; 
				s.pop(); 
			} 
			s.push(i); 
		} 
		while (!s.empty()) 
		{ 
			max_upto[s.peek()] = n - 1; 
			s.pop(); 
		} 
		int j = 0; 
		for (int i = 0; i <= n - k; i++) 
		{ 

			// j < i is to check whether the 
			// jth element is outside the window 
			while (j < i || max_upto[j] < i + k - 1) 
			{ 
				j++; 
			} 
			System.out.print(a[j] + " "); 
		} 
		System.out.println(); 
	} 
	
	public double[] medianSlidingWindow(int[] nums, int k) {
	    if (k == 0) return new double[0];
	    double[] ans = new double[nums.length - k + 1];
	    int[] window = new int[k];
	    for (int i = 0; i < k; ++i) 
	      window[i] = nums[i];
	    Arrays.sort(window);
	    for (int i = k; i <= nums.length; ++i) {
	      ans[i - k] = ((double)window[k / 2] + window[(k - 1)/2]) / 2;
	      if (i == nums.length) break;
	      remove(window, nums[i - k]);
	      insert(window, nums[i]);
	    }
	    return ans;
	  }
	  
	  // Insert val into window, window[k - 1] is empty before inseration
	  private void insert(int[] window, int val) {
	    int i = Arrays.binarySearch(window, val);
	    if (i < 0) i = - i - 1;    
	    int j = window.length - 1;
	    while (j > i) window[j] = window[--j];
	    window[j] = val;
	  }
	  
	  // Remove val from window and shrink it.
	  private void remove(int[] window, int val) {
	    int i = Arrays.binarySearch(window, val);
	    while (i < window.length - 1) window[i] = window[++i];
	  }

	// Driver code 
	public static void main(String[] args) 
	{ 
		int a[] = {9, 7, 2, 4, 6, 8, 2, 1, 5}; 
		int n = a.length; 
		int k = 3; 
		print_max(a, n, k); 

	} 
} 

// This code has been contributed by 29AjayKumar 
