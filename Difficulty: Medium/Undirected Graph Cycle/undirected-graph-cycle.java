//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    class Pair{
        int node;
        int par;
        public Pair(int node,int par){
            this.node=node;
            this.par=par;
        }
    }
    // Function to detect cycle in an undirected graph.
    
    public boolean bfs(int source,int V,boolean []vis,ArrayList<ArrayList<Integer>>adj){
  
        Queue<Pair>q=new LinkedList<>();
        vis[0]=true;
        q.add(new Pair(source,-1));
        while(!q.isEmpty()){
            int childnode=q.peek().node;
            int parentnode=q.peek().par;
            q.remove();
            for(int nei:adj.get(childnode)){
                if(!vis[nei]){
                    vis[nei]=true;
                    q.add(new Pair(nei,childnode));
                }else  if(nei!=parentnode){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V];
        Arrays.fill(vis,false);
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                vis[i]=true;
                if(bfs(i,V,vis,adj)) return true;
            }
        }
        return false;
    }
}