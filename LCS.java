package GettingReadyForAmdocs;

public class LCS {

	public static void main(String[] args) {
		String shorterWord = "aeg";
		String longerWord = "abeg";
		System.out.println(lcs(shorterWord,longerWord));
	}
	
	public static String lcs(String shorterWord,String longerWord) {
		int mat[][] = buildMatrix(shorterWord,longerWord);
		int i=mat.length-1; //shorter
		int j=mat[0].length-1; // longer
		String str="";
		int count = mat[i-1][j-1];
		while (count>=0)
		{
			if (shorterWord.charAt(i-1)==longerWord.charAt(j-1))
			{
				str = shorterWord.charAt(i-1) + str;
				i--;
				j--;
				count--;
			}
			else if (mat[i][j]==mat[i][j-1])
				j--;
			else
				i--;
		}
		return str;
	}

	private static int[][] buildMatrix(String shorterWord, String longerWord) {
		int row=shorterWord.length()+1;
		int col=longerWord.length()+1;
		int arr[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			arr[i][0]=0;			
		}
		for (int i = 0; i < col; i++) {
			arr[0][i]=0;
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (shorterWord.charAt(i-1)==longerWord.charAt(j-1))
					arr[i][j]=arr[i-1][j-1]+1;
				else
					arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
			}
		}
		return arr;
	}
}
