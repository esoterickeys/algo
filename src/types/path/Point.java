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
package types.path;

/**
 * Contains information describing a point in a graph.
 */
public class Point implements Comparable<Point> {

    // ID of the point
    private int id;

    // X Coordinate
    private int x;

    // Y Coordinate
    private int y;

    /**
     * Default constructor.
     */
    public Point() {
    }

    /**
     * Loader constructor with inputs for id, and coordinates.
     *
     * @param id
     * @param x
     * @param y
     */
    public Point(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public int compareTo(Point o) {
        int diff = this.getId() - o.getId();

        if (diff == 0) {
            diff = this.getX() - o.getX();
        }

        if (diff == 0) {
            diff = this.getY() - o.getY();
        }

        return diff;
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash = Math.multiplyExact(prime, hash) + id;

        return hash;
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Point other = (Point) obj;
        if (getId() != other.getId()) {
            return false;
        }

        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
