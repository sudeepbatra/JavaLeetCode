package com.stoxalpha;

public class IntegerReversal {
    public static void main(String[] args) {
        IntegerReversal integerReversal = new IntegerReversal();
        int num = -1234;
        int reverse = integerReversal.reverse(num);
        System.out.println(reverse);
    }

    public int reverse(int num) {
        boolean isNegative = num < 0;
        if (isNegative) {
            num = num * -1;
        }

        int reversed_num = 0;
        while (num > 0) {
            int remainder = num % 10;
            num /= 10;
            reversed_num = reversed_num * 10 + remainder;
        }

        return isNegative ? reversed_num * -1: reversed_num;
    }
}
