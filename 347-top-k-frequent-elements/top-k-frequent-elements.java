class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1); // frequency count kr rhe h 
            // agar num ki freq nhi h to 0 h usme 1 add kiya to first element ki freq 1 ho gai
        }

        List<Integer> list=new ArrayList<>(map.keySet());

        Collections.sort(list,(a,b)->map.get(b)-map.get(a));

        int res[]=new int[k];
        for(int i=0;i<k;i++){
            res[i]=list.get(i);
        }

    return res;
    }
}