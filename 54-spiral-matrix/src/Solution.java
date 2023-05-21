import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        var res = new ArrayList<Integer>();

        var spiral = 0;
        var direction = Direction.RIGHT;
        var i = 0;
        var j = 0;

        var height = matrix.length;
        var width = matrix[0].length;

        for (int count = 0; count < height * width; ++count) {
            res.add(matrix[i][j]);

            switch(direction) {
                case RIGHT:
                    if (j == width - 1 - spiral) {
                        direction = Direction.DOWN;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case DOWN:
                    if (i == height - 1 - spiral) {
                        direction = Direction.LEFT;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case LEFT:
                    if (j == spiral) {
                        direction = Direction.UP;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case UP:
                    if (i == 1 + spiral) {
                        direction = Direction.RIGHT;
                        j++;
                        spiral++;
                    } else {
                        i--;
                    }
                    break;
            }
        }

        return res;
    }

    enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }
}