class Solution {
    public int passThePillow(int n, int time) {
        int a = time / (n-1);
        int b = time % (n-1);
        int res = 0;
        if (a % 2 != 0) {
            res=n-b;
        } else {
            res=b+1;
        }
        return res;
    }
}
