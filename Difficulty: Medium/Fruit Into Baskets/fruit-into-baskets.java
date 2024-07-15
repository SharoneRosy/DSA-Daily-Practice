//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {       
        
    int left=0,right=0,maxFruits=0,n=fruits.length;
    HashMap<Integer,Integer>map=new HashMap<>();
    
    while(right<n){
        map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
        if(map.size()>2){
            map.put(fruits[left],map.get(fruits[left])-1);
            if(map.get(fruits[left])==0) {
                map.remove(fruits[left]);
            }
            left++;
        }
        if(map.size()<=2){
            maxFruits=Math.max(maxFruits,right-left+1);
        }
        right++;
    }
    return maxFruits;
    }
}

