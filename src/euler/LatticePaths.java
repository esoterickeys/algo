package euler;

import java.util.HashMap;
import java.util.Map;

public class LatticePaths {

    private Map<Coordinate, Long> cachedVisits = new HashMap<Coordinate, Long>();

    private int gridSize = 20;

    public long findRoutes() {
        return traverse(0, 0);
    }

    private long traverse(int x, int y) {
        Coordinate coord = new Coordinate(x, y);

        if (cachedVisits.containsKey(coord)) {
            return cachedVisits.get(coord);
        }

        if (x == gridSize && y == gridSize) {
            return 1;
        }

        Long count = 0L;

        if (x < gridSize) {
            count += traverse(x + 1, y);
        }

        if (y < gridSize) {
            count += traverse(x, y + 1);
        }

        cachedVisits.put(coord, count);

        return count;
    }

    private class Coordinate {
        public int x;
        public int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }

            if (!(o instanceof Coordinate)) {
                return false;
            }

            if (o == this) {
                return true;
            }

            Coordinate coord = (Coordinate) o;

            return (this.x == coord.x) && (this.y == coord.y);
        }

        @Override
        public int hashCode() {
            int radix = 31;

            return x + y + radix * x * y;
        }
    }
}
