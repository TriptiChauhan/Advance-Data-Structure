class NumMatrix {

    int precomp[][];
    public NumMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        precomp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                precomp[i][j]=matrix[i-1][j-1]+precomp[i-1][j]+precomp[i][j-1]-precomp[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        // brute force
        // int sum=0;
        // for(int i=row1;i<=row2;i++){
        //     for(int j=col1;j<=col2;j++){
        //         sum+=matrix[i][j];
        //     }
        // }
        // return sum;


        row1++;col1++;row2++;col2++;

        // prefix sum for big rectangle formula
        return precomp[row2][col2]-precomp[row1-1][col2]-precomp[row2][col1-1]+precomp[row1-1][col1-1];
       
       
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */