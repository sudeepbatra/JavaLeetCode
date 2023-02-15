package com.stoxalpha;

/*
In mathematics, the sieve of Eratosthenes is an ancient algorithm for finding all prime numbers up to any given limit.
algorithm Sieve of Eratosthenes is
    input: an integer n > 1.
    output: all prime numbers from 2 through n.

    let A be an array of Boolean values, indexed by integers 2 to n,
    initially all set to true.

    for i = 2, 3, 4, ..., not exceeding √n do
        if A[i] is true
            for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n do
                set A[j] := false

    return all i such that A[i] is true.

    The time complexity of this algorithm is O(n log log n). The basic algorithm requires O(n) of memory.
*/
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        sieveOfEratosthenes.printPrimesUptoLimit(30);
    }

    private void printPrimesUptoLimit(int upperLimit) {
        int upperLimitSquareRoot = (int) Math.sqrt(upperLimit);

        boolean[] isComposite = new boolean[upperLimit + 1];

        for (int m = 2; m <= upperLimitSquareRoot; m++) {
            if (!isComposite[m]) {
                System.out.print(m + " ");

                for (int j = m * m; j < upperLimit; j +=m ) {
                    isComposite[j] = true;
                }
            }
        }

        System.out.println("\nEverthing left over is prime...");

        for (int m = upperLimitSquareRoot; m <= upperLimit; m++) {
            if (!isComposite[m]) {
                System.out.print(m + " ");
            }
        }
    }
}
