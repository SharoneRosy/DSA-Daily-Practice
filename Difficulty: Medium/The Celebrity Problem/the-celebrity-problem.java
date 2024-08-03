//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
       int n=mat.length;
        int m=mat[0].length;
          int idx = -1;
          int cnt1 = 0;
          int cnt2 = 0;
        for(int i=0 ; i<n ; i++){
            for (int j=0 ; j<m ; j++){
                    cnt1+=mat[i][j];
                    cnt2+=mat[j][i];
            }
            if (cnt1 == 0 && cnt2==n-1){
                idx = i;
            }
            cnt1=0;
            cnt2=0;
        }
        return idx;
    }

}