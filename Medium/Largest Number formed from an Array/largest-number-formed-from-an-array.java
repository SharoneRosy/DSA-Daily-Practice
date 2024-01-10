//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String printLargest(String[] arr) {
        // code here
   Arrays.sort(arr,new Comparator<String>(){
       @Override
       public int compare(String a, String b){
           String ab= a+b;
           String ba=b+a;
           return ba.compareTo(ab);
       }
   });
        String h="";
        for(int i=0;i<arr.length;i++){
            h+=arr[i];
        }
        return h;
    }
}

