//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class Pair{
    int node,dis;
    Pair(int node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
class Tuple{
    int node,dis,k;
    Tuple(int node,int dis,int k){
        this.node=node;
        this.dis=dis;
        this.k=k;
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Queue<Tuple>q=new LinkedList<>();
        q.add(new Tuple(src,0,0));
        dis[src]=0;
        while(!q.isEmpty()){
            Tuple t=q.poll();
            if(t.k>k) continue;
            for(Pair p:adj.get(t.node)){
                if(p.dis+t.dis<dis[p.node] && t.k<=k){
                    dis[p.node]=p.dis+t.dis;
                    q.add(new Tuple(p.node,dis[p.node],t.k+1));
                }
            }
        }
        if(dis[dst]==Integer.MAX_VALUE) return -1;
        return dis[dst];
    }
}