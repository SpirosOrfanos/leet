package y2022.mid;

import java.util.*;
public class WordSearchInMatrix {

    private static int[][] shift = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public static void main(String[] args) {
        WordSearchInMatrix app = new WordSearchInMatrix();
        char[][] arr = {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}};
    System.out.println(app.exist(arr, "SEE"));
    }
    public boolean exist(char[][] board, String word) {
        char first = word.charAt(0);

        for (int i = 0; i< board.length; i++) {
            for(int j = 0;j<board[0].length; j++) {
                if(board[i][j] == first) {
                    if (exists(board, i, j, 0,  word))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean exists(char[][] board, int i, int j, int count, String word) {
        if (count == word.length())
            return true;
        if (!shouldAdd(board, word.charAt(count), i, j))  {
            return false;
        }
        board[i][j] = '+';
        boolean res = exists(board, i+shift[0][0], j+shift[0][1], count+1, word) ||
                exists(board, i+shift[1][0], j+shift[1][1], count+1, word) ||
                exists(board, i+shift[2][0], j+shift[2][1], count+1, word) ||
                exists(board, i+shift[3][0], j+shift[3][1], count+1, word);
        board[i][j] =  word.charAt(count);
        return res;
    }


    private static boolean shouldAdd(char[][] board, char check, int i , int j) {

        return i>=0 && j>=0 && i<board.length && j<board[0].length &&
                board[i][j] == check;
    }



}
