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
package types.search;

import java.util.Set;

/**
 * Representation of a node on a tree. Contains an ID and a set of child vertices.
 */
public class Vertex implements Comparable<Vertex> {

    // Non-unique ID
    private int id;

    // Unique list of child vertices
    private Set<Vertex> children;

    /**
     * Loader constructor with parameter for ID.
     *
     * @param id
     */
    public Vertex(int id) {
        this.id = id;
    }


    /**
     * @param o
     * @return
     */
    @Override
    public int compareTo(Vertex o) {
        int diff = this.getId() - o.getId();

        if (diff == 0) {
            diff = this.getChildren().size() - o.getChildren().size();
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
        int size = (children != null) ? children.size() : 0;

        hash = Math.multiplyExact(prime, hash) + id + size;

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

        Vertex other = (Vertex) obj;
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

    public Set<Vertex> getChildren() {
        return children;
    }

    public void setChildren(Set<Vertex> children) {
        this.children = children;
    }
}
