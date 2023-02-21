package com.stoxalpha.sudoku;

public class Sudoku {

    private int[][] sudokuTable;

    public Sudoku(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
    }

    public void solveProblem() {
        if (solve(0, 0)) {
            showSolution();
        } else {
            System.out.println("No solution exists");
        }
    }

    private boolean solve(int rowIndex, int colIndex) {
        if(rowIndex == Constants.BOARD_SIZE) {
            colIndex++;

            if (colIndex == Constants.BOARD_SIZE) {
                return true;
            } else {
                rowIndex = 0;
            }
        }

        if (sudokuTable[rowIndex][colIndex] != 0) {
            return solve(rowIndex +1 , colIndex);
        }

        for (int num = Constants.MIN_NUMBER; num <= Constants.MAX_NUMBER; num++) {
            if (isValid(rowIndex, colIndex, num)) {
                sudokuTable[rowIndex][colIndex] = num;

                if (solve(rowIndex +1, colIndex)) {
                    return true;
                }

                sudokuTable[rowIndex][colIndex] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int rowIndex, int colIndex, int num) {
        for (int i=0; i < Constants.BOARD_SIZE; i++) {
            if (sudokuTable[i][colIndex] == num) {
                return false;
            }

            if (sudokuTable[rowIndex][i] == num) {
                return false;
            }
        }

        int boxRowOffset = (rowIndex / 3) * Constants.BOX_SIZE;
        int boxColumnOffset = (colIndex / 3) * Constants.BOX_SIZE;

        for (int i = 0; i < Constants.BOX_SIZE; ++i) {
            for (int j = 0; j < Constants.BOX_SIZE; ++j) {
                if(sudokuTable[boxRowOffset + i][boxColumnOffset + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public void showSolution() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if (i % 3 == 0) System.out.println();
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if (j % 3 == 0) System.out.print("  ");
                System.out.print(sudokuTable[i][j] + " ");
            }
            System.out.println();
        }
    }
}
