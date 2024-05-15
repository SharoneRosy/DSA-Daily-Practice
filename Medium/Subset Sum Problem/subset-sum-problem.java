//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static Boolean f(int i,int sum,int arr[],Boolean[][]dp){
        if(sum==0) return true;
        if(i==0) return sum==arr[i];
        if(dp[i][sum]!=null) return dp[i][sum];
        Boolean notpick=f(i-1,sum,arr,dp);
        Boolean pick=false;
        if(sum>=arr[i]){
             pick=f(i-1,sum-arr[i],arr,dp);
        }
        return dp[i][sum]=pick || notpick;
    }

    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        
        Boolean dp[][]=new Boolean[N+1][sum+1];
        for(Boolean it[]:dp) Arrays.fill(it,null);
       
        return f(N-1,sum,arr,dp);
    }
}