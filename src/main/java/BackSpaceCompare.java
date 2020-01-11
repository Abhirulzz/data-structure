import java.util.Iterator;
import java.util.List;

public class BackSpaceCompare {
	
	
	public static boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) return S == T;
        int m = S.length(), n = T.length();
        int i = m - 1, j = n - 1;
        int cnt1 = 0, cnt2 = 0;//number of '#';
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (S.charAt(i) == '#' || cnt1 > 0)) {
                if (S.charAt(i) == '#') { cnt1++;}
                else { cnt1--;}
                i--;
            }
            while (j >= 0 && (T.charAt(j) == '#' || cnt2 > 0)) {
                if (T.charAt(j) == '#') {cnt2++;}
                else {cnt2--;}
                j--;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                return i == -1 && j == -1; // empty
            }
        }
        return true;
    }
	
	public static void main(String[] args) 
	{ 
		//String a[] = {"abcd","dcba","lls","as","sssll"};
		Boolean back = backspaceCompare( "#ac##a",  "aaa##");
		
		if (back) {
	        System.out.println("true");
	    }
		else
		{
			System.out.println("false");
		}
	}

}
