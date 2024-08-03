class MyHashSet {
    HashMap<Integer,Integer> hm ;
    public MyHashSet() {
        hm = new HashMap<>();
        
    }
    
    public void add(int key) {
        hm.put(key,1);
    }
    
    public void remove(int key) {
        if(hm.containsKey(key)) hm.remove(key);
    }
    
    public boolean contains(int key) {
        if(hm.containsKey(key)) return true;
        return false;
    }
}
