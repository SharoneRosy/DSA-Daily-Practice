//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
     
        int [][]pos=new int[n][2];
        for(int i=0;i<n;i++){
            pos[i][0]=start[i];
            pos[i][1]=end[i];
        }
        
        Arrays.sort(pos,(a,b)->a[1]-b[1]);
        int ans=1;
        int prevendtime=pos[0][1];
        for(int i=1;i<n;i++){
            if(pos[i][0]>prevendtime){
                ans++;
                prevendtime=pos[i][1];
            }
        }
        return ans;
    }
}
