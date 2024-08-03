//Not optimize 
class CustomStack {
    public Stack<Integer> s = new Stack<>();
    int max;
    public CustomStack(int maxSize) {
        max=maxSize;
    }
    
    public void push(int x) {
        if(s.size()<max) s.push(x);
    }
    
    public int pop() {
        if(s.isEmpty()) return -1;
        return s.pop();
    }
    
    public void increment(int k, int val) {
        List<Integer> l = new ArrayList<>();
        if(k>=max){
            while(!s.isEmpty()){
                l.add(val+s.pop());
            }
        }
        else if(k<max){
            int n=s.size()-k;
            int count=0;
            while(!s.isEmpty()){
                if(count<n) l.add(s.pop());
                else l.add(val+s.pop());
                count++;
            }

        }
        for(int i=l.size()-1;i>=0;i--){
            s.push(l.get(i));
        }
        
    }
}



//Optimize use array instead of stack
class CustomStack {
    int max;
    int[] s;
    int ptr=0;
    public CustomStack(int maxSize) {
        max=maxSize;
        s = new int[maxSize];
    }
    
    public void push(int x) {
        if(ptr<max){
            s[ptr]=x;
            ptr++;
        }
    }
    
    public int pop() {
        if(ptr==0) return -1;
        return s[--ptr];
    }
    
    public void increment(int k, int val) {
        if(k>max){
            for(int i=0;i<max;i++){
                s[i]+=val;
            }
        }
        else{
            for(int i=0;i<k;i++){
                s[i]+=val;
            }
        }
        
    }
}
