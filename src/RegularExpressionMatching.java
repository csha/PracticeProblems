import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RegularExpressionMatching {
/*

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

abc = .*c
abcd = a.*c*
		  
*/
	
	public static boolean isMatch(String S, String P)
	{
		if(S.equals(P)) {return true;}
		if((S.length()<= 0) && (P.length()<= 0)) {return true;}
		
		
		boolean truthBoolean = false;
		char[] SCharArray = S.toCharArray();
		char[] PCharArray = P.toCharArray();
		Deque<String> stack = new ArrayDeque<String>();
			//Element is either
			// c
			// .
			// .*
			// c*
			//So use stacks and check if elements match.
		int ptr1 = 0;
		int ptr2 = 0;
		
		
		while(true)
		{
			if(ptr1 >= S.length()) {break;}
			
			//Selecting each element (either a char or char*)
			char selecter = SCharArray[ptr1];
			if(ptr1 + 1 <S.length()) //looking if * is present
				{
					if(SCharArray[ptr1+1] == '*')
					{
						String element = new StringBuilder().append(SCharArray[ptr1]).append(SCharArray[ptr2]).toString();
						stack.push(element);
						ptr1++;
						ptr1++;
					}
					else
					{
						String element = new StringBuilder().append(SCharArray[ptr1]).toString();
						stack.push(element);
						ptr1++;
					}
				}
			else
			{
				String element = new StringBuilder().append(SCharArray[ptr1]).toString();
				stack.push(element);
				ptr1++;
			}
			//element is stacked.
			
			
			
			
			
			break;
		}
		
		return truthBoolean;
	}
	
	public static void main(String[] args) {
		
		char test1 = 'a';
		char test2 = 'b';
		String test = new StringBuilder().append(test1).append(test2).toString();
	}

}
