


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int[][] dp = new int[n+1][W+1];
         
        for(int[] el : dp) Arrays.fill(el,-1);
         
         return helper(W,wt,val,n,0,0,dp);
         
    } 
    
    static int helper(int W, int wt[] , int val[] , int n , int i , int curr,int[][] dp)  {
        if(i >= n) return 0;
        
        if(dp[i][curr] != -1) return dp[i][curr];
        
        int take  = 0 ;
        if(curr+wt[i] <= W){
            take = val[i] + helper(W,wt,val,n,i+1,curr+wt[i],dp);
        }
        
        int nonTake = helper(W,wt,val,n,i+1,curr,dp);
        
        return dp[i][curr] = Math.max(take,nonTake);
    }
}
