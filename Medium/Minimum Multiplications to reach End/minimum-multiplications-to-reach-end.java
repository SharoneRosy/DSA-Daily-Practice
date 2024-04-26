//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int node;
    int count;
    Pair(int node,int count){
        this.node=node;
        this.count=count;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if(start==end) return 0;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(start,0));
        int [] dist=new int[100000];
        Arrays.fill(dist,(int)1e9);
        dist[start]=0;
        int mod=100000;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int node=p.node;
            int count=p.count;
            for(int it:arr){
                int num=(node*it)%mod;
                if(count+1<dist[num]){
                    dist[num]=count+1;
                if(num==end)  return count+1;
                q.add(new Pair(num,count+1));
                }
            }
        }
        return -1;
    }
}
