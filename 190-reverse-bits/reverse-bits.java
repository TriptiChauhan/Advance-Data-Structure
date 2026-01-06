class Solution {
    public int reverseBits(int n) {
        int lsb=0;
        int res=0;
        for(int i=0;i<32;i++){
            lsb=n&1;
            int reverse=lsb<<(31-i);
            res=res|reverse;
            n=n>>1;
        }
        return res;
    }
}