import java.util.ArrayList;

public class KeywordList
{
	private ArrayList<Keyword> lst;

	public KeywordList()
	{
		this.lst = new ArrayList<Keyword>();
	}

	public void add(Keyword keyword)
	{
		lst.add(keyword);
	}

	public void find(String s)
	{
		int maxValue = -1;
		Keyword LCS = null;

		for (Keyword k : lst)
		{
			int lcs = findLCS(k.name, s);

			if (lcs > maxValue)
			{
				maxValue = lcs;
				LCS = k;
			}
		}
		System.out.println(s + ": " + LCS.toString());
	}

	// YOUR TURN
	// 1. Implement the LCS algorithm
	// Return the length of lcs
	public int findLCS(String x, String y)
	{

		return 0;
	}

	private void printMatrix(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j] + " ");
				if (j == matrix[0].length - 1)
					System.out.print("\n");
			}
		}
	}
}
