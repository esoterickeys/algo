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
package types;

import java.util.Set;

/**
 * Describes a cartesian coordinate graph with points and lines connecting the points.
 */
public class Graph {

    // Set of points in the graph
    Set<Point> points;

    // Set of lines in the graph
    Set<Line> lines;

    /**
     * Default constructor.
     */
    public Graph() {

    }

    /**
     * Loader constructor with inputs for points and lines.
     *
     * @param points
     * @param lines
     */
    public Graph(Set<Point> points, Set<Line> lines) {
        this.points = points;
        this.lines = lines;
    }

    public Set<Point> getPoints() {
        return points;
    }

    public void setPoints(Set<Point> points) {
        this.points = points;
    }

    public Set<Line> getLines() {
        return lines;
    }

    public void setLines(Set<Line> lines) {
        this.lines = lines;
    }
}
