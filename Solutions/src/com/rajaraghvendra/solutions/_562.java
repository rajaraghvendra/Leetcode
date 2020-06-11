package com.rajaraghvendra.solutions;

/**
 * Created by fishercoder on 4/23/17.
 *
 * 562. Longest Line of Consecutive One in Matrix
 *
 * Given a 01 matrix m, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.

 Example:

 Input:
 [[0,1,1,0],
  [0,1,1,0],
  [0,0,0,1]]

 Output: 3
 Hint: The number of elements in the given matrix will not exceed 10,000.
 */
public class _562 {

    public static class Solution1 {
        public int longestLine(int[][] M) {
            if (M == null || M.length == 0) {
                return 0;
            }
            int[][] directions = new int[][]{
                    {-1, 0},
                    {-1, 1},
                    {0, 1},
                    {1, 1},
                    {1, 0},
                    {1, -1},
                    {0, -1},
                    {-1, -1},
            };
            int longestLine = 0;
            int m = M.length;
            int n = M[0].length;
            int[][][] cache = new int[m][n][8];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (M[i][j] == 1) {
                        for (int k = 0; k < directions.length; k++) {
                            int nextI = i + directions[k][0];
                            int nextJ = j + directions[k][1];
                            int thisLine = 1;
                            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && cache[nextI][nextJ][k] != 0) {
                                thisLine += cache[nextI][nextJ][k];
                                cache[i][j][k] = thisLine;
                            } else {
                                while (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && M[nextI][nextJ] == 1) {
                                    thisLine++;
                                    cache[i][j][k] = thisLine;
                                    nextI += directions[k][0];
                                    nextJ += directions[k][1];
                                }
                            }
                            longestLine = Math.max(longestLine, thisLine);
                        }
                    }
                }
            }
            return longestLine;
        }
    }

}
