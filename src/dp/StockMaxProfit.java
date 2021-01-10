package dp;

/**
 * �������2�ι�Ʊ�������
 */
public class StockMaxProfit {
    private int maxProfit(int[] prices) {
        //ÿ�ս���������״̬ s0���޲��� s1����һ�� s2����һ����һ��  s3:��2����1��  s4����2����2��
        //��Ӧ������Ϊ p0-p4
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
