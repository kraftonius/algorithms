package lection1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.round;


public class Lesson1 {
//    public Lesson1() {
//    }

    public static void main(String[] var0) {
//        List<Integer> availableDivider = findSimpleNumbers(10);
//        for (Integer integer : availableDivider) {
//            System.out.println(integer);
//        }

        int win = 11;
        double chance = findSum(win);
        System.out.println("Chance of " + win + " = " + String.format("%.2f", findSum(win) * 100) + " %");


    }

    public static List<Integer> findAvailableDevider(int max) {
        ArrayList result = new ArrayList();
        for (int i = 1; i <= max; ++i) {
            if (max % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> findSimpleNumbers(int max) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter++;
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        System.out.println("Counter:" + counter);
        return result;
    }

    public static double findSum(int sum) {
        int count = 0;
        int successResult = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i + j + k == sum) {
                        successResult++;
                    }
                    count++;
                }
            }
        }
        return ((double) successResult) / ((double) count);
    }


}
