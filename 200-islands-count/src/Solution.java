import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public int numIslands(char[][] grid) {
        var islandsCount = 0;
        var height = grid.length;
        var width = grid[0].length;

        var visitedCoordinates = new HashSet<Coordinate>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isIsland(grid[i][j]) && !visitedCoordinates.contains(new Coordinate(i, j))) {
                    islandsCount++;
                    traceIsland(new Coordinate(i, j), visitedCoordinates, grid);
                }
            }
        }
        return islandsCount;
    }

    private void traceIsland(Coordinate startCoordinate, Set<Coordinate> visitedCoordinates, char[][] grid) {
        var coordinatesToVisit = new LinkedList<Coordinate>();
        coordinatesToVisit.add(startCoordinate);

        var height = grid.length;
        var width = grid[0].length;

        while(coordinatesToVisit.size() > 0) {
            var currentCoordinate = coordinatesToVisit.poll();

            if (visitedCoordinates.contains(currentCoordinate)) {
                continue;
            }

            visitedCoordinates.add(currentCoordinate);

            var neighbours = List.of(new Coordinate(currentCoordinate.x - 1, currentCoordinate.y),
                    new Coordinate(currentCoordinate.x + 1, currentCoordinate.y),
                    new Coordinate(currentCoordinate.x, currentCoordinate.y - 1),
                    new Coordinate(currentCoordinate.x, currentCoordinate.y + 1));

            neighbours.forEach(coordinate -> {
                if(isValid(coordinate, width, height) &&
                        isIsland(grid[coordinate.x][coordinate.y])) {
                    coordinatesToVisit.add(coordinate);
                }
            });
        }
    }

    private boolean isValid(Coordinate coordinate, int width, int height) {
        return coordinate.x >= 0 && coordinate.y >= 0 && coordinate.x < height && coordinate.y < width;
    }

    private boolean isIsland(char cell) {
        return cell == '1';
    }

    private record Coordinate(int x, int y) {}
}