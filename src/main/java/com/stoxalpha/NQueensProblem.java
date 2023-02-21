package com.stoxalpha;

public class NQueensProblem {
    private final int[][] chessTable;
    private final int numberOfQueens;

    public NQueensProblem(int numberOfQueens) {
        this.numberOfQueens = numberOfQueens;
        this.chessTable = new int[numberOfQueens][numberOfQueens];
    }

    public void solve() {
        if (solveQueenForColIndex(0)) {
            printQueens();
        } else {
            System.out.println("There is no solution ...");
        }
    }

    private boolean solveQueenForColIndex(int colIndex) {
        System.out.println("Solving Queen solution for colIndex: " +colIndex);

        if (colIndex == numberOfQueens) {
            System.out.println("Solution Found.");
            return true;
        }

        for (int rowIndex = 0; rowIndex < this.numberOfQueens; rowIndex++) {
            if (isPlaceValid(rowIndex, colIndex)) {
                chessTable[rowIndex][colIndex] = 1;

                if (solveQueenForColIndex(colIndex + 1)) {
                    System.out.println("Solution true for colIndex + 1: " + colIndex + 1);
                    return true;
                }

                //Backtrack
                System.out.println("Backtracking for colIndex: " + colIndex);
                chessTable[rowIndex][colIndex] = 0;
            }
        }

        return false;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {
        //no queens in the same row
        for (int i = 0; i < colIndex; i++) {
            if (chessTable[rowIndex][i] == 1) {
                return false;
            }
        }

        //no need to check the col

        //check the diagonal
        //diagonal location from top left to bottom right
        for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
            if (chessTable[i][j] == 1) {
                return false;
            }
        }

        //diagonal from top right to bottom left
        for (int i = rowIndex, j = colIndex; i < chessTable.length && j >= 0; i++, j--) {
            if (chessTable[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private void printQueens() {
        for (int i = 0; i < chessTable.length; i++) {
            for (int j = 0; j < chessTable.length; j++) {
                if (chessTable[i][j] == 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NQueensProblem nQueensProblem = new NQueensProblem(30);
        nQueensProblem.solve();
    }
}
