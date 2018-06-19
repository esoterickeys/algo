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

import types.Graph;
import types.Point;

import static java.lang.Math.abs;

/**
 *
 */
public class ShortPath {
    //
    private Graph graph;

    /**
     * @param graph
     */
    public ShortPath(Graph graph) {
        this.graph = graph;
    }

    /**
     * @param sourcePoint
     * @param targetPoint
     * @throws Exception
     */
    public void execute(int sourcePoint, int targetPoint) throws Exception {
        Point source = null;

        for (Point point : graph.getPoints()) {
            if (point.getId() == sourcePoint) {
                source = point;

                break;
            }
        }

        traverse(source, targetPoint);
    }

    /**
     * @param current
     */
    public void traverse(Point current, int targetPoint) {

        int[] localConnections = current.getLocalConnections();

        Point next;

        for (int localId : localConnections) {
            for (Point point : graph.getPoints()) {
                if (point.getId() == localId) {
                    next = point;

                    double distance = Math.sqrt(Math.pow(abs((double) (current.getX() - next.getX())), 2) + Math.pow(abs((double) (current.getY() - next.getY())), 2));

                    System.out.println("Distance between Point(" + current.getId() + ") and Point(" + next.getId() + "): " + distance);

                    if (next.getId() != targetPoint) {
                        traverse(next, targetPoint);
                    }
                }
            }
        }
    }
}
