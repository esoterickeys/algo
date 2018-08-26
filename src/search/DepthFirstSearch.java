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

import types.search.Vertex;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Searches through a tree set of vertices, starting from the 0th vertex, for the vertex with the given target ID.
 * For each given vertex, each child is checked linearly. Each Nth child layer below the given vertex is checked causing
 * the algorithm to explore the limit of each path within a branch before moving to the next parallel branch.
 */
public class DepthFirstSearch {

    // The 0th vertex within the tree
    private Vertex origin;

    // The ID of the vertex to find
    private int targetVertexId;

    // Ordered cache of visited vertices for post process validation
    private StringBuilder sb;

    // Termination trigger for the recursive algorithm
    private boolean targetFound = false;

    /**
     * Loader constructor with input parameter for the 0th vertex.
     *
     * @param origin
     */
    public DepthFirstSearch(Vertex origin) {
        this.origin = origin;
    }

    /**
     * Initializes the class members, executes the recursive DFS algorithm, and writes to console the ordered set
     * of visits the algorithm took to reach the target.
     *
     * @param targetVertexId
     */
    public void execute(int targetVertexId) {
        initialize(targetVertexId);

        Set<Vertex> originSet = new LinkedHashSet<>();
        originSet.add(origin);

        dfs(originSet);

        writeVisitation();
    }

    /**
     * Caches the target vertex ID, resets the algorithm termination trigger, and initiates the string containing visited vertices.
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
     * Recursive Depth First Search - the input vertices are the child vertices of a single parent. For each vertex check
     * if the target has been found other break the current loop. If the target is not found, check if this vertex is the
     * target vertex. If it is, trigger the target found rolling up the call stack. If the target is not reached,
     * recursively call dfs() with the list of children from the current vertex.
     *
     * @param vertices
     */
    private void dfs(Set<Vertex> vertices) {
        for (Vertex v : vertices) {
            if (!targetFound) {
                if (v.getId() != targetVertexId) {
                    sb.append(v.getId() + ", ");
                    dfs(v.getChildren());
                } else {
                    sb.append(v.getId() + "} END.");
                    targetFound = true;
                    break;
                }
            } else {
                break;
            }
        }
    }

    /**
     * Simple console write of vertices visited.
     */
    private void writeVisitation() {
        System.out.print(sb.toString());
    }
}
