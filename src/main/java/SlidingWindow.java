// Java implementation of the approach 
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

class SlidingWindow 
{ 
	
		// A Dequeue (Double ended queue) based method for printing maximum element of 
		// all subarrays of size k 
		static void printMax(int arr[], int n, int k) 
		{ 
			// Create a Double Ended Queue, Qi that will store indexes of array elements 
			// The queue will store indexes of useful elements in every window and it will 
			// maintain decreasing order of values from front to rear in Qi, i.e., 
			// arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order 
			Deque<Integer> Qi = new LinkedList<Integer>(); 

			/* Process first k (or first window) elements of array */
			int i; 
			for (i = 0; i < k; ++i) { 
				// For every element, the previous smaller elements are useless so 
				// remove them from Qi 
				while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) 
					Qi.removeLast(); // Remove from rear 

				// Add new element at rear of queue 
				Qi.addLast(i); 
			} 

			// Process rest of the elements, i.e., from arr[k] to arr[n-1] 
			for (; i < n; ++i) { 
				// The element at the front of the queue is the largest element of 
				// previous window, so print it 
				System.out.print(arr[Qi.peek()] + " "); 

				// Remove the elements which are out of this window 
				while ((!Qi.isEmpty()) && Qi.peek() <= i - k) 
					Qi.removeFirst(); 

				// Remove all elements smaller than the currently 
				// being added element (remove useless elements) 
				while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) 
					Qi.removeLast(); 

				// Add current element at the rear of Qi 
				Qi.addLast(i); 
			} 

			// Print the maximum element of last window 
			System.out.print(arr[Qi.peek()]); 
		} 

		
		public static int[] maxSlidingWindow(int[] nums, int k) {
		    if(nums==null||nums.length==0)
		        return new int[0];
		 
		    int[] result = new int[nums.length-k+1];
		 
		    Deque<Integer> deque = new LinkedList<Integer>();
		    for(int i=0; i<nums.length; i++){
		        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
		            deque.removeFirst();
		 
		        while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
		            deque.removeLast();
		        }    
		 
		        deque.addLast(i);
		 
		        if(i+1>=k)
		            result[i+1-k]=nums[deque.peekFirst()];
		    }
		 
		    return result;
		}
		
	// This code is contributed by Sumit Ghosh 


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
	
	public static double[] medianSlidingWindow(int[] nums, int k) {
	    if (k == 0) return new double[0];
	    double[] ans = new double[nums.length - k + 1];
	    int[] window = new int[k];
	    for (int i = 0; i < k; ++i) 
	      window[i] = nums[i];
	    Arrays.sort(window);
	    for (int i = k; i <= nums.length; ++i) {
	     // ans[i - k] = ((double)window[k / 2] + window[(k - 1)/2]) / 2;
	      ans[i - k]=(double)window[k-1];
	      if (i == nums.length) break;
	      remove(window, nums[i - k]);
	      insert(window, nums[i]);
	    }
	    //System.out.print(a[j] + " "); 
	    return ans;
	  }
	  
	  // Insert val into window, window[k - 1] is empty before inseration
	  private static void insert(int[] window, int val) {
	    int i = Arrays.binarySearch(window, val);
	    if (i < 0) i = - i - 1;    
	    int j = window.length - 1;
	    while (j > i) window[j] = window[--j];
	    window[j] = val;
	  }
	  
	  // Remove val from window and shrink it.
	  private static void remove(int[] window, int val) {
	    int i = Arrays.binarySearch(window, val);
	    while (i < window.length - 1) window[i] = window[++i];
	  }
	  
	  public static String minWindow(String s, String t) {
	        Map<Character, Integer> map = new HashMap();
	        String ans = "";
	        int begin = 0;
	        int end = 0;
	        int numberOfUniques = 0;
	        int[] range = new int[2];
	        range[1] = Integer.MAX_VALUE;
	        char[] letters = s.toCharArray();
	        char[] tArray = t.toCharArray();
	        for(int i = 0; i < tArray.length; i++){
	            map.put(tArray[i], map.getOrDefault(tArray[i], 0) + 1);
	        }
	        
	        numberOfUniques = map.size();
	        
	        
	        /*
	            if all characters in T are included in current substring -> shrink substring until false
	            if all characters in T are not included in current substring -> expand window
	        */
	        while(end < letters.length){
	            
	            // window condition is not satisfied
	            if(numberOfUniques != 0){
	                
	                if(map.containsKey(letters[end])){
	                    map.put(letters[end], map.get(letters[end]) - 1);
	                    if(map.get(letters[end]) == 0){
	                        numberOfUniques--;
	                    }     
	                }
	 
	                end++;
	            }
	            
	            else if(numberOfUniques == 0) {
	                
	                while(begin < end && numberOfUniques == 0){
	                    if(end - begin < range[1] - range[0]){
	                        range[0] = begin;
	                        range[1] = end; 
	                    }
	                    
	                    if(map.containsKey(letters[begin])){
	                        map.put(letters[begin], map.get(letters[begin]) + 1);
	                        if(map.get(letters[begin]) > 0)
	                            numberOfUniques++;
	                    }
	                    
	                    begin++;
	                }
	            }
	        }
	        
	        // move the begin pointer to the end and check for potential small substrings
	        while(begin < letters.length){
	            if(numberOfUniques == 0){
	                
	                if(end - begin < range[1] - range[0]){
	                    range[0] = begin;
	                    range[1] = end; 
	                }
	                
	                if(map.containsKey(letters[begin])){
	                    map.put(letters[begin], map.get(letters[begin]) + 1);
	                        if(map.get(letters[begin]) > 0)
	                            numberOfUniques++;
	                }
	            }
	            begin++;
	        }
	        
	        // that means our range is still 0-0 
	        if(range[1] == Integer.MAX_VALUE) return "";
	        return s.substring(range[0], range[1]);
	    }
	  
	  
	public static boolean increasingTriplet(int[] num) {
		while (num.length >= 3) {
			for (int i = 1; i < num.length - 1; i++) {
				int j = i + 1;
				int back = i - 1;
				if (num[i] > num[j] || num[i] < num[back]) {
					return false;
				}

			}
			return true;
		}
		return false;
	}
	
	public static String longestPalindrome(String s) {
	    if (s == null || s.length() < 1) return "";
	    int start = 0, end = 0;
	    for (int i = 0; i < s.length(); i++) {
	        int len1 = expandAroundCenter(s, i, i);
	        int len2 = expandAroundCenter(s, i, i + 1);
	        int len = Math.max(len1, len2);
	        if (len > end - start) {
	            start = i - (len - 1) / 2;
	            end = i + len / 2;
	        }
	    }
	    return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
	    int L = left, R = right;
	    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	        L--;
	        R++;
	    }
	    return R - L - 1;
	}

	// Driver code 
	public static void main(String[] args) 
	{ 
		//int a[] = {9, 7, 2, 4, 6, 8, 2, 1, 5}; 
		int a[] = {1,2,3,6,7,9}; 
	//	System.out.println(increasingTriplet(a));
		int n = a.length; 
		int k = 4; 
	//	printMax(a, n, k); //deque
	//	print_max(a, n, k); // stack
	/*	double ans[]=medianSlidingWindow(a,3); //binarysearchtree
		int deq[]=maxSlidingWindow(a,k);
		for(int i=0;i<ans.length;i++)
		{
			System.out.print(ans[i] + " "); 	
		}
		
		System.out.println();
		for(int i=0;i<deq.length;i++)
		{
			System.out.print(deq[i] + " "); 	
		}*/
		//String minwin=minWindow("AOCOOBOCAOBACA", "AABC");
	//	System.out.println();
	//	System.out.print(minwin);
		System.out.println(longestPalindrome("abcccabaccc"));

	} 
} 

// This code has been contributed by 29AjayKumar 
