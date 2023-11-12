//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    static int conv(int a,int b,char c){
        if(c=='+'){
            return a+b;
        }
        else if( c=='-'){
            return a-b;
        }
        else if(c=='*'){
            return a*b;
        }
        else{
            return a/b;
        }
    }
    public static int evaluatePostFix(String S){
        Deque<Integer> st=new ArrayDeque<>();
        st.push((int)S.charAt(0)-48);
        for(int i=1;i<S.length();i++){
            char x=S.charAt(i);
            if(x=='*'||x=='/'||x=='+'||x=='-'){
                int a=st.pop();
                int b=st.pop();
                int res=conv(b,a,x);
                st.push(res);
            }
            else{
                st.push((int)x-48);
            }
        }
        return st.peek();
    }
}
