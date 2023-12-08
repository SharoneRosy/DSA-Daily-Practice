//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int N, int M, String X, String Y)
    {
        int[][] dp = new int[N+1][M+1];
        
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return count(N , M , X, Y, dp);
    }
    
     static int count(int n, int m, String X, String Y, int[][] dp) {
         
        if (n == 0 || m == 0)
            return 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        if (X.charAt(n-1) == Y.charAt(m-1))
            return dp[n][m] = 1 + count(n - 1, m - 1, X, Y, dp);

        int excludeX = count(n - 1, m, X, Y, dp);
        int excludeY = count(n, m - 1, X, Y, dp);

        return dp[n][m] = Math.max(excludeX, excludeY);
    }

    
}