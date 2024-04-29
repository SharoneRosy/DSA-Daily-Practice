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
    public static void dfs(ArrayList<ArrayList<Integer>>adj,int[] vis,Stack<Integer>st,int curr){
        if(vis[curr]==1) return ;
        vis[curr]=1;
        for(Integer it:adj.get(curr)){
            dfs(adj,vis,st,it);
        }
        st.add(curr);
        
    }
     public static void dfs2(ArrayList<ArrayList<Integer>>adjT,int[] vis,int curr){
        if(vis[curr]==1) return ;
        vis[curr]=1;
        for(Integer it:adjT.get(curr)){
            dfs2(adjT,vis,it);
        }
       
        
    }
    
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer>st=new Stack<>();
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(adj,vis,st,i);
            }
        }
        ArrayList<ArrayList<Integer>>adjT=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjT.add(new ArrayList<>());
        }
        for(int i=0;i<adj.size();i++){
            for(Integer it:adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        Arrays.fill(vis,0);
        int scc=0;
        while(!st.isEmpty()){
            int val=st.pop();
            if(vis[val]==0){
                dfs2(adjT,vis,val);
                scc++;
            }
        }
        return scc;
    }
}
