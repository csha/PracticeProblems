
public class findMinInRotatedSortedArray {

	/*
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.*/
	
public static int findMin(int[] nums) {
        //pick 2 numbers a couple spaces apart. If number of higher index is < number of lower index, pivot is between them.
	if(nums.length == 1) {return nums[0];}
	if(nums.length == 2) {if(nums[0] > nums[1]) {return nums[1];}else{return nums[0];}}
	
	int firstIndex = 0;
	int firstNum = nums[firstIndex];
	int middleIndex = nums.length/2;
	int middleNum = nums[middleIndex];
	int lastIndex = nums.length-1;
	int lastNum = nums[lastIndex];
	
	//No Pivot contingency:
	if(firstNum < lastNum) {return firstNum;}
	
	if(firstNum > middleNum) 
	{
		//pivot is between first and middle
		//check if middle is pivot.
		if(middleNum < nums[middleIndex-1]) {return nums[middleIndex];}
		else
		{	lastIndex = middleIndex;
			lastIndex = middleNum;
			middleIndex = (middleIndex + firstIndex)/2;	
			middleNum = nums[middleIndex];
			while(true)
			{
				if(firstNum > middleNum)
				{
					if(middleNum < nums[middleIndex-1]) {return nums[middleIndex];}
					else {
						lastIndex = middleIndex;
						lastIndex = middleNum;
						middleIndex = (middleIndex + firstIndex)/2;	
						middleNum = nums[middleIndex];
						if(middleNum < nums[middleIndex-1]) {return nums[middleIndex];}
						if(middleNum > nums[middleIndex+1]) {return nums[middleIndex+1];}
					}
				}
				else if(lastNum < middleNum)
				{
					if(middleNum > nums[middleIndex+1]) {return nums[middleIndex+1];}
					else
					{
						firstIndex = middleIndex;
						firstNum = middleNum;
						middleIndex = (middleIndex + lastIndex)/2;
						middleNum = nums[middleIndex];
						if(middleNum < nums[middleIndex-1]) {return nums[middleIndex];}
						if(middleNum > nums[middleIndex+1]) {return nums[middleIndex+1];}
					}
				}
			}
		}
	}
	else //if(lastNum < middleNum)
	{
		//pivot is between middle and last.
		//check if middle is pivot.
		if(middleNum > nums[middleIndex+1]) {return nums[middleIndex+1];}
		else 
		{
			firstIndex = middleIndex;
			firstNum = middleNum;
			middleIndex = (middleIndex + lastIndex)/2;
			middleNum = nums[middleIndex];
			while(true)
			{
				if(firstNum > middleNum)
				{
					if(middleNum < nums[middleIndex-1]) {return nums[middleIndex];}
					else {
						lastIndex = middleIndex;
						lastIndex = middleNum;
						middleIndex = (middleIndex + firstIndex)/2;	
						middleNum = nums[middleIndex];
						if(middleNum < nums[middleIndex-1]) {return nums[middleIndex];}
						if(middleNum > nums[middleIndex+1]) {return nums[middleIndex+1];}
					}
				}
				else if(lastNum < middleNum)
				{
					if(middleNum > nums[middleIndex+1]) {return nums[middleIndex+1];}
					else
					{
						firstIndex = middleIndex;
						firstNum = middleNum;
						middleIndex = (middleIndex + lastIndex)/2;
						middleNum = nums[middleIndex];
						if(middleNum < nums[middleIndex-1]) {return nums[middleIndex];}
						if(middleNum > nums[middleIndex+1]) {return nums[middleIndex+1];}
					}
				}
			}
		}
	}
	
	
    }
	
public static void main(String[] args) {
	
	int[] pivotArray = new int[7];
	pivotArray[0] = 4;
	pivotArray[1] = 5;
	pivotArray[2] = 6;
	pivotArray[3] = 7;
	pivotArray[4] = 0;
	pivotArray[5] = 1;
	pivotArray[6] = 2;
	int[] pivotArray2 = new int[3];
	pivotArray2[0] = 3;
	pivotArray2[1] = 1;
	pivotArray2[2] = 2;
	System.out.println(findMin(pivotArray));
	System.out.println(findMin(pivotArray2));
}
}
