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
import types.Line;
import types.Point;

import java.util.*;

import static java.lang.Math.abs;

/**
 *
 */
public class ShortPath {
    //
    private final Graph graph;

    private Set<Point> points;
    private Set<Line> lines;

    private Point sourcePoint;
    private int targetPointId;

    private Set<Point> currentPath;
    private Set<Point> optimalPath;

    /**
     * @param graph
     */
    public ShortPath(Graph graph) {
        this.graph = graph;
    }

    /**
     * @param sourcePointId
     * @param targetPointId
     * @throws Exception
     */
    public void execute(int sourcePointId, int targetPointId) throws Exception {
        initialize(sourcePointId, targetPointId);

        findPathFromPoint(sourcePoint);

        printPath();
    }

    /**
     * @param sourcePointId
     * @param targetPointId
     */
    private void initialize(int sourcePointId, int targetPointId) {
        points = new HashSet<Point>(graph.getPoints());
        lines = new HashSet<Line>(graph.getLines());

        sourcePoint = null;

        currentPath = new LinkedHashSet<>();
        optimalPath = new LinkedHashSet<>();

        for (Point point : points) {
            if (point.getId() == sourcePointId) {
                sourcePoint = point;

                break;
            }
        }

        this.targetPointId = targetPointId;

        currentPath.add(sourcePoint);
    }

    /**
     * @param current
     */
    private void findPathFromPoint(Point current) {
        Set<Line> localConnections = new HashSet<>();

        for (Line line : lines) {
            if (!localConnections.contains(line) && (line.getSourceId() == current.getId() || line.getTargetId() == current.getId())) {
                localConnections.add(line);
            }
        }

        Set<Point> localPoints = new HashSet<>();

        for (Line localConnection : localConnections) {
            for (Point point : points) {
                if (!localPoints.contains(point) && !sourcePoint.equals(point) && (point.getId() == localConnection.getSourceId() || point.getId() == localConnection.getTargetId())) {
                    localPoints.add(point);

                    break;
                }
            }
        }

        for (Point localPoint : localPoints) {
            if (!currentPath.contains(localPoint)) {
                currentPath.add(localPoint);

                if (localPoint.getId() == targetPointId) {
                    StringBuilder sb = new StringBuilder();

                    sb.append("Arrived at Target Point:");

                    for (Point point : currentPath) {
                        sb.append(" P(" + point.getId() + ") ");
                    }

                    //System.out.println(sb.toString());

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
     *
     */
    private void printPath() {
        StringBuilder sb = new StringBuilder();

        sb.append("Optimal Path:");

        for (Point point : optimalPath) {
            sb.append(" P(" + point.getId() + ") ");
        }

        System.out.println(sb.toString());
        System.out.println("Optimal Distance: " + findDistance(optimalPath) + " units.");
    }
}
