class Solution {
    int dp[][],precom[][];
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        dp=new int[n][n];
        precom=new int[n][n];

        for(int i=0;i<n;i++){
            precom[i][i]=arr[i];
            for(int j=i+1;j<n;j++){
                precom[i][j]=Math.max(precom[i][j-1],arr[j]);
            }
        }
        return solve(arr,0,n-1);
    }
    int solve(int arr[],int i,int j){
        if(i==j)
        return 0;

        if(dp[i][j]!=0)
        return dp[i][j];

        int res=Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int left=solve(arr,i,k);
            int right=solve(arr,k+1,j);
            int cost=left+right+precom[i][k]*precom[k+1][j];
            res=Math.min(res,cost);

        }
        return dp[i][j]=res;
    }
}