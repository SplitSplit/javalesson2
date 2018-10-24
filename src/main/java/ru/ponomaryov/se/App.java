package ru.ponomaryov.se;

/**
*/
/**
 * @author Oleg Ponomaryov
 * @version 1.0.0
 */
public class App {
    public static void main(String[] args) {
        int[] revertArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] revArray = revertArrayValues(revertArray);
        int[] checkArray = {4, 5, 6, 15, 30};
        for (int a : revArray) {
            System.out.print(a);
        }
        System.out.println("");
        incrementCustomArray();
        multipleArrayValues(6, 2);
        buildDiagonalArray(9);
        findExtremums();
        if (checkBalance(checkArray)) {
            System.out.println("Array is balanced");
        } else {
            System.out.println("Array is not balanced");
        }
        shiftArray(checkArray, -3);
    }

    private static int[] revertArrayValues(int[] arrayValues) {
        int[] arV = new int[arrayValues.length];
        int a = 0;
        for (int av : arrayValues) {
            if (av == 1) {
                arV[a] = 0;
                a++;
            } else if (av == 0) {
                arV[a] = 1;
                a++;
            }
        }
        return arV;
    }

    private static void incrementCustomArray() {
        int[] incArray = new int[8];
        int i = 0;
        while (i < 8) {
            incArray[i] = i * 3;
            i++;
        }
        for (int a : incArray) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    private static void multipleArrayValues(int minMultValue, int mult) {
        int[] sourceArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int val : sourceArray) {
            if (val < minMultValue) {
                System.out.print(val * mult + " ");
            } else {
                System.out.print(val + " ");
            }
        }
        System.out.println("");
    }

    private static void buildDiagonalArray(int size) {
        if (size < 3) {
            return;
        }
        int[][] diagonalArray = new int[size][size];
        int xAxis, yAxis;

        for (xAxis = 0; xAxis < size; xAxis++) {
            for (yAxis = 0; yAxis < size; yAxis++) {
                if (xAxis == yAxis || xAxis == (size - 1 - yAxis)) {
                    diagonalArray[xAxis][yAxis] = 1;
                } else {
                    diagonalArray[xAxis][yAxis] = 0;
                }
                System.out.print(diagonalArray[xAxis][yAxis]);
            }
            System.out.println("");
        }
    }

    private static void findExtremums() {
        int[] extremumsArray = {5, 2, 1, 5, -8, 16, 32, 4, -12, 32, 24, 7, 12, 21, 14, 0, -8, 6};
        int minExtremum = 0;
        int maxExtremum = 0;
        for (int value : extremumsArray) {
            if (value < minExtremum) {
                minExtremum = value;
            }
            if (value > maxExtremum) {
                maxExtremum = value;
            }
        }
        System.out.println("Min value: " + minExtremum);
        System.out.println("Max value: " + maxExtremum);
    }

    private static int summationArrayPartition(int[] array, int start, int length) {
        int result = 0;
        if (array.length < start || array.length < (start + length)) {
            return 0;
        }
        for (int i = start; i < (start + length); i++) {
            result += array[i];
        }
        return result;
    }

    private static boolean checkBalance(int[] array) {
        int position;
        int leftSum;
        int rightSum;
        if (array.length < 2) {
            System.out.println("Abnormal array size");
        }
        for (position = 1; position < array.length; position++) {
            rightSum = summationArrayPartition(array, 0, position);
            leftSum = summationArrayPartition(array, position, array.length - position);
            if (rightSum == leftSum) {
                return true;
            }
        }
        return false;
    }

    private static void shiftArray(int[] array, int n) {
        int size = array.length;
        int tmpValue;
        int c;
        int i;
        if (n > 0) {
            for (i = 0; i < n; i++) {
                tmpValue = array[size - 1];
                for (c = size - 1; c > 0; c--) {
                    array[c] = array[c - 1];
                }
                array[0] = tmpValue;
            }
        } else {
            for (i = 0; i < Math.abs(n); i++) {
                tmpValue = array[0];
                for (c = 1; c < size; c++) {
                    array[c - 1] = array[c];
                }
                array[size - 1] = tmpValue;
            }
        }
        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
