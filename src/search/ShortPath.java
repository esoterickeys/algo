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

import types.path.Graph;
import types.path.Line;
import types.path.Point;

import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.abs;

/**
 * Implementation of Dijkstra's Algorithm. Based on a Cartesian coordinate graph, points with connecting lines represent
 * a physical graph. The connections allow bi-directional travel between the points. Upon execution, the algorithm seeks the
 * shortest path between two supplied point IDs. The approach is greedy, finding each possible path between the source and
 * target points. These paths are described as sets of points where the algorithm hops between each point and loads into the path.
 * Paths are compared during execution of the algorithm to determine the shortest set of hops.
 */
public class ShortPath {

    // Final copy of graph containing points and lines
    private final Graph graph;

    // Local copies of the graphs points and lines
    private Set<Point> points;
    private Set<Line> lines;

    // Cached initial point
    private Point sourcePoint;

    // Cached target point ID
    private int targetPointId;

    // Ordered sets of paths between the source and target points
    private Set<Point> currentPath;
    private Set<Point> optimalPath;

    /**
     * Loader constructor with input for the graph.
     *
     * @param graph
     */
    public ShortPath(Graph graph) {
        this.graph = graph;
    }

    /**
     * Initializes class members with source and target point IDs. Executes the recursive path finding algorithm, and
     * prints the optimal path found.
     *
     * @param sourcePointId
     * @param targetPointId
     * @throws Exception
     */
    public void execute(int sourcePointId, int targetPointId) {
        initialize(sourcePointId, targetPointId);

        long start = System.nanoTime();

        findPathFromPoint(sourcePoint);

        long finish = System.nanoTime();

        printPath();

        System.out.println("Algorithm processed graph in " + String.valueOf(finish - start) + " [ns].");
    }

    /**
     * Loads local points and lines from graph, and initializes the ordered path sets. Identifies the source point object
     * from the ID and adds it as the root point in the current path.
     *
     * @param sourcePointId
     * @param targetPointId
     */
    private void initialize(int sourcePointId, int targetPointId) {
        points = new HashSet<Point>(graph.getPoints());
        lines = new HashSet<Line>(graph.getLines());

        currentPath = new LinkedHashSet<>();
        optimalPath = new LinkedHashSet<>();

        for (Point point : points) {
            if (point.getId() == sourcePointId) {
                sourcePoint = point;
                currentPath.add(sourcePoint);

                break;
            }
        }

        this.targetPointId = targetPointId;
    }

    /**
     * Recursive method to travel point to point via connecting lines. First finds all points connected to the current point.
     * For the adjacent points, checks if the path already contains this point in order to avoid back-tracking and infinite recursion.
     * If the point is new in the current path, add it and check if it is the target point. If the target point is reached, check if the
     * total distance of the current path is less than the optimal (if it exists). Once the target point is reached, the algorithm does
     * not move beyond the target. This causes a roll up to the previous point, to check other branches and their path distance to the target.
     * If the target point is not reached, the algorithm calls itself again walking to the next new point in the path. After each
     * point is processed in their respective frame, remove it from the current path before rolling up to the previous point in the path.
     *
     * @param current
     */
    private void findPathFromPoint(Point current) {
        Set<Point> localPoints = findConnectingPoints(current);

        for (Point localPoint : localPoints) {
            if (!currentPath.contains(localPoint)) {
                currentPath.add(localPoint);

                if (localPoint.getId() == targetPointId) {
                    if (optimalPath.size() == 0) {
                        optimalPath = new LinkedHashSet<>(currentPath);
                    } else if (findDistance(currentPath) < findDistance(optimalPath)) {
                        optimalPath = new LinkedHashSet<>(currentPath);
                    }
                } else {
                    findPathFromPoint(localPoint);
                }

                currentPath.remove(localPoint);
            }
        }
    }

    /**
     * For a given point, finds the local connected points from the cached lines and points. Returns a set of points adjacent to the
     * given point.
     *
     * @param current
     * @return
     */
    private Set<Point> findConnectingPoints(Point current) {
        Set<Line> localConnections = findLocalConnections(current);
        Set<Point> localPoints = new HashSet<>();

        for (Line localConnection : localConnections) {
            for (Point point : points) {
                if (!localPoints.contains(point) && !sourcePoint.equals(point) && (point.getId() == localConnection.getSourceId() || point.getId() == localConnection.getTargetId())) {
                    localPoints.add(point);

                    break;
                }
            }
        }

        return localPoints;
    }

    /**
     * For a given point, finds the local connecting lines from the cached lines.
     *
     * @return
     */
    private Set<Line> findLocalConnections(Point current) {
        Set<Line> localConnections = new HashSet<>();

        for (Line line : lines) {
            if (!localConnections.contains(line) && (line.getSourceId() == current.getId() || line.getTargetId() == current.getId())) {
                localConnections.add(line);
            }
        }

        return localConnections;
    }

    /**
     * Calculates the cartesian distance between two Cartesian points. The set of points is ordered from source to target, with each
     * linear hop in between. The total distance is calculated as the sum of each line length in the path.
     *
     * @param path
     * @return
     */
    private double findDistance(Set<Point> path) {
        double totalLength = 0;

        Point[] pointIter = path.toArray(new Point[path.size()]);

        for (int i = 0; i < path.size() - 1; i++) {
            totalLength += Math.sqrt(Math.pow(abs((double) (pointIter[i].getX() - pointIter[i + 1].getX())), 2) + Math.pow(abs((double) (pointIter[i].getY() - pointIter[i + 1].getY())), 2));
        }

        return totalLength;
    }

    /**
     * String builder based system logging, to print the optimal paths and their distances.
     */
    private void printPath() {
        StringBuilder sb = new StringBuilder();

        sb.append("Optimal Path: ");

        for (Point point : optimalPath) {
            sb.append(" P(" + point.getId() + ") ");
        }

        DecimalFormat format = new DecimalFormat("#.##");

        sb.append("With Distance: " + format.format(findDistance(optimalPath)) + " units.");

        System.out.println(sb.toString());
    }
}
