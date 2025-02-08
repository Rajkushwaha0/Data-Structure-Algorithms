//optimized by treeset in takes logN
class NumberContainers {
    HashMap<Integer,TreeSet<Integer>> hmTree;
    HashMap<Integer,Integer> hm;
    public NumberContainers() {
        hmTree = new HashMap<>();
        hm = new HashMap<>();
    }
    //O(log n)
    //log(n log n) wrost case
    public void change(int index, int number) {
        if(hm.containsKey(index)){
            int lastNumber = hm.get(index);
            TreeSet<Integer> lastNumberSet = hmTree.get(lastNumber);
            lastNumberSet.remove(index);
            hm.remove(index);
        }
        hmTree.putIfAbsent(number, new TreeSet<>());
        hmTree.get(number).add(index);
        hm.put(index,number);
        return ;
    }
    //O(log n)
    //O(1)
    public int find(int number) {
        if(!hmTree.containsKey(number)){
            return -1;
        }
        TreeSet<Integer> numberSet = hmTree.get(number);
        return numberSet.isEmpty() ? -1 : numberSet.first();
    }
}

//Correct solution but tle 
class NumberContainers {
    HashMap<Integer,PriorityQueue<Integer>> hmPq;
    HashMap<Integer,Integer> hm;
    public NumberContainers() {
        hmPq = new HashMap<>();
        hm = new HashMap<>();
    }
    //O(N)
    //O(N)
    public void change(int index, int number) {
        if(hm.containsKey(index)){
            int lastNumber = hm.get(index);
            PriorityQueue<Integer> lastNumberPq = hmPq.get(lastNumber);
            lastNumberPq.remove(index);
            hm.remove(index);
        }
        hmPq.putIfAbsent(number, new PriorityQueue<>());
        hmPq.get(number).offer(index);
        hm.put(index,number);
        return ;
    }
    //O(1)
    //O(N)
    public int find(int number) {
        if(!hmPq.containsKey(number)){
            return -1;
        }
        PriorityQueue<Integer> numberPq = hmPq.get(number);
        return numberPq.isEmpty() ? -1 : numberPq.peek();
    }
}
