class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n=arr.length;
        int freq[]=new int[k];
        for(int num:arr){
            int rem=((num%k)+k)%k;
            freq[rem]++;
        }
        if(freq[0]%2!=0)
        return false;
        for(int i=1;i<=k/2;i++){
            if(freq[i]!=freq[k-i])
            return false;
        }

        return true;
    }
}


// class Solution {
//     public boolean canArrange(int[] arr, int k) {
//         int n=arr.length;
//         int left=0;
//         int right=n-1;
//         int count=0;
//         while(left<right){
//             if((arr[left]+arr[right])%k==0)
//             count++;
//             left++;
//             right--;
//         }
//         if(count==n/2)
//         return true;

//         return false;

//     }
// }