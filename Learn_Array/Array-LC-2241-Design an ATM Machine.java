//O(1)
//O(1)
class ATM {
    public int[] note_container;
    public int[] value_container;
    public ATM() {
        this.note_container = new int[5];
        this.value_container = new int[] {20,50,100,200,500};
    }
    
    public void deposit(int[] banknotesCount) {
        this.note_container[0]+=banknotesCount[0];
        this.note_container[1]+=banknotesCount[1];
        this.note_container[2]+=banknotesCount[2];
        this.note_container[3]+=banknotesCount[3];
        this.note_container[4]+=banknotesCount[4];
    }
    
    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        if (amount % 5 != 0) { 
            return new int[]{-1};
        }

        int n = 5;
        for(int i=n-1;i>=0;i--){
            int value = this.value_container[i];
            int note = this.note_container[i];
            if(amount<value){
                continue;
            }
            
            int m = amount/value;
            int min_deducted = Math.min(note,m);
            amount -= (min_deducted*value);
            ans[i]=min_deducted;
        }
        if(amount>0){
            return new int[]{-1};
        }
        if(amount==0){
            for(int i=n-1;i>=0;i--){
                this.note_container[i]-=ans[i];
            }
        }
        return ans;
    }
}
