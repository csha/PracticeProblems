import java.util.ArrayList;
import java.util.List;
public class MaxProductOfWordLengths {

public static boolean doesNotShareChars(String str1, String str2)
{
	ArrayList<Character> str1List = new ArrayList<Character>();
	char[] str1Array = str1.toCharArray();
	char[] str2Array = str2.toCharArray();
	
	for(int i = 0; i < str1.length() ; i++)
	{
		if(!str1List.contains(str1Array[i])) {str1List.add(str1Array[i]);}
		
	}
	
	for(int k = 0; k < str2.length(); k++)
	{
		if(str1List.contains(str2Array[k])) {return false;}
	}
	return true;
}
	
public static int maxProduct(String[] words) {
     int maxProduct = 0;
     if(words.length < 2) {return 0;}
     for(int ptr1 = 0; ptr1 < words.length; ptr1++)
     {
    	 for(int ptr2 = ptr1+1; ptr2 < words.length; ptr2++)
    	 {
    		 if(words[ptr1].length() * words[ptr2].length() > maxProduct)
    		 {
    			 if (doesNotShareChars(words[ptr1], words[ptr2])) 
    			 {maxProduct = words[ptr1].length() * words[ptr2].length();}
    		 }
    	 }
     }
     
     
     return maxProduct;
	
    }
	

public static void main(String[] args) {
	String[] words = new String[5];
	String String1 = "abcd";
	String String2 = "1234";
	String String3 = "1234e";
	String String4 = "ty";
	String String5 = "55555";
	
	words[0] = String1;
	words[1] = String2;
	words[2] = String3;
	words[3] = String4;
	words[4] = String5;
	
	System.out.println(maxProduct(words));
	

}

}
