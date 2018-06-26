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

import types.search.Vertex;

import java.util.LinkedHashSet;
import java.util.Set;

public class BreadthFirstSearch {

    private Vertex origin;

    private int targetVertexId;

    private StringBuilder sb;

    private boolean targetFound = false;

    public BreadthFirstSearch(Vertex origin) {
        this.origin = origin;
    }

    public void execute(int targetVertexId) {
        this.targetVertexId = targetVertexId;

        sb = new StringBuilder();
        sb.append("Vertex Search Pattern: {");

        Set<Vertex> originSet = new LinkedHashSet<>();
        originSet.add(origin);

        bfs(originSet);

        System.out.print(sb.toString());
    }

    private void bfs(Set<Vertex> vertices) {
        Set<Vertex> children = new LinkedHashSet<>();

        for (Vertex v : vertices) {
            if (v.getId() == targetVertexId) {
                sb.append(v.getId() + "} END.");
                targetFound = true;
                break;
            } else {
                sb.append(v.getId() + ", ");
                children.addAll(v.getChildren());
            }
        }

        if (!targetFound) {
            bfs(children);
        }
    }
}
