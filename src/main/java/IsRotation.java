import java.util.Scanner;

public class IsRotation {
	/*
     * Idea: Same idea as the code in CC150 book
     * First, if the s2 is a rotation of s1, they should have the same length
     * Then, check whether the s2 is a subString of s1 + s1
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s3 = s1 + s1;
        // return isSubString(s3, s2);
        return isSubString2(s3, s2);
    }

   /* private static boolean isSubString(String s3, String s2) {
        return s3.contains(s2);
        // return s3.indexOf(s2)!=-1;
    } */
    
    /*
     * Implement the isSubString method without using the method of Contains and indexOf
     */
    private static boolean isSubString2(String s3, String s2){
        int lengthS3 = s3.length();
        int lengthS2 = s2.length();
        for (int i = 0; i < lengthS3; i++) {
            int j = i;
            int k = 0;
            while(s2.charAt(k++) == s3.charAt(j++)){
                if(k == lengthS2)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter string1 (q to quit):");

        while (input.hasNextLine()) {
            String string1 = input.nextLine();
            if (string1.equals("q")) {
                System.out.println("quit...");
                System.exit(0);
            }
            System.out.println("Please enter string2:");
            String string2 = input.nextLine();

            System.out.println("Is s2 a rotation of s1?(solution1) :"
                    + isRotation(string1, string2));
            System.out.println();
            System.out.println("Please enter another string1 (q to quit): ");
        }
    }

}
