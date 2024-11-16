class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottle = numBottles;
        int bottleDrink = numBottles;
        numBottles=0;
        while(numBottles+emptyBottle >= numExchange){
             emptyBottle-=numExchange;
             emptyBottle++;
             numExchange++;
             bottleDrink++;
        }
        return bottleDrink;
    }
}
