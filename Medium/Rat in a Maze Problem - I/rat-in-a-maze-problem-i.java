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
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix

class Solution {
    public static void Solve(int i,int j,int n,String moves,ArrayList<String> l,int m[][],int maze[][]){
       if(i == n - 1 && j == n - 1){
           l.add(moves);
           return;
       }
       //down
       if(i + 1 < n && maze[i+1][j] == 0 && m[i+1][j] == 1){
           maze[i][j] = 1;
           Solve(i+1,j,n,moves+'D',l,m,maze);
           maze[i][j] = 0;
       }
       //left
       if(j - 1 >= 0 && maze[i][j-1] == 0 && m[i][j-1] == 1){
            maze[i][j] = 1;
            Solve(i,j-1,n,moves+'L',l,m,maze);
            maze[i][j] = 0;
       }
       //right
       if(j + 1 < n && maze[i][j+1] == 0 && m[i][j+1] == 1){
            maze[i][j] = 1;
            Solve(i,j+1,n,moves+'R',l,m,maze);
            maze[i][j] = 0;
       }
       //up
       if(i - 1 >= 0 && maze[i-1][j] == 0 && m[i-1][j] == 1){
            maze[i][j] = 1;
            Solve(i-1,j,n,moves+'U',l,m,maze);
            maze[i][j] = 0;
       }
       
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> l = new ArrayList<>();
        int maze[][] = new int[n][n];
        if(m[0][0] == 1){
            Solve(0,0,n,"",l,m,maze);
        }
        return l;
    }}

