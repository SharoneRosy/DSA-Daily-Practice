//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void  dfs(int r,int c,int vis[][],int[][] grid,ArrayList<String>vec,int row0,int col0){
        vis[r][c]=1;
        int n=grid.length;
        int m=grid[0].length;
        vec.add((r - row0) + "," + (c - col0));
        int []delRow={-1,0,1,0};
        int []delCol={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=r+delRow[i];
            int ncol=c+delCol[i];
            if(nrow>=0 && nrow<n  && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,vis,grid,vec,row0,col0);
            }
        }
        
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        HashSet<ArrayList<String>>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    ArrayList<String>vec=new ArrayList<>();
                    dfs(i,j,vis,grid,vec,i,j);
                    set.add(vec);
                }
            }
        }
        return set.size();
    }
}
