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

import org.junit.Test;
import search.BreadthFirstSearch;
import search.DepthFirstSearch;
import types.search.Vertex;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Test class for BFS and DFS algorithms. Contains dynamically programmable tree to test different structures.
 */
public class SearchTest {
    // ID counter for building the tree
    int vertexId = 0;

    // Number of vertices in the tree, watch memory usage!
    int finalVertexId = 1000;

    // The number of children for each constructed vertex in the tree
    int numberChildren = 4;

    // Cached target vertex ID to search for
    int targetVertexId = 899;

    /**
     * Tests Breadth First Search algorithm by finding the target vertex.
     */
    @Test
    public void testBfs() {
        Vertex origin = new Vertex(vertexId++);
        buildTree(origin);

        BreadthFirstSearch bfs = new BreadthFirstSearch(origin);
        bfs.execute(targetVertexId);
    }

    /**
     * Tests Depth First Search algorithm by finding the target vertex.
     */
    @Test
    public void testDfs() {
        Vertex origin = new Vertex(vertexId++);
        buildTree(origin);

        DepthFirstSearch bfs = new DepthFirstSearch(origin);
        bfs.execute(targetVertexId);
    }

    /**
     * Constructs a vertex tree. Ability to customize number of vertices, and children per vertex is integrated.
     *
     * @param v
     */
    private void buildTree(Vertex v) {
        if (vertexId < finalVertexId) {
            Set<Vertex> vertices = new LinkedHashSet<Vertex>();

            for (int j = 0; j < numberChildren; j++) {
                if (vertexId < finalVertexId) {
                    Vertex child = new Vertex(vertexId++);
                    vertices.add(child);
                } else {
                    break;
                }
            }

            for (Vertex child : vertices) {
                buildTree(child);
            }

            v.setChildren(vertices);
        } else {
            v.setChildren(new LinkedHashSet<>());
        }
    }
}
