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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

 class Pair{
        int dis;
        int row;
        int col;
        public Pair(int dis,int row,int col){
            this.dis=dis;
            this.row=row;
            this.col=col;
        }
    }
class Solution {
    

    int shortestPath(int[][] grid, int[] s, int[] d) {

        // Your code here
        if(s[0]==d[0] && s[1]==d[1]) return 0;
        Queue<Pair>q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int dis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j]=(int)(1e9);
            }
        }
        dis[s[0]][s[1]]=0;
        q.add(new Pair(0,s[0],s[1]));
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.poll();
            int dist=p.dis;
            int r=p.row;
            int c=p.col;
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && dist+1<dis[nrow][ncol]){
                    dis[nrow][ncol]=dist+1;
                    if(nrow==d[0] && ncol==d[1]) return dist+1;
                    q.add(new Pair(dist+1,nrow,ncol));
                    
                }
            }
            
        }
        return -1;
    }
}
