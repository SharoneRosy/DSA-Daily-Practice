//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] a, int n)
           {
                  int c=0;
                  for(int i=0;i<n;i++){
                      int rev=0;
                      int t=a[i];
                      while(t>0){
                          rev=rev*10+t%10;
                          t=t/10;
                      }if( a[i]==rev){
                          c++;
                      }
                  }
                  if(c==n)return 1;
                  else return 0;
           }
}