//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        // Write your code here
        
        String [] arr=str.split("\\.");
        if(arr.length!=4){
            return false;
        }
        
        for(int i=0;i<arr.length;i++){
            int l=arr[i].length();
            if(l>1 && arr[i].charAt(0)=='0'){
                return false;
            }
            
            if(arr[i].isEmpty() || arr[i].length()>3 || Integer.parseInt(arr[i])<0  || Integer.parseInt(arr[i])>255){
                return false;
            }
         }
         return true;
    }
}