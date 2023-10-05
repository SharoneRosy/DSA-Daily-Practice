//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {   
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            for(int i = 0;i<n;i++){
                A[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.lcmOfArray(n,A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long gcd(long a, long b)
    {
        if (b==0)
        {
            return a;
        }else{
            return gcd(b,a%b);
        }
    }
    static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
    static long lcmOfArray(int N, int A[]){
        long z=1L;
        for (int i =0; i<N; i++){
            z=lcm(z,A[i])%1000000007;
        }return z;
    }
}
