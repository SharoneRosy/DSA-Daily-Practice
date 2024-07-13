//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        PriorityQueue<Item> pq = new PriorityQueue<>(new ItemComparator());
        
        // Insert first element of all array
        for (int i = 0; i < K; i++) {
            Item item = new Item(arr[i][0], i, 0);
            pq.add(item);
        }
        
        while (!pq.isEmpty()) {
            Item root = pq.remove();
            
            ans.add(root.data);
            
            int row = root.row;
            int col = root.col;
            
            if (col + 1 < arr[row].length) {
                Item item = new Item(arr[row][col + 1], row, col + 1);
                pq.add(item);
            }
        }
        
        return ans;
        
    }
    
    private static class ItemComparator implements Comparator<Item> {
        
        public int compare(Item i1, Item i2) {
            if (i1.data < i2.data) return -1;
            if (i1.data > i2.data) return 1;
            
            return 0;
        }
    }
    
    private static class Item {
        
        int data = 0;
        int row = 0;
        int col = 0;
        
        Item(int data, int row, int col) {
            this.data = data;
            this.row = row;
            this.col = col;
        }
    }
}
