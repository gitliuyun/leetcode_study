package dp;

/**
 * 最多买卖2次股票最大利润
 */
public class StockMaxProfit {
    private int maxProfit(int[] prices) {
        //每日结束后五种状态 s0：无操作 s1：买一次 s2：买一次卖一次  s3:买2次卖1次  s4：买2次卖2次
        //对应的利润为 p0-p4
        int p0 = 0, p1 = -prices[0], p2 = 0, p3 = -prices[0], p4 = 0;
        for (int i=1; i< prices.length; i++) {
            p1 = Math.max(p1, p0-prices[i]);
            p2 = Math.max(p2, p1+prices[i]);
            p3 = Math.max(p3, p2-prices[i]);
            p4 = Math.max(p4, p3+prices[i]);
        }
        return Math.max(p2, p4) > 0 ? Math.max(p2, p4): 0;
    }

    public static void main(String[] args) {
        int[] prices = {1,2};
        System.out.print(new StockMaxProfit().maxProfit(prices));
    }
}
