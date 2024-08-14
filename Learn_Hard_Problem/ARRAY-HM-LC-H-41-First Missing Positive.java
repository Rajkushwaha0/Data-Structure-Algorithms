//Optimize without hashmap
public class Solution {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}


class Solution {
    public int firstMissingPositive(int[] nums) {
        int min=Integer.MAX_VALUE;
        HashMap<Integer,Integer> hm =new  HashMap<>();
        for(int i:nums){
            if(i>0) {
                min=Math.min(min,i);
                hm.put(i,1);
            }
        }
        if(nums.length==1){
            if(min==1) return 2;
            return 1;
        }
        if(min!=1) return 1;
        int count=0;
        for(int i=1;i<=nums.length;i++){
            if(!hm.containsKey(i)) return i;
            else{
                count+=1;
            }
        }
        if(count<nums.length) return nums.length;
        return nums.length+1;
    }
}
