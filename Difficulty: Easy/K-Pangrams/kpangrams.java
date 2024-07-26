//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String s, int k) {
        // code here
        s.trim();
        int n=s.length();
        if(n<26) return false;
        int[] ch=new int[26];
        for(char c:s.toCharArray()){
            if(c>='a' && c<='z'){
                 ch[c-'a']++;
            }
           
        }
        int swappable=0;
        int missingcount=0;
        for(int i=0;i<26;i++){
            if(ch[i]==0){
                missingcount++;
            }else{
                swappable+=ch[i]-1;
            }
        }
        return k>=missingcount && swappable >=missingcount;
    }
}