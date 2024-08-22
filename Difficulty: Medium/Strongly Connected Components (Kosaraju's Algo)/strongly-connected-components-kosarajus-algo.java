//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    
    public void TopoSort(int node,ArrayList<ArrayList<Integer>>adj,boolean []vis,Stack<Integer>st){
        vis[node]=true;
        for(int adjnode:adj.get(node)){
            if(!vis[adjnode]){
                TopoSort(adjnode,adj,vis,st);
            }
        }
        st.add(node);
    }
    
    public void dfs(int node,ArrayList<ArrayList<Integer>>adj2,boolean []vis){
        vis[node]=true;
        for(int adjnode:adj2.get(node)){
            if(!vis[adjnode]){
                dfs(adjnode,adj2,vis);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer>st=new Stack<>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                TopoSort(i,adj,vis,st);
            }
        }
        
        ArrayList<ArrayList<Integer>>adj2=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj2.add(new ArrayList<>());
        }
        
        for(int i=0;i<V;i++){
            for(int v:adj.get(i)){
                adj2.get(v).add(i);
            }
        }
        
        Arrays.fill(vis,false);
        int cnt=0;
        while(!st.isEmpty()){
            int node=st.pop();
            if(!vis[node]){
                dfs(node,adj2,vis);
                cnt++;
            }
        }
        return cnt;
    }
}
