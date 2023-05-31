package seminar2;

import java.util.Arrays;

public class Quicksort {


    public static void quickSort(int[] var0, int var1, int var2) {
        if (var0.length != 0) {
            if (var1 < var2) {
                int var3 = var1 + (var2 - var1) / 2;
                int var4 = var0[var3];
                int var5 = var1;
                int var6 = var2;

                while (var5 <= var6) {
                    while (var0[var5] < var4) {
                        ++var5;
                    }

                    while (var0[var6] > var4) {
                        --var6;
                    }

                    if (var5 <= var6) {
                        int var7 = var0[var5];
                        var0[var5] = var0[var6];
                        var0[var6] = var7;
                        ++var5;
                        --var6;
                    }
                }

                if (var1 < var6) {
                    quickSort(var0, var1, var6);
                }

                if (var2 > var5) {
                    quickSort(var0, var5, var2);
                }

            }
        }
    }

    public static void main(String[] var0) {
        int[] var1 = new int[]{8, 0, 4, 7, 3, 7, 10, 12, -3};
        System.out.println("Было");
        System.out.println(Arrays.toString(var1));
        byte var2 = 0;
        int var3 = var1.length - 1;
        quickSort(var1, var2, var3);
        System.out.println("Стало");
        System.out.println(Arrays.toString(var1));
    }
}