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
		char[] str1 = S.toCharArray();
		char[] str2 = P.toCharArray();
		
		int str1ptr = 0;
		int str2ptr = 0;
		while(true)
		{
			
			// cases:
			// 1) Basic char
			// 2) Basic char with *
			// 3) .
			// 4) .*
			int str1case;
			int str2case;
			
			
			char char1 = str1[str1ptr];
			boolean ast1 = false;
			//check for following asterisk 
			if(str1ptr+1 < str1.length) 
				{if(str1[str1ptr+1] == '*') {ast1 = true;}}
			
			
			char char2 = str2[str2ptr];
			boolean ast2 = false;
			//check for following asterisk 
			if(str2ptr+1 < str2.length) 
				{if(str2[str2ptr+1] == '*') {ast2 = true;}}
			
			
			//setting cases for str1
			if(char1 == '.' && ast1) {str1case=4;}
			else if(char1 == '.') {str1case = 3;}
			else if(ast1) {str1case =2;}
			else {str1case = 1;}
			//setting cases for str2
			if(char2 == '.' && ast2) {str2case=4;}
			else if(char2 == '.') {str2case = 3;}
			else if(ast2) {str2case =2;}
			else {str2case = 1;}

			
			
			
			
			
			
			
			
			
			
		}
		
	}
	
	public static void main(String[] args) {
		
		char test1 = 'a';
		char test2 = 'b';
		String test = new StringBuilder().append(test1).append(test2).toString();
	}

}
