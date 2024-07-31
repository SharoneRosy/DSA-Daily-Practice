//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> result = new ArrayList<>();
        
        if(mat == null || mat.length == 0 || mat[0][0] == 0){
            return result;
        }
        
        int n = mat.length;
        boolean[][] visited = new boolean[n][n];
        StringBuilder path = new StringBuilder();
        
        //start the dfs from mat[0][0]
        dfs(mat, 0, 0, visited, path, result);
        
        Collections.sort(result);
        return result;
    }
    
    private static void dfs(int[][] mat, int row, int col, boolean[][] visited, StringBuilder path, ArrayList<String> result){
        int n = mat.length;
        
        if(row == n - 1 && col == n - 1){
            result.add(path.toString());
            return;
        }
        
        visited[row][col] = true;
        
        if(isSafe(mat, row + 1, col, visited)){
            path.append('D');
            dfs(mat, row + 1, col, visited, path, result);
            path.deleteCharAt(path.length() - 1); //Bactrack
        }
        
        if(isSafe(mat, row - 1, col, visited)){
            path.append('U');
            dfs(mat, row - 1, col, visited, path, result);
            path.deleteCharAt(path.length() - 1); //Bactrack
        }
        
        if(isSafe(mat, row, col + 1, visited)){
            path.append('R');
            dfs(mat, row, col + 1, visited, path, result);
            path.deleteCharAt(path.length() - 1); //Bactrack
        }
        
         if(isSafe(mat, row, col - 1, visited)){
             path.append('L');
             dfs(mat, row, col - 1, visited, path, result);
             path.deleteCharAt(path.length() - 1); //Bactrack
         }
         
         visited[row][col] = false;
    }
    private static boolean isSafe(int[][] mat, int row, int col, boolean[][] visited){
        int n = mat.length;
        
        return (row >= 0 && row < n && col >= 0 && col < n && mat[row][col] == 1 && !visited[row][col]);
    }
}

