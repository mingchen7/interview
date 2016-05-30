public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return (word == null);
        }
        if (word.length() == 0)
            return true;
        if (board.length == 0 || board[0].length == 0)
            return false;
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    board[i][j]^=256;
                    if (helper(board, i, j, word.substring(1)))
                        return true;
                    board[i][j]^=256;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int row, int col, String word) {
        if (word.equals(""))
            return true;

        // up 
        if (row > 0 && board[row - 1][col] == word.charAt(0)) {
            board[row - 1][col] ^=256;
            if (helper(board, row - 1, col, word.substring(1)))
                return true;
            else
                board[row - 1][col] ^=256;
        }

        //down
        if (row < board.length - 1 && board[row + 1][col] == word.charAt(0)) {
            board[row + 1][col] ^=256;
            if (helper(board, row + 1, col, word.substring(1)))
                return true;
            else
                board[row + 1][col] ^=256;
        }

        // left
        if (col > 0 && board[row][col - 1] == word.charAt(0)) {
            board[row][col - 1] ^=256;
            if (helper(board, row, col - 1, word.substring(1)))
                return true;
            else
                board[row][col - 1] ^=256;
        }

        //down
        if (col < board[0].length - 1 && board[row][col + 1] == word.charAt(0)) {
            board[row][col + 1] ^=256;
            if (helper(board, row, col + 1, word.substring(1))) {
                return true;
            } else
                board[row][col + 1] ^=256;
        }
        return false;
    }
}