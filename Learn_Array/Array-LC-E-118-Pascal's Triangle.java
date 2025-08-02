//TC:O(n^2)
//SC:O(n^2)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        ans.add(row);
        if(numRows==1) return ans;
        for(int i=1;i<numRows;i++){
            List<Integer> prev = row;
            row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add((prev.get(j-1)+prev.get(j)));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }
}
