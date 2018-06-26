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

import org.junit.Test;
import types.search.Vertex;

import java.util.LinkedHashSet;
import java.util.Set;

public class SearchTest {
    int vertexId = 0;
    int finalVertexId = 50;
    int numberChildren = 5;

    @Test
    public void testBfs() {
        Vertex origin = new Vertex(vertexId++);

        buildTree(origin);

        BreadthFirstSearch bfs = new BreadthFirstSearch(origin);

        bfs.execute(44);
    }

    @Test
    public void testDfs() {
        Vertex origin = new Vertex(vertexId++);

        buildTree(origin);

        DepthFirstSearch bfs = new DepthFirstSearch(origin);

        bfs.execute(44);
    }

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
