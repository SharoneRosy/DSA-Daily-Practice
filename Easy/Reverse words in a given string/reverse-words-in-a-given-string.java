//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
    Stack<String> st=new Stack<>();
    String temp="";
    String str=S;
    for(int i=0;i<str.length();i++){
        if(str.charAt(i)=='.'){
            st.push(temp);
            st.push(".");
            temp="";
        }else{
            temp=temp+str.charAt(i);
        }
    }st.push(temp);
    String ans="";
    for(int i=st.size()-1;i>=0;i--){
        ans+=st.get(i);
    }
       return ans; 
    }
}