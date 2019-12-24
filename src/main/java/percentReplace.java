
public class percentReplace {

	public static void ReplaceFun(char[] str, int length) {
		int spaceCount = 0, newLength, i = 0;
		//char[] str1 = new char[myChar.length];
		for (i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		newLength = length + spaceCount * 2;
		char[] str1 = new char[newLength];
		System.out.println(str1.length);
		 //str1 =str;
		 
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str1[newLength - 1] = '0';
				str1[newLength - 2] = '2';
				str1[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str1[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		System.out.println("Output String : " + String.valueOf(str1));
	}
	
	public static void replace(String s1, int length) {
		char[] chars = s1.toCharArray();
		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (chars[i] == ' ') {
				spaceCount++;
			}
		}
		int newLength = length + 2 * spaceCount;
		char [] charsNew = new char [newLength];
		for (int i = length - 1; i >= 0; i--) {
			if (chars[i] == ' ') {
				charsNew[newLength - 1] = '0';
				charsNew[newLength - 2] = '2';
				charsNew[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
//				System.out.println(chars[i]);
				charsNew[newLength - 1] = chars[i];
				newLength = newLength - 1;
			}
		}
		System.out.println("Output String : " + String.valueOf(charsNew));
	
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub remove duplicate without buffers
		String str = "ji ji j";
		// char[] myChar1 = str.toCharArray();
        char[] myChar = str.toCharArray();
        int len = myChar.length ;
        replace(str,len);
        char[] myAna = new char[myChar.length];
        System.out.println(str);
        ReplaceFun(myChar, len);
        System.out.println(str);
	}
}
