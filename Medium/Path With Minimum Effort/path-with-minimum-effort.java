//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends

class Tuple{
    int dis;
    int row;
    int col;
    public Tuple(int dis,int row,int col){
        this.dis=dis;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    
    int MinimumEffort(int heights[][]) {
        PriorityQueue<Tuple>pq=new PriorityQueue<Tuple>((a,b)->a.dis-b.dis);
        int n=heights.length;
        int m=heights[0].length;
        int diff[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                diff[i][j]=(int)(1e9);
            }
        }
        diff[0][0]=0;
        pq.add(new Tuple(0,0,0));
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        while(!pq.isEmpty()){
            Tuple t=pq.poll();
            int d=t.dis;
            int r=t.row;
            int c=t.col;
            if(r==n-1 && c==m-1) return d;
            for(int i=0;i<4;i++){
                int nrow=r+dr[i];
                int ncol=c+dc[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int newEffort=Math.max(Math.abs(heights[nrow][ncol]-heights[r][c]),d);
                    if(newEffort<diff[nrow][ncol]){
                        diff[nrow][ncol]=newEffort;
                        pq.add(new Tuple(newEffort,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}