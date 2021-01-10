package recurse;

public class EightQueens {
    static int count = 0;
    //����n���Ƿ��֮ǰ����ͬһ�л���ͬһб�� n ��0 ��ʼ
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

    //��ӡ����
    private void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    //���õ�n������, n��0��ʼ
    private void put(int[] array, int n){
        if (n == 8) {
            count ++;
            print(array);
            return;
        }
        for (int i = 0; i < 8; i++) {
            //�����ȷ��ϵ�n���ʺ��ټ��
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
