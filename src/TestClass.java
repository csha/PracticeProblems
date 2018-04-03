import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.tree.TreeNode;

public class TestClass {

public static double findMedianSortedArrays(int[] nums1, int[] nums2)  {
    
    Deque<Integer> stack = new ArrayDeque<Integer>();
    int totalLength = nums1.length + nums2.length;
    boolean ptr1Finished = false;
    boolean ptr2Finished = false;
    int ptr1 = 0;
    int ptr2 = 0;
    
     if(nums1.length <= 0) {ptr1Finished = true;}
    if(nums2.length <= 0) {ptr2Finished = true;}
    
    
    for(int i = 0; i <= totalLength/2; i++)
    {
            if(ptr1Finished)
            {stack.push(nums2[ptr2]);
                ptr2++;}
            else if(ptr2Finished){stack.push(nums1[ptr1]);
                ptr1++;}
                
            else if(nums1[ptr1] <= nums2[ptr2])
            {
                stack.push(nums1[ptr1]);
                ptr1++; 
                if(ptr1 >= nums1.length){ptr1Finished = true;}
            }
            else
            {
                stack.push(nums2[ptr2]);
                ptr2++;
                if (ptr2 >= nums2.length){ptr2Finished = true;}
            }
        
    
    }
    
 if(totalLength %2 ==0){double sum = stack.pop() + stack.pop(); sum = sum/2; return sum; }
    else {return stack.pop();}
    
}



/*
 * 
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:

Input: J = "z", S = "ZZ"
Output: 0

 * */
public int numJewels(String J, String S)
{
	char[] Jarray = J.toCharArray();
	char[] Sarray = S.toCharArray();
	ArrayList<Character> jewelList = new ArrayList<>();
	
	for(char e : Jarray)
	{	
		{jewelList.add(e);}
	}
	
	int tally = 0;
	for (char e : Sarray)
	{
		if(jewelList.contains(e)) {tally++;}
	}
	
	return tally;
}


public static int[] anagramMapping(int[] A, int[] B)
{
int[] returnArray = new int[A.length];
ArrayList<Integer> usedPositions = new ArrayList<Integer>();	
for(int i = 0; i< A.length; i++)
{
	int position = 0;
	while(true)
	{
		if(B[position] == A[i])
		{
			if(!(usedPositions.contains(position)))
			{
				usedPositions.add(position);
				returnArray[i] = position;
				break;
			}
		}
		position++;
	}
}

return returnArray;

}


public static int myATOI(String str)
{
	ArrayList<Character> numbers = new ArrayList<Character>();
	numbers.add('0'); numbers.add('1'); numbers.add('2'); numbers.add('3'); numbers.add('4'); numbers.add('5'); numbers.add('6'); numbers.add('7'); numbers.add('8'); numbers.add('9'); 
	if(str.length() <= 0) {return 0;}
	char whitespace = ' ';
	char[] myCharArray = str.toCharArray();
	boolean negativeFlag = false;
	ArrayList<Integer> digitList = new ArrayList<>();
	//Find Whitespaces
	
	
	int index = 0;
	
	while(true)
	{
		if(myCharArray[index] == whitespace)
		{	if(index+1 >= str.length()) {break;}
			index++;
			}
		else {break;}
	}
	if(myCharArray[index] == '-') {negativeFlag = true; if(index+1 <str.length()) {index++;}else{return 0;}}
	else if(myCharArray[index] == '+') {if(index+1 <str.length()) {index++;}else{return 0;}}
	while(true)
	{
		if(numbers.contains(myCharArray[index])) 
			{digitList.add(Character.getNumericValue(myCharArray[index]));
			if(index+1 >= str.length()) {break;}
			index++;
			}
		else {break;}
	}

	
	int toReturn = 0;
	if(digitList.size() == 0) {return toReturn;}
	if(digitList.size() > 10) {if(negativeFlag) {return -2147483648;}else {return 2147483647;}}
	if(digitList.size()== 10) 
	{
		if(digitList.get(0) > 2)
		{
			if(negativeFlag) {return -2147483647;}else {return 2147483647;}
		}
		else if(digitList.get(0) < 2)
		{for(int i = 0; i < digitList.size(); i++)
		{
			{toReturn = toReturn * 10;
			toReturn += digitList.get(i);}
		}}
		
		else {
			int sum = 0;
			for(int i = 1; i < digitList.size(); i ++)
			{
				sum = sum * 10;
				sum += digitList.get(i);
			}
			if(negativeFlag) {if(sum>147483648) {return -2147483648;}else{return (0 - (2000000000 + sum));}}
			else if(sum>147483647) {if(negativeFlag) {return -2147483647;}else {return 2147483647;}}
			else {if(negativeFlag){return (0 - (2000000000 + sum)); }else{return 2000000000 + sum;}}
		}
	}
	
	else {
		for(int i = 0; i < digitList.size(); i++)
		{
			{toReturn = toReturn * 10;
			toReturn += digitList.get(i);}
		}
	}
	
	if(negativeFlag) {return 0-toReturn;}
	else {return toReturn;}
}

public static String longestPalindrome(String S)
{
	//Step 1: find matching : bb or matching seperated by 1: bab
	//Step 2: See how far each entry goes.
	
	if(S.length() <= 0) {return "";}
	if(S.length() == 1) {return S;}
	
	ArrayList<Integer> consecDupe = new ArrayList<>(); //index of first b in bb
	ArrayList<Integer> sepDupe = new ArrayList<>(); //index of a in bab
	
	
	for (int i = 0 ; i < S.length() - 1; i++)
	{
		if(S.charAt(i) == S.charAt(i+1)) {consecDupe.add(i);}
		if((i > 0) && (S.charAt(i-1) == S.charAt(i+1))) {sepDupe.add(i);}
	}
	
	if(consecDupe.isEmpty() && sepDupe.isEmpty()) {return S.substring(0, 1);}
	
	int maxLength = 0;
	int startingIndex = 0;
	int endingIndex = 0;
	
	for(Integer index : consecDupe)
	{
		int tracker = 1;
		int currentLength = 2;
		while(true)
		{
			if(index - tracker < 0) {break;}
			if(index + 1 + tracker >= S.length()) {break;}
			if(S.charAt(index - tracker) == S.charAt(index + 1 + tracker))
			{currentLength += 2; tracker++;}
			else 
			{break;}
		}
		if(currentLength > maxLength) {maxLength = currentLength; startingIndex = (index - tracker) + 1; endingIndex = index + tracker; }
	}
	
	for(Integer index : sepDupe)
	{
		int tracker = 2;
		int currentLength = 3;
		while(true)
		{
			if(index - tracker < 0) {break;}
			if(index + tracker >= S.length()) {break;}
			if(S.charAt(index - tracker) == S.charAt(index + tracker))
			{currentLength += 2; tracker++;}
			else 
			{break;}
		}
		if(currentLength > maxLength) {maxLength = currentLength; startingIndex = (index - tracker) + 1; endingIndex = index + (tracker-1); }
	}
	return S.substring(startingIndex, endingIndex+1);
	
}


public int firstUniqChar(String s) {
	if(s.length() == 1) {return 0;}
    char[] charArr = s.toCharArray();
    HashMap<Character, Integer> charCount = new HashMap<>();
    for(char c : charArr)
    {
    	if(charCount.containsKey(c)) {charCount.put(c, 2);}
    	else {charCount.put(c, 1);}
    }
    for(int index = 0; index < s.length(); index++)
    {
    	int count = charCount.get(charArr[index]);
    	if (count == 1) {return index;}
    }
    
	return -1;
}

public int[] singleNumber(int[] nums) {
    //find the 2 elements that only appear once.
	ArrayList<Integer> dupeList = new ArrayList<>();
	for (int e : nums)
	{
		if (dupeList.contains(e))
		{dupeList.remove(Integer.valueOf(e));}
		else {dupeList.add(e);}
	}
	int[] toReturn = new int[2];
	for(int i = 0; i < 2; i++)
	{
		toReturn[i] = dupeList.get(i);
	}
	return toReturn;
}

public static int getFirstDigit(int num)
{
	int x = num;
	while(x > 9)
	{
		x = x/10;
	}
	return x;
}

public static boolean findIfFirstIsLargerOfTwo(int num1, int num2)
{
	//this alg assumes larger/longer number is first. num1 can not be shorter than num2
	//so true if num1 is larger in the sense that 33 > 301 (most sig digit compared)
	 Deque<Integer> stack1 = new ArrayDeque<Integer>();
	 Deque<Integer> stack2 = new ArrayDeque<Integer>();
	 int t1 = num1;
	 int t2 = num2;
	 if(t1 <= 9) {stack1.push(t1);}
	 while(t1 > 9)
	 {
		 
		 stack1.push(t1%10);
		 t1 = t1/10;
	 }
	 if(t2 <= 9) {stack2.push(t2);}
	 while(t2 > 9)
	 {
		 stack2.push(t2%10);
		 t2 = t2/10;
	 }
	 int sameness = 0;
	 while(sameness < 10)
	 {
		 if(stack2.isEmpty()) 
		 {
			 sameness++;
			 t2 = num2;
			 while(t2 > 9)
			 {
				 stack2.push(t2%10);
				 t2 = t2/10;
			 }
			 if(t2 <= 9) {stack2.push(t2);}
		 }
		 if(stack1.isEmpty())
		 {
			 sameness++;
			 t1 = num1;
			 
			 while(t1 > 9)
			 {
				 
				 stack1.push(t1%10);
				 t1 = t1/10;
			 }
			 if(t1 <= 9) {stack1.push(t1);}
		 }
		 t1 = stack1.pop();
		 t2 = stack2.pop();
		 System.out.println("Popouts are " + t1 + " " + t2);
		 if(t1 > t2) {return true;}
		 if(t2>t1) {return false;}
		 
	 }
	 
	 return true;
}

public static String largestNumber(int[] nums)
{
	
	//Max is determined by an int's most significant digit, followed by next most, etc.

	
int MaxIntValue = 0;
int MaxInt1stDigit = 0;
int MaxIntIndex;
for(int i = 0; i < nums.length; i++)
{
	MaxIntValue = nums[i];
	MaxInt1stDigit = getFirstDigit(nums[i]);
	for(int ptr2 = i+1; ptr2 < nums.length; ptr2++)
	{
		if(MaxIntValue == nums[ptr2]) {}
	else if(getFirstDigit(nums[ptr2]) > MaxInt1stDigit)
		{
			int temp = MaxIntValue;
			MaxIntValue = nums[ptr2];
			MaxInt1stDigit = getFirstDigit(nums[ptr2]);
			nums[i] = nums[ptr2];
			nums[ptr2] = temp;
		}
		else if (getFirstDigit(nums[ptr2]) == MaxInt1stDigit)
		{
			if(MaxIntValue >= nums[ptr2])
			{
				if(findIfFirstIsLargerOfTwo(MaxIntValue, nums[ptr2]))
				{
					//just continue, no swap needed
				}
				else 
				{
					int temp = MaxIntValue;
					MaxIntValue = nums[ptr2];
					MaxInt1stDigit = getFirstDigit(nums[ptr2]);
					nums[i] = nums[ptr2];
					nums[ptr2] = temp;
				}
			}
			else
			{
				if(findIfFirstIsLargerOfTwo(nums[ptr2], MaxIntValue))
				{
					int temp = MaxIntValue;
					MaxIntValue = nums[ptr2];
					MaxInt1stDigit = getFirstDigit(nums[ptr2]);
					nums[i] = nums[ptr2];
					nums[ptr2] = temp;
				}
				else 
				{
					//just continue, no swap needed
				}
			}
		}
	}
}

StringBuilder toBuildResult = new StringBuilder();
for(int e : nums)
{
	toBuildResult.append(e);
}
String ret = toBuildResult.toString();
return ret;

}

	
	public static void main(String[] args) {
		/*int[] array1 = new int[5];
		array1[0] = 1;
		array1[1] = 5;
		array1[2] = 9;
		array1[3] = 11;
		array1[4] = 13;
		
		int[] array2 = new int[4];
		array2[0] = 2;
		array2[1] = 6;
		array2[2] = 8;
		array2[3] = 10;
		
		
		System.out.println("Median is "+findMedianSortedArrays(array1, array2));
		String toGive1 = "dccc";
		String toGive2 = "abbaracecar";
		String toGive3 = "rarbbbb";
		System.out.println(longestPalindrome(toGive1));
		System.out.println(longestPalindrome(toGive2));
		System.out.println(longestPalindrome(toGive3));
		String atoitest1 = "213";
		String atoitest2 = " 213";
		String atoitest3 = " 213x";
		String atoitest4 = " x213x";
		String atoitest5 = "214748364";
		String atoitest6 = "2147483648";
		String atoitest7 = "-2147483647";
		String atoitest8 = "      -11919730356x";
		System.out.println(myATOI(atoitest1));
		System.out.println(myATOI(atoitest2));
		System.out.println(myATOI(atoitest3));
		System.out.println(myATOI(atoitest4));
		System.out.println(myATOI(atoitest5));
		System.out.println(myATOI(atoitest6));
		System.out.println(myATOI(atoitest7));
		System.out.println(myATOI(atoitest8));
		
		int[] ar1 = new int[3];
		int[] ar2 = new int[3];
		ar1[0] = 1;
		ar1[1] = 2;
		ar1[2] = 0;
		ar2[0] = 0;
		ar2[1] = 1;
		ar2[2] = 2;
		int[] solution = anagramMapping(ar1, ar2);
		System.out.println("");
		for(int e: solution) {System.out.print(e);}
		
		String abc = "abc";
		System.out.println("length is " + abc.length());
		for(int i = 0; i < abc.length(); i++) {System.out.println("X");}*/
		
		//[3,43,48,94,85,33,64,32,63,66]
		int[] ar1 = new int[8];
		ar1[0] = 3;
		ar1[1] = 43;
		ar1[2] = 48;
		ar1[3] = 94;
		ar1[4] = 85;
		ar1[5] = 33;
		ar1[6] = 63;
		ar1[7] = 34;
		System.out.println(largestNumber(ar1));
		
		

	}
}
