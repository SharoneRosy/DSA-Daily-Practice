//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     public static int helper(int[][] points, int idx, int prev, int[][] dp){
           if(idx < 0) return 0;
           if(prev != -1 && dp[idx][prev] != -1) return dp[idx][prev];
           int maxPoint = 0;
           for(int i = 0; i < 3; i++){
               if(i == prev) continue;
               int currPoint = points[idx][i] + helper(points, idx - 1, i, dp);
               maxPoint = Math.max(maxPoint, currPoint);
           }
           
           if(prev == -1) return maxPoint;
           
           return dp[idx][prev] = maxPoint;
       }
       public static int maximumPoints(int points[][],int N){
           int[][] dp = new int[N + 1][4];
           for(int[] it : dp) Arrays.fill(it, -1);
           return helper(points, N - 1, -1, dp);
       }
}
