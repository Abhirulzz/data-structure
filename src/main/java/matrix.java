
public class matrix {

	// Java Code For A Boolean Matrix Question 
		public static void modifyMatrix(int mat[ ][ ], int R, int C) 
		{ 
			int row[ ]= new int [R]; 
			int col[ ]= new int [C]; 
			int i, j; 
		
			/* Initialize all values of row[] as 0 */
		/*	for (i = 0; i < R; i++) 
			{ 
			row[i] = 0; 
			} 
		
		
			// Initialize all values of col[] as 0 
			for (i = 0; i < C; i++) 
			{ 
			col[i] = 0; 
			} 
			System.out.println("zero"); 
			printMatrix(mat, 3, 4);*/
		
			// Store the rows and columns to be marked as 
			//1 in row[] and col[] arrays respectively 
			for (i = 0; i < R; i++) 
			{ 
				for (j = 0; j < C; j++) 
				{ 
					if (mat[i][j] == 1) 
					{ 
						row[i] = 1; 
						col[j] = 1; 
					} 
				} 
			} 
			System.out.println("one"); 
			printMatrix(mat, 3, 4); 
			
			
			/* Modify the input matrix mat[] using the 
			above constructed row[] and col[] arrays */
			for (i = 0; i < R; i++) 
			{ 
				for (j = 0; j < C; j++) 
				{ 
					if ( row[i] == 1 || col[j] == 1 ) 
					{ 
						mat[i][j] = 1; 
					} 
				} 
				System.out.println("Matrix after crack n"); 
				printMatrix(mat, 3, 4);
				System.out.println("Matrix after crack n"); 
			} 
			
		} 
		
		/* A utility function to print a 2D matrix */
		public static void printMatrix(int mat[ ][ ], int R, int C) 
		{ 
			int i, j; 
			for (i = 0; i < R; i++) 
			{ 
				for (j = 0; j < C; j++) 
				{ 
					System.out.print(mat[i][j]+ " "); 
				} 
				System.out.println(); 
			} 
		} 
		
	public static void setZeros(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}
		printMatrix(matrix, 3, 4);

		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if ((row[i] == 1 || column[j] == 1)) {
					matrix[i][j] = 1;
				}
			}
			//printMatrix(matrix, 3, 4);
		}
	}
	
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; ++i) {
				int offset = i - first;
				int top = matrix[first][i]; // save top
				// left -> top
				matrix[first][i] = matrix[last - offset][first];

				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];

				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];

				// top -> right
				matrix[i][last] = top; // right <- saved top
			}
		}
	}                                                       
                                                        
		/* Driver program to test above functions */
		public static void main(String[] args) 
		{ 
			int mat[ ][ ] = { {1, 0, 0, 1}, 
							{0, 0, 1, 0}, 
							{0, 0, 0, 1},
							{0, 0, 0, 1},}; 
						
					System.out.println("Matrix Intially"); 
					
					printMatrix(mat, 4, 4); 
				
					//modifyMatrix(mat, 3, 4); 
					System.out.println("Matrix after modification n"); 
					//printMatrix(mat, 3, 4);
					//setZeros(mat); 
					System.out.println("Matrix after crack n"); 
					printMatrix(mat, 4, 4);
					rotate(mat,4); 
					System.out.println("Matrix after rotate n"); 
					printMatrix(mat, 4, 4);
				
		} 

	} 

	// This code is contributed by Kamal Rawal 


