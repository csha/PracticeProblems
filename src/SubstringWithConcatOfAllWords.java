import java.util.ArrayList;
import java.util.List;

public class SubstringWithConcatOfAllWords {
	
/* You are given a string, s, and a list of words, words, that are all of the same length.
		 *  Find all starting indices of substring(s) in s that is a concatenation of each word in words 
		 *  exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter). 
		 * 
		 * */
	
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> returnList = new ArrayList<>();
        if(words.length <= 0) {return returnList;}
        
       
        int wordLength = words[0].length();
        int wordLengthSum = wordLength * words.length;
        if(s.length() <= wordLength) {return returnList;}
        
        int strPtr = 0;
        while(strPtr < (s.length() - wordLengthSum ))
        {
        	//Check if this substring of size wordLength matches any words
        	boolean found = false;
        	for(int i = 0; i < words.length; i++)
        	{
        		if()
        	}
        	
        	if(!found)
        	{}
        	
        }
        
        
        
        
        return returnList;
    }
	
	
	public static void main(String[] args) {
		
		

	}

}
