//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isDigitSumPalindrome(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isDigitSumPalindrome(int N) {
        int sum=0;
        while(N>0){
            int ld=N%10;
            sum+=ld;
            N=N/10;
        }
        int s=sum;
        int rev=0;
        while(s>0){
            int ld=s%10;
            rev=rev*10+ld;
            s=s/10;
        }
        
        if (sum==rev)
           return 1;
        return 0;
    }// code here
       
}