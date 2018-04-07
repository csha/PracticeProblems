import java.util.ArrayList;
import java.util.List;

public class spiralArrayPrint {

public static List<Integer> spiralOrder(int[][] matrix) {
     /*
      * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
      * */   
	
	
	List<Integer> returnList = new ArrayList<Integer>();
	if(matrix.length <= 0) {return returnList;}
	
	int rowTop = 0;
	int columnLeftMost = 0;
	int rowBot = matrix.length-1;
	int columnRightMost = matrix[0].length-1;
	int matrixSize = (rowBot+1) * (columnRightMost+1);
	//Stops when pritns only 1 num twice.
	while(true)
	{
		for(int i  = columnLeftMost; i <= columnRightMost; i++)
		{
			returnList.add(matrix[rowTop][i]);
			
		} 
		if(returnList.size() == matrixSize) {break;}
		rowTop++;
		
		for(int i = rowTop; i <= rowBot; i++)
		{
			returnList.add(matrix[i][columnRightMost]);
			
		}
		if(returnList.size() == matrixSize) {break;}
		columnRightMost--;
		
		for(int i = columnRightMost; i >= columnLeftMost; i-- )
		{
			returnList.add(matrix[rowBot][i]);
		}
		if(returnList.size() == matrixSize) {break;}
		rowBot--;
		
		for(int i = rowBot; i >= rowTop; i--)
		{
			returnList.add(matrix[i][columnLeftMost]);
		}
		if(returnList.size() == matrixSize) {break;}
		columnLeftMost++;
		
		
	}
	
	
	return returnList;
	
    }

public static void main(String[] args) {
	int[][] spiralArray = new int[3][3];
	spiralArray[0][0] = 0;
	spiralArray[0][1] = 1;
	spiralArray[0][2] = 2;
	spiralArray[1][2] = 3;
	spiralArray[2][2] = 4;
	spiralArray[2][1] = 5;
	spiralArray[2][0] = 6;
	spiralArray[1][0] = 7;
	spiralArray[1][1] = 8;
	List<Integer> returnList = spiralOrder(spiralArray);
	for(int e : returnList)
	{System.out.println(e);}
}
	
}
