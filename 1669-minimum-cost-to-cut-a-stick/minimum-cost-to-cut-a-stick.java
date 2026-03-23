class Solution {
    int dp[][];
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int c=cuts.length;
        int arr[]=new int[c+2];
        dp=new int[c+2][c+2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        arr[0]=0;
        arr[c+1]=n;
        for(int i=0;i<c;i++){
            arr[i+1]=cuts[i];
        }
        return solve(arr,0,c+1);

    }
    int solve(int arr[],int i,int j){
        if(j-i<=1)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];

        int mincost=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int cost=arr[j]-arr[i]+solve(arr,i,k)+solve(arr,k,j);
            mincost=Math.min(mincost,cost);
        }
        dp[i][j]=mincost;
        return dp[i][j];
    }
}