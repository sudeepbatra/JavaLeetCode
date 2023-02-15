package com.stoxalpha;

public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        fizzBuzz.printFizzBuzz(100);
    }

    private void printFizzBuzz(int fizzBuzzTill) {
        for (int i = 1; i <= fizzBuzzTill; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
