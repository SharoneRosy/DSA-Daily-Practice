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
            int N=sc.nextInt();
			
            Solution ob = new Solution();
            ArrayList<Integer> primes  = ob.sieveOfEratosthenes(N);
            for(int prime : primes) {
                System.out.print(prime+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> sieveOfEratosthenes(int n){
        // code here
        ArrayList<Integer> res = new ArrayList<Integer>();
    
    	boolean isPrime[]=new boolean[n+1];
    	Arrays.fill(isPrime,true);
    	for(int i=2;i<n+1;i++){
    	    if(isPrime[i])
    	    {
    	        res.add(i);
    	        for(int j=i*i;j<n+1;j=i+j){
    	            isPrime[j]=false;
    	        }
    	    }
    	}
    	return res;

    }
}