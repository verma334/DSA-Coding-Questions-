package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

	 public List<List<String>> solveNQueens(int n) {
	        List<List<String>> result = new ArrayList<>();
	        char[][] board = new char[n][n];

	        // Fill the board with '.'
	        for (char[] row : board) {
	            Arrays.fill(row, '.');
	        }

	        // Start solving from row 0
	        solve(board, 0, result);
	        return result;
	    }

	    private void solve(char[][] board, int row, List<List<String>> result) {
	        int n = board.length;

	        // If all rows are filled, add the board to result
	        if (row == n) {
	            result.add(convertBoard(board));
	            return;
	        }

	        // Try placing a queen in each column of the current row
	        for (int col = 0; col < n; col++) {
	            if (isSafe(board, row, col)) {
	                board[row][col] = 'Q';      // Place queen
	                solve(board, row + 1, result); // Recurse to next row
	                board[row][col] = '.';      // Backtrack
	            }
	        }
	    }

	    // Check if it's safe to place a queen at board[row][col]
	    private boolean isSafe(char[][] board, int row, int col) {
	        int n = board.length;

	        // Check column
	        for (int i = 0; i < row; i++) {
	            if (board[i][col] == 'Q') return false;
	        }

	        // Check upper-left diagonal
	        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
	            if (board[i][j] == 'Q') return false;
	        }

	        // Check upper-right diagonal
	        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
	            if (board[i][j] == 'Q') return false;
	        }

	        return true;
	    }

	    // Convert board to list of strings
	    private List<String> convertBoard(char[][] board) {
	        List<String> result = new ArrayList<>();
	        for (char[] row : board) {
	            result.add(new String(row));
	        }
	        return result;
	    }

	    public static void main(String[] args) {
	    	NQueens solver = new NQueens();
	        System.out.println(solver.solveNQueens(4));
	        System.out.println(solver.solveNQueens(1));
	    }
}
