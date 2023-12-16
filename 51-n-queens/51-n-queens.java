import java.util.*;

class Solution {
    private List<List<String>> res = new ArrayList<>();

    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;
    private char[][] board;

    void nQueen(int n, int row) {
        if (row >= n) {
            List<String> sol = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                sol.add(new String(board[i]));
            }
            res.add(sol);
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (!cols[i] && !diag1[row + i] && !diag2[row - i + n]) {
                cols[i] = true;
                diag1[row + i] = true;
                diag2[row - i + n] = true;
                board[row][i] = 'Q';

                nQueen(n, row + 1);

                cols[i] = false;
                diag1[row + i] = false;
                diag2[row - i + n] = false;
                board[row][i] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        res.clear();

        if (n <= 0) {
            return res;
        }

        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        board = new char[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }

        nQueen(n, 0);

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solveNQueens(5);
    }
}
