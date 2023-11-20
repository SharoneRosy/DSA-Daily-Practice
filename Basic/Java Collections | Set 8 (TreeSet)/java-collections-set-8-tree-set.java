//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            TreeSet<String>ts=new TreeSet<>();
            int n=sc.nextInt();;
            for(int i=0;i<n;i++)
            {
                String s=sc.next();
                ts.add(s);
            }
            char a=sc.next().charAt(0);
            char b=sc.next().charAt(0);
            char c=sc.next().charAt(0);
            char d=sc.next().charAt(0);
            gfg1 obj=new gfg1();
            obj.task(ts,a,b,c,d);
        }
    }
}


// } Driver Code Ends
//User function Template for Java

class gfg1
{
    void task(TreeSet<String> ts,char a,char b,char c,char d)
    {
        // Add your code here. Print the output here itself.
        TreeSet<String>ts1=new TreeSet<>();
        TreeSet<String>ts2=new TreeSet<>();
        TreeSet<String>ts3=new TreeSet<>();
        java.util.Iterator<String>it=ts.iterator();
        while(it.hasNext()){
            String str=it.next().toString();
            char cc=str.charAt(0);
            if(cc<a){
                ts1.add(str);
            }if(cc>=b){
                ts2.add(str);
            }
            if(cc>=c && cc<d){
                ts3.add(str);
            }
        }System.out.println(ts1);
        System.out.println(ts2);
        System.out.println(ts3);


    }
}

//{ Driver Code Starts.

// } Driver Code Ends