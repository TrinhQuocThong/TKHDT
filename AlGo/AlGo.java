package AlGo;

import MilkTeaStore.Beverage;
import MilkTeaStore.ChocolateFlavour;
import MilkTeaStore.Medium;
import MilkTeaStore.Topping;
import view.Order;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class AlGo {

    public static String createRandomString() {
        String rs = "";
        for (int i = 1; i <= 2; i++) {
            char a = (char) (int) ((Math.random() * 25) + 66);
            char b = (char) (int) ((Math.random() * 25) + 98);
            char c = (char) (int) ((Math.random() * 9) + 48);
            rs += a + "" + b + "" + c;

        }
        return rs;
    }

    public static boolean check(String input) {

        String rs = createRandomString();
        return (input.equals(rs));
    }


    public static int lengthOfLastWord(String s) {

        int dem = 1;

        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 32) {
                ++dem;
                j = 1;
            } else if (s.charAt(i) == 32 && j > 0) break;
        }
        return dem;
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length <= 0) return 0;
        if (nums.length == 1) return 1;
        int j = 1;
        int t = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if ((t ^= nums[i]) != 0) {
                nums[j++] = nums[i];
                t = nums[i];
            }
        }
        return j;
    }


    public static int removeDuplicates2(int[] nums) {
        int dem = 1;
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[j++] = nums[i + 1];
                dem = 1;
            } else if (dem <= 1) {
                nums[j++] = nums[i + 1];
                dem++;
            } else {
                dem++;
            }
        }
        return j;
    }

    public static int reverse(int x) {
        StringBuilder s = new StringBuilder();
        s.append(x);
        s.reverse();
        System.out.println(s);
        if (s.length() >= 12) {
            return 0;
        } else if (x < 0 && s.length() >= 11 || x > 0 && s.length() == 10) {
            if (Integer.parseInt(String.valueOf(s.charAt(0))) > 2) {
                return 0;
            }
        }





            return Integer.parseInt(s.toString());
    }


    public static int reverse2(int x) {
        StringBuilder s = new StringBuilder();
        s.append(x);
        int rs = 0;
        int a = 1;
        if (x < 0) {
            s.deleteCharAt('-');
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (a * Integer.parseInt(String.valueOf(s.charAt(i))) <= 1032192) {
                rs = rs * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                a *= Integer.parseInt(String.valueOf(s.charAt(i)));
            } else {
                return 0;
            }
        }
        if (x < 0) {
            return rs * -1;

        }

        if (a > 1032192) return 0;
        return rs;
    }


    public static int reverse3(int x) {
        StringBuilder a = new StringBuilder();
        a.append(x);
        StringBuilder b = new StringBuilder();
        b.append(Integer.MAX_VALUE);

        if (x > 0 && a.length() >= 11 || x < 0 && b.length() >= 12) return 0;

        else if (x > 0 && a.length() == 10 || x < 0 && a.length() == 11) {

            for (int i = a.length() - 1; i > 0; i--) {
                if (a.charAt(i) > b.charAt(i)) {
                    return 0;
                }
            }
        } else {
            a.reverse();
            if (x < 0) {
                a.deleteCharAt(a.length() - 1);
                return Integer.parseInt(String.valueOf(a)) * -1;
            }

        }
        return Integer.parseInt(String.valueOf(a));
    }

    public static StringBuilder re(StringBuilder s) {


        return s;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1563847412));


    }

}
