//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static String sum(String s1 , String s2){
        int i = s1.length()-1;
        int j = s2.length()-1;
        StringBuilder sb = new StringBuilder("");
        int carry =0;
        while(i >= 0 || j >= 0 || carry != 0){
            int sum = carry;
            if(i >= 0)sum += s1.charAt(i--)-'0';
            if(j >= 0)sum += s2.charAt(j--)-'0';
            sb.append(sum%10);
            carry = sum/10;
        }
        sb.reverse();
        return sb+"";
    }
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node head1, Node head2){
        // code here
        // return head of sum list
        Node temp = head1;
        String s1 = "";
        while(temp != null){
            s1 += temp.data;
            temp = temp.next;
        }
        Node temp2 = head2;
        String s2 = "";
        while(temp2 != null){
            s2 += temp2.data;
            temp2 = temp2.next;
        }
        String res1 = sum(s1,s2);
        Node res = new Node(100);
        Node ans = res;
        for(int i =0 ; i < res1.length() ; i++){
            char ch = res1.charAt(i);
            Node temp1 = new Node(Integer.parseInt(ch+""));
            res.next = temp1;
            res = temp1;
        }
        return ans.next;
    }
}
