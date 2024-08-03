class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> hm = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int a = arr[i]*2;
            int b = arr[i]/2;
            if(arr[i]%2==0){
                if(hm.contains(a) || (hm.contains(b))) return true;
            }
            else{
                if(hm.contains(a)) return true;
            }
            hm.add(arr[i]);
        }
        return false;
        
    }
}
