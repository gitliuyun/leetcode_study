package recurse;

public class MiGong {
    //��ʼ���Թ�
    private int[][] initArray(int m, int n){
        int[][] array = new int[m][n];
        //��ʼ����
        for (int i = 0; i < m; i++) {
            array[i][0] = 1;
            array[i][n-1] = 1;
        }
        //��ʼ����
        for (int i = 0; i < n; i++) {
            array[0][i] = 1;
            array[m-1][i] = 1;
        }

        if (m < 3 || n < 2) {
            return array;
        }
        array[3][1] = 1;
        array[3][2] = 1;

        return array;
    }
    //��ӡ���
    private void print(int[][] array){
        System.out.println(array);
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    //���Թ�����
    private int[][] setway(int[][] array, int i, int j){
        int m = array.length;
        int n = array[0].length;
        //�ߵ����
        if (array[m - 2][n - 2] == 2) {
            return array;
        }

        array[i][j] = 2;
        if (array[i + 1][j] == 0) {
            setway(array, i + 1, j);
        } else if (array[i][j + 1] == 0) {
            setway(array, i, j + 1);
        } else if (array[i - 1][j] == 0) {
            setway(array, i - 1, j);
        } else if (array[i][j - 1] == 0) {
            setway(array, i, j - 1);
        } else {
            //�߲�ͨ
            array[i][j] = 3;
        }


        return array;
    }

    public static void main(String[] args) {
        MiGong miGong = new MiGong();
        int[][] array = miGong.initArray(10,15);
        miGong.setway(array, 1,1);
        miGong.print(array);
    }
}
