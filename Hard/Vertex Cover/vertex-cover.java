//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int getMin(int n, int m, int[][] edges, int idx, HashSet<Integer> st){
        if(idx >= m)
            return 0;
        int v1 = edges[idx][0];
        int v2 = edges[idx][1];
        
        if(!st.contains(v1) && !st.contains(v2)){
            st.add(v1);
            int first = 1 + getMin(n, m, edges, idx+1, st);
            st.remove(v1);
            
            st.add(v2);
            int second = 1 + getMin(n, m, edges, idx+1, st);
            st.remove(v2);
            
            return Math.min(first, second);
        }
        
        return getMin(n, m, edges, idx+1, st);
    }
    public static int vertexCover(int n, int m, int[][] edges) {
       
        HashSet<Integer> st = new HashSet<>();
        return getMin(n, m, edges, 0, st);
    }
}
