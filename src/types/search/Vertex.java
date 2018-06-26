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

public class Vertex implements Comparable<Vertex> {

    private int id;

    private Set<Vertex> children;

    public Vertex(int id) {
        this.id = id;
    }


    /**
     * @param o
     * @return
     */
    @Override
    public int compareTo(Vertex o) {
        return this.getId() - o.getId();
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
