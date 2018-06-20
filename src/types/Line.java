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

/**
 * Describes a line within a graph connecting two points.
 */
public class Line implements Comparable<Line> {

    // The ID of the line
    private int id;

    // The first point this line connects between
    private int sourceId;

    // The second point this line connects between
    private int targetId;

    /**
     * Default constructor.
     */
    public Line() {
    }

    /**
     * Loader constructor with inputs for id, and point IDs.
     *
     * @param id
     * @param sourceId
     * @param targetId
     */
    public Line(int id, int sourceId, int targetId) {
        this.id = id;
        this.sourceId = sourceId;
        this.targetId = targetId;
    }

    /**
     * @param o
     * @return
     */
    @Override
    public int compareTo(Line o) {
        int diff = this.getId() - o.getId();

        if (diff == 0) {
            diff = this.getSourceId() - o.getSourceId();
        }

        if (diff == 0) {
            diff = this.getTargetId() - o.getTargetId();
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

        Line other = (Line) obj;
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

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }
}
