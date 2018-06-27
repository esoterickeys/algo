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

/**
 * Searches through a tree set of vertices, starting from the 0th vertex, for the vertex with the given target ID.
 * Checks each layer of child vertices for each Nth layer of children, then moves to the next layer of child vertices.
 */
public class BreadthFirstSearch {

    // The 0th vertex in the tree
    private Vertex origin;

    // Target ID of the vertex being searched for
    private int targetVertexId;

    // Ordered cache of visited vertices for post process validation
    private StringBuilder sb;

    // Trigger to terminate the recursion when the target vertex is found
    private boolean targetFound = false;

    /**
     * Loader constructor with parameter for the 0th vertex.
     *
     * @param origin
     */
    public BreadthFirstSearch(Vertex origin) {
        this.origin = origin;
    }

    /**
     * Initializes the class members, starts the recursive BFS algorithm.
     *
     * @param targetVertexId
     */
    public void execute(int targetVertexId) {
        initialize(targetVertexId);

        Set<Vertex> originSet = new LinkedHashSet<>();
        originSet.add(origin);

        bfs(originSet);
    }

    /**
     * Caches the target vertex ID, resets the BFS termination trigger, and initiates the string containing visited vertices.
     *
     * @param targetVertexId
     */
    private void initialize(int targetVertexId) {
        this.targetVertexId = targetVertexId;
        targetFound = false;

        sb = new StringBuilder();
        sb.append("Vertex Search Pattern: {");
    }

    /**
     * Recursive Breadth First Search - the input vertices are all at the same layer order. For each vertex, check
     * if this vertex is the target. If the target has been found, terminate the algorithm and write the final visit to
     * cache. If the targeet has not been found, recursively call bfs() with all children of the given layer of vertices.
     *
     * @param vertices
     */
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

        // Termination check
        if (!targetFound) {
            bfs(children);
        }
    }

    /**
     * Simple console write of vertices visited.
     */
    private void writeVisitation() {
        System.out.print(sb.toString());
    }
}
