//O(1)
//O(N)
class Bank {
    public long[] balance;
    public int length;

    public Bank(long[] balance) {
        this.balance = balance; 
        this.length = balance.length; 
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1>this.length || account2>this.length){
            return false;
        }

        long current_value_acc1 = this.balance[account1-1];
        if(current_value_acc1<money){
            return false;
        }
        this.balance[account1-1] -= money;
        this.balance[account2-1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account>this.length){
            return false;
        }

        this.balance[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account>this.length){
            return false;
        }
        long current_value = this.balance[account-1];
        if(current_value<money){
            return false;
        }
        this.balance[account-1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
