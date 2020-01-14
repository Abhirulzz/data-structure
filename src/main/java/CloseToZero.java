import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CloseToZero {
	
	public static List<List<Integer>> findPairWithMinSum(int arr[]) {
		 
		// Sort the array, you can use any sorting algorithm to sort it
		
		//List<Integer> close =new ArrayList();
		
		Arrays.sort(arr);
		int sum=0; 
		int minimumSum = Integer.MAX_VALUE;
		int n=arr.length;
		int count=0;
		if(n<0)
			return null;
		// left and right index variables
		int l = 0, r = n-1;
		Map<Integer, List<List<Integer>>> wordSet = new HashMap<>();
		
		
		
		// variables to keep track of the left and right index pair for minimumSum
		int minLeft = l, minRight = n-1;
 
		while(l < r)
		{
			List<List<Integer>> pair =new ArrayList();
			sum = arr[l] + arr[r];
			//sum2=sum*sum;
 
			/*If abs(sum) is less than min sum, we need to update sum and pair */
			if(Math.abs(sum) <= Math.abs(minimumSum))
			{
				
				
				minimumSum = Math.abs(sum);
				minLeft = l;
				minRight = r;
			
				//wordSet.putIfAbsent(minimumSum, new ArrayList<Integer>());
				if(wordSet.get(minimumSum)!=null)
				{
					List<Integer> close =new ArrayList();;
					pair.addAll(wordSet.get(minimumSum));
					pair.add(Arrays.asList(arr[minLeft],arr[minRight]));
					wordSet.put(minimumSum,pair);
			}else
			{
				//wordSet.put(minimumSum, (Arrays.asList(arr[minLeft],arr[minRight])));
				pair.add(Arrays.asList(arr[minLeft],arr[minRight]));
				wordSet.put(minimumSum, pair);
			}
			
				
				
			}
			
			if(sum < 0)
				l++;
			else
				r--;
		}
		if (wordSet.containsKey(minimumSum)) {
            return wordSet.get(minimumSum);
        }
		System.out.println(" The pair whose sum is minimun : "+arr[minLeft]+" "+ arr[minRight]);
		
		return null;
 
		//System.out.println(" The pair whose sum is minimun : "+arr[minLeft]+" "+ arr[minRight]);
	}
	public static void main(String[] args) 
	{ 
		//int a[] = {9, 7, 2, 4, 6, 8, 2, 1, 5}; 
		int a[] = {3,-5,4,-2,10,11,-12}; 
	
	System.out.println("The pair whose sum is closest to zero");
	//findPairWithMinSum(a);
	List<List<Integer>> PalinList= findPairWithMinSum(a);
	Iterator<List<Integer>> it = PalinList.iterator();
    while (it.hasNext()) {
        System.out.println(it.next());
    }	
	}

}
