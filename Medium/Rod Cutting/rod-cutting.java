//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int f(int i,int n,int[] price,int dp[][]){
        if(i==0) return price[0]*n;
        if(dp[i][n]!=-1) return dp[i][n];
        int notpick=0+f(i-1,n,price,dp);
        int pick=(int)(-1e9);
        if(i+1<=n) pick=price[i]+f(i,n-(i+1),price,dp);
        return dp[i][n]=Math.max(pick,notpick);
    }
    public int cutRod(int price[], int n) {
        //code here
        int dp[][]=new int[n+1][n+1];
        for(int []it:dp) Arrays.fill(it,-1);
        return f(n-1,n,price,dp);
    }
}