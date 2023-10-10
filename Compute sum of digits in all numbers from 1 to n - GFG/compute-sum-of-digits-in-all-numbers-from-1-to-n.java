//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static int sumOfDigits(int N){
        //code here
        
        int [] dp= new int[N+1];
        dp[0]=0;
        for (int i =1;i<=N; i++){
            if(i<=9){
                dp[i]=dp[i-1]+i;
            }else{
                int j=i;
                while(j>0){
                    dp[i]+=j%10;
                    j=j/10;
                }
                dp[i]=dp[i-1]+dp[i];
            }
        }return dp[N];
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
           
            Solution ob = new Solution();
            System.out.println(ob.sumOfDigits(N));
        }
    }
}
// } Driver Code Ends