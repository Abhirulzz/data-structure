
public class CString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub remove duplicate without buffers
		String str = "jiji";
		 char[] myChar1 = str.toCharArray();
        char[] myChar = str.toCharArray();
        char[] myAna = new char[myChar.length];
        System.out.println(str);
        int p1 = 0;
        int p2 = myChar.length -1;
        int d1 = 0;
        int d2 = myChar.length -1;
        int len = myChar.length ;

        while(p1<p2)
        {
            char temp = myChar[p1];
            myChar[p1]= myChar[p2];
            myChar[p2] = temp;

            p1++;
            p2--;
        }
        /* check anagram */
        while(d1<len)
        {
            
            myAna[d1]= myChar1[d2];
           
            d1++;
            d2--;
        }
        //System.out.println("Ana" +String.valueOf((myAna)));
        if (str.equals(String.valueOf((myAna))))
        {
        System.out.println("Anagram");	
        }
        else
        {
        	System.out.println("not anagram");
        }

        str = str.copyValueOf(myChar);

        System.out.println(str);
        int i=0;
        int tail = 1; /* without duplicate */
        for (i = 1; i < len; ++i)
        {
                int j;
                for (j = 0; j < tail; ++j)
                {
                        if (myChar[i] == myChar[j])
                                break;
                }
                if (j == tail)
                {
                        myChar[tail] = myChar[i];
                        ++tail;
                }
        }
        if (tail==len)
        {
        	System.out.println("unique");
        }
        else
        {
        	System.out.println("duplicate");
        }
        for (int j= tail;j < len; ++j)
        {
        myChar[j] = 0;
        }
        str = str.copyValueOf(myChar);
        System.out.println(str);

	}

}
