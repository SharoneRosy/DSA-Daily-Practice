//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        if(s>9*d) return "-1";
        
        int [] digits=new int[d];
        s--;
        for(int i=d-1;i>0;i--){
            if(s>9){
                digits[i]=9;
                s-=9;
            }else{
                digits[i]=s;
                s=0;
            }
        }
        digits[0]=s+1;
        
        StringBuilder res=new StringBuilder();
        for(int i:digits){
            res.append(i);
        }
        
        return res.toString();
    }
}
