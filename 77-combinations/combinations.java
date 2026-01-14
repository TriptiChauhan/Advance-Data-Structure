class Solution {
    public List<List<Integer>> combine(int n, int k) {
       List<List<Integer>> result = new ArrayList<>();
        solve(1,n,k,result,new ArrayList<>());
        return result;
    }
    void solve(int i,int n,int k, List<List<Integer>> result,List<Integer> list){
        if(k==0){
        result.add(new ArrayList<>(list));
        return;
        }

        if(i>n)
        return;

        list.add(i);
        solve(i+1,n,k-1,result,list);

        list.remove(list.size()-1);
        solve(i+1,n,k,result,list);
    }
}