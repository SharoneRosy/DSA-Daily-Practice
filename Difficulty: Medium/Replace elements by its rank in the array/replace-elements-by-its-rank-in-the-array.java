//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans[] = obj.replaceWithRank(a,n);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
    HashMap<Integer,Integer> map = new HashMap<>();
    PriorityQueue<int[]> minheap = new PriorityQueue<>(
        (a,b) -> Integer.compare(a[1],b[1])
    );
    for(int i=0;i<N;i++){
        minheap.offer(new int[]{i,arr[i]});
    }
    int[] res = new int[N];
    int rank = 1;
    while(!minheap.isEmpty()){
        int[] temp = minheap.poll();
        int idx = temp[0];
        int val = temp[1];
        if(!map.containsKey(val)){
            map.put(val,rank);
            res[idx] = map.get(val);
            rank++;
        }
        else{
            res[idx] = map.get(val);
        }
    }
    return res;
  }
}

  