//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis)==true) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(int node,ArrayList<ArrayList<Integer>>adj,int[] vis){
        vis[node]=1;
        for(int adjnode:adj.get(node)){
            if(vis[adjnode]==0){
                if(dfs(adjnode,adj,vis)==true) return true;
            }else if(vis[adjnode]==1) return true;
        }
        vis[node]=2;
        return false;
    }
}