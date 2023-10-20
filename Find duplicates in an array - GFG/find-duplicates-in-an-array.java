//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        
        HashSet<Integer> d=new HashSet<>();
        HashSet<Integer> set=new HashSet<>();
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            if (set.add(arr[i])==false){
                d.add(arr[i]);
            }
        }
        l.addAll(d);
        if(l.isEmpty()){
            l.add(-1);
        }
        Collections.sort(l);
        return l;
    }
}
