//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().threeSumClosest(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int threeSumClosest(int[] array, int target) {
        Arrays.sort(array);
        int n=array.length;
        int ressum=0;
        int mindiff=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i>0 && array[i]==array[i-1]) continue;
            int l=i+1;
            int r=n-1;
            while(l<r){
                int currsum=array[i]+array[l]+array[r];
                int ref=Math.abs(target-currsum);
                if(currsum==target){
                    return target;
                }
                else if(currsum>target){
                    r--;
                }else{
                    l++;
                }
                if(Math.abs(currsum-target)==mindiff){
                    ressum=Math.max(currsum,ressum);
                }
                
                int diff=Math.abs(currsum-target);
                if(diff<mindiff){
                    mindiff=diff;
                    ressum=currsum;
                }
                
            }
            
        }
        return ressum;
    }
}
