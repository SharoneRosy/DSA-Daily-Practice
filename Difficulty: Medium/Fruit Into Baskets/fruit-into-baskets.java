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

    int left = 0;int right=0;int maxLen =0;
    Map<Integer,Integer> mpp = new HashMap<>();
    
    while(right<N){
        //putting the incoming elements into map if it is  already in the map we just update the value by 1
        mpp.put(fruits[right],mpp.getOrDefault(fruits[right],0)+1);
        
        //if the size of Map is greater then number of baskets then we move our window till its decreases
        if(mpp.size()>2){


            //as we moving the window to the right reduce the frequency of the fruit which is out of the windown now
            mpp.put(fruits[left],mpp.get(fruits[left])-1);


            //if any fruits frequency is zero we simply remove it
            if(mpp.get(fruits[left])==0){
                mpp.remove(fruits[left]);
            }
            left++;
        }


        //if the map size is equal or less then number of baskets then we store maxLength of the windown
        if(mpp.size() <=2){
            maxLen = Math.max(maxLen,right-left+1);
        }
        
        right++;
    }
    return maxLen;
    }
}

