//O(N.log N (base 10)) 
//O(N)
class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans= -1;
        for(int i:nums){
            int digitSum = getDigitSum(i);
            if(!hm.containsKey(digitSum)){
                hm.put(digitSum,i);
            }else{
                int storedLargestValue = hm.get(digitSum);
                ans = Math.max(ans, (storedLargestValue+i));
                hm.put(digitSum,Math.max(i,storedLargestValue));
            }
        }
        return ans;
    }
    public int getDigitSum(int n){
        int sum = 0;
        while(n!=0){
            int m = n%10;
            sum+=m;
            n /= 10;
        }
        return sum;
    }
}
//can optimized by just using array of 82 size for storing max value
//because constraint say that 10^9 max number can be
// 9+9+9+9+9+9+9+9+9 sums to 81 
//SC -> O(N) goes to O(1)



//O(N. (log(n)+log(m))
//O(N)
class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,TreeSet<Integer>> hm = new HashMap<>();
        int ans= -1;
        for(int i:nums){
            int digitSum = getDigitSum(i);
            if(!hm.containsKey(digitSum)){
                hm.put(digitSum, new TreeSet<>(Comparator.reverseOrder()));
            }else{
                int storedLargestValue = hm.get(digitSum).first();
                ans = Math.max(ans, (storedLargestValue+i));
            }
            hm.get(digitSum).add(i);
        }
        return ans;
    }
    public int getDigitSum(int n){
        int sum = 0;
        while(n!=0){
            int m = n%10;
            sum+=m;
            n /= 10;
        }
        return sum;
    }
}
