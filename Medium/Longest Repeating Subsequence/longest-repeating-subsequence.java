//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{public int LongestRepeatingSubsequence(String str1)
    {
        // code here
        String str2 = new String(str1);
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        return lrsUtil(str1,str2,n,m,dp);
    }
    public int lrsUtil(String str1,String str2,int n,int m,int[][] dp){
        if(n==0||m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(str1.charAt(n-1)==str2.charAt(m-1)&&n!=m){
            return dp[n][m] = 1 + lrsUtil(str1,str2,n-1,m-1,dp);
        }else{
            return dp[n][m] = Math.max(lrsUtil(str1,str2,n-1,m,dp),lrsUtil(str1,str2,n,m-1,dp));
        }
    }
}