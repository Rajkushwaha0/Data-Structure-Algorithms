class ProductOfNumbers {
    ArrayList<Integer> l;
    public ProductOfNumbers() {
        l=new ArrayList<>();
    }
    
    public void add(int num) {
        if(num==0){
            l.clear();
            return ;
        }
        if(l.isEmpty()){
            l.add(num);
        }else{
            int n=l.size();
            int val = l.get(n-1);
            l.add(val*num);
        }
        return ;
    }
    
    public int getProduct(int k) {
        int n = l.size();
        if(n<k) return 0;
        int lastProduct  = l.get(n-1);
        if(k==n) return lastProduct;
        int dividorValue = l.get(n-1-k);
        return lastProduct/dividorValue;
    }
}
