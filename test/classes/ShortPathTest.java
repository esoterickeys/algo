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
package classes;

import org.junit.Test;
import types.Edge;
import types.Graph;
import types.Point;

import java.util.*;

/**
 * Test class for Short Path algorithm.
 */
public class ShortPathTest {

    /**
     *
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

        Set<Edge> edges = new HashSet<>();
        edges.add(new Edge(0, 0, 1));
        edges.add(new Edge(1, 1, 2));
        edges.add(new Edge(2, 2, 3));
        edges.add(new Edge(3, 1, 5));
        edges.add(new Edge(4, 5, 4));
        edges.add(new Edge(5, 4, 6));
        edges.add(new Edge(6, 3, 6));
        edges.add(new Edge(7, 6, 7));


        Graph graph = new Graph();
        graph.setPoints(points);

        ShortPath sp = new ShortPath(graph);

        try {
            sp.execute(0, 6);
        } catch (Exception e) {
            System.out.println("Failed to traverse points on graph.");
        }
    }
}