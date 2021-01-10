package recurse;

public class EightQueens {
    static int count = 0;
    //检查第n个是否和之前的在同一列或者同一斜线 n 从0 开始
    private boolean check(int[] array, int n){
        if (n == 0) {
            return true;
        }
        if (n > array.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (Math.abs(array[n] - array[i]) == Math.abs(n - i) || (array[n] == array[i])) {
                return false;
            }
        }
        return true;
    }

    //打印数组
    private void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    //放置第n个棋子, n从0开始
    private void put(int[] array, int n){
        if (n == 8) {
            count ++;
            print(array);
            return;
        }
        for (int i = 0; i < 8; i++) {
            //必须先放上第n个皇后再检查
            array[n] = i;
            if (check(array, n)) {
                put(array, n + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[8];
        EightQueens eightQueens = new EightQueens();
        eightQueens.put(array, 0);
        System.out.println(count);
    }

}
