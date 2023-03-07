class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, holdPrice = prices[0];
        for (int price : prices){
            if(holdPrice < price){
                profit += price - holdPrice;
                holdPrice = price;
            }
            else if(holdPrice > price){
                holdPrice = price;
            }
        }
        return profit;
    }
}
