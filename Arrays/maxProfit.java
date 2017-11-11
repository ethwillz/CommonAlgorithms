int findMaxProfit(int[] stockPrices){
  int minPrice = stockPrices[0];
  int maxProfit = stockPrices[1] - minPrice;

  for(int i = 1; i < stockPrices.length; i++{
    minPrice = Math.min(minPrice, stockPrices[i]);
    maxProfit = Math.max(maxProfit, stockPrices[i] - minPrice);
  }

  return maxProfit;
}
