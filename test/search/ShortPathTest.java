/**
 * Copyright (C) 2018 esoterickeys
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package search;

import org.junit.Test;
import search.ShortPath;
import types.path.Line;
import types.path.Graph;
import types.path.Point;

import java.util.*;

/**
 * Test class for Short Path algorithm.
 */
public class ShortPathTest {

    /**
     * Tests a set of 8 points with 9 inter-connecting lines, challenges the algorithm with every combination.
     */
    @Test
    public void testGraph() {
        Set<Point> points = new HashSet<>();
        points.add(new Point(0, 1, 1));
        points.add(new Point(1, 2, 5));
        points.add(new Point(2, 5, 4));
        points.add(new Point(3, 4, 1));
        points.add(new Point(4, 3, 2));
        points.add(new Point(5, 2, 4));
        points.add(new Point(6, 4, 3));
        points.add(new Point(7, 5, 5));

        Set<Line> lines = new HashSet<>();
        lines.add(new Line(0, 0, 1));
        lines.add(new Line(1, 1, 2));
        lines.add(new Line(2, 2, 3));
        lines.add(new Line(3, 1, 5));
        lines.add(new Line(4, 5, 4));
        lines.add(new Line(5, 4, 6));
        lines.add(new Line(6, 3, 6));
        lines.add(new Line(7, 6, 7));
        lines.add(new Line(8, 1, 7));


        Graph graph = new Graph();
        graph.setPoints(points);
        graph.setLines(lines);

        ShortPath sp = new ShortPath(graph);

        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (i == j) {
                    continue;
                }

                sp.execute(i, j);
            }
        }

    }
}