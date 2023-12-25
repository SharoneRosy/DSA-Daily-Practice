//{ Driver Code Starts
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
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                  matrix[i][j] =sc.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.determinantOfMatrix(matrix, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function for finding determinant of matrix.
    static int determinantOfMatrix(int a[][], int n)
    {
        // code here 
        if(n==1) return a[0][0];
        if(n==2) return a[0][0]*a[1][1]-a[0][1]*a[1][0];
        int sign = 1;
        int ans=0;
        for(int i=0;i<n;i++){
            int[][] b = new int[n-1][n-1];
            int I=0,J=0;
            for(int j=1;j<n;j++){
                for(int k=0;k<n;k++){
                    if(k==i) continue;
                    b[I][J]=a[j][k];
                    J++;
                }
                I++;
                J=0;
            }
                // for(int[] x:b) System.out.println(Arrays.toString(x));
                // System.out.println();
                ans+= sign * a[0][i] * determinantOfMatrix(b,n-1);
                sign*=-1;
        }
        return ans;
    }
}

