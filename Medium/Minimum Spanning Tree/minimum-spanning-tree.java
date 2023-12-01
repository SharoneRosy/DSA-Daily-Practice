//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int spanningTree(int V, int E, int edges[][]){
        int grid[][]=new int[V][V];
        for(int i=0;i<edges.length;i++){
            int row=edges[i][0];
            int col=edges[i][1];
            int weight=edges[i][2];
            grid[row][col]=weight;
            grid[col][row]=weight;
        }
        return Helper(grid,V);
    }
    
    static int Helper(int grid[][],int V){
        boolean mset[]=new boolean[V];
        int[] key=new int[V];
        int res=0;
        for(int i=0;i<V;i++){
            key[i]=Integer.MAX_VALUE;
        }
        key[0]=0;
        for(int count=0;count<V;count++){
            int u=-1;
            for(int i=0;i<V;i++){
                if(mset[i]==false &&(u==-1 || key[u]>key[i])){
                    u=i;
                }
            }
            mset[u]=true;
            res+=key[u];
            for(int i=0;i<V;i++){
                if(grid[u][i]!=0 && mset[i]==false && grid[u][i]<key[i]){
                    key[i]=grid[u][i];
                }
            }
        }
        return res;
    }
}


