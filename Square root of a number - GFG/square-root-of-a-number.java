//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here
		long l=1,h=x/2;
		long ans=0;
		if(x==0 || x==1){
		    return x;
		}
		while(l<=h){
		    long mid=(l+h)/2;
		    if(mid*mid==x){
		        return mid;
		    }else if(mid*mid>x){
		        h=mid-1;
		    }else{
		        l=mid+1;
		        ans=mid;
		    }
		}
		return ans;
	 }
}
