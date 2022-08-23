


public class SearchInSortedMatrix {
	public static int[] searchInSortedMatrix(int[][] matrix, int target) {
    int n, m;
    n=matrix.length;
    m=matrix[0].length;
    if (target < matrix[0][0] || target > matrix[n-1][m-1]) {
    	return new int[] {-1,-1};
    } else if (m==1) {
    	for (int i=0;i<n;i++) {
    		if (matrix[i][0] == target) {
    			return new int[] {i, 0};
    		}
    	};
    	return new int[] {-1, -1};
    };
    int i=0;
    int j=0;
    while (i<n && j<m-1 && i>=0 && j>=0) {
    	System.out.println(i+", "+j);
    	if (matrix[i][j]==target) {
    		return new int[] {i, j};
    	} else if (matrix[i][j+1]==target) {
    		return new int[] {i, j+1};
    	} else if (target>matrix[i][j] && target<matrix[i][j+1] ||
    			target>matrix[i][j+1] && j==m-2) {
    		i++;
    	} else if (target>matrix[i][j+1] && j<m-1) {
    		j++;
    	} else if (target<matrix[i][j] && j>0) {
    		j--;
    	} else if (target<matrix[i][j] && j==0) {
    		return new int[] {-1, -1};
    	}
    };
    return new int[] {-1, -1};
  }

	public static void main(String[] args) {
		int[][] matrix = {
		  {1, 4, 7, 12, 15, 1000},
		  {2, 5, 19, 31, 32, 1001},
		  {3, 8, 24, 33, 35, 1002},
		  {40, 41, 42, 44, 45, 1003},
		  {99, 100, 103, 106, 128, 1004}
		};

		int[] result = searchInSortedMatrix(matrix, 98);

		System.out.println("Result: "+result[0]+", "+result[1]);
	}
}