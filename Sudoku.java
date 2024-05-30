


public class Sudoku {
    private int[][] board;

    public Sudoku(int[][] board) {
        this.board = board;
    }

    public boolean solve() {
        return solve(0, 0);
    }

    private boolean solve(int row, int col) {
        if (row == 9) {
            return true; // Solved entire board
        }
        if (col == 9) {
            return solve(row + 1, 0); // Move to next row
        }
        if (board[row][col] != 0) {
            return solve(row, col + 1); // Skip filled cells
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;
                if (solve(row, col + 1)) {
                    return true;
                }
                board[row][col] = 0; // Backtrack
            }
        }
        return false; // No solution found
    }

    private boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num || 
                board[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int r = 0; r < 9; r++) {
            for (int d = 0; d < 9; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
