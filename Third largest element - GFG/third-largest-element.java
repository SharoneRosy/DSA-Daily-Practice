//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class ThirdLargestElement
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n =sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			Solution g = new Solution();
			System.out.println(g.thirdLargest(arr,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int thirdLargest(int a[], int n)
    {
        if(n<3){
            return -1;
        }
        
        int m1=0;
        int m2=-1;
        int m3=-2;
        for (int i=0;i<n;i++){
            if(a[i]>m1){
                m3=m2;
                m2=m1;
                m1=a[i];
            }
            else if(a[i]>m2 && a[i]<m1){
                m3=m2;
                m2=a[i];
            }else if(a[i]>m3 && a[i]<m2){
                m3=a[i];
            }
        }return m3;
    }
}
