//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumPalindrome(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{
    static long isSumPalindrome(long n)
    {
        if(n == reverseNum(n)) return n;
        
        for(int i=0; i<5; i++)
        {
            n += reverseNum(n);
            if(n == reverseNum(n)) return n;
        }
        
        return -1;
    }
    
    static long reverseNum(long num)
    {
        long revNum = 0;
        while(num > 0)
        {
            revNum = revNum*10 + num%10;
            num/=10;
        }
        return revNum;
    }
}