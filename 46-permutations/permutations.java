class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        boolean used[]=new boolean[nums.length];
        solve(result,nums,used,new ArrayList<>());
        return result;
    }
    void solve(List<List<Integer>> result,int nums[],boolean used[],List<Integer> list){
        if(list.size()==nums.length){
        result.add(new ArrayList<>(list));
        return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])
            continue;

            used[i]=true;
            list.add(nums[i]);

            solve(result,nums,used,list);

            list.remove(list.size()-1);
            used[i]=false;

        }
    }
}