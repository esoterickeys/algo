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
package fuzz;

import org.junit.Test;

/**
 * Test class for FuzzBuzz algorithm.
 */
public class FuzzTest  {

    /**
     * Test linear array of 100 elements ranging from 1 to 100.
     */
    @Test
    public void testLinearArray() {
        Fuzz fuzz = new Fuzz();

        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }

        fuzz.execute(array);
    }

    /**
     * Randomly entered small array.
     */
    @Test
    public void testRandomArray() {
        Fuzz fuzz = new Fuzz();

        int[] array = {3, 30, 55, 10, 11, 13, 16, 37, 92, 74, 38, 65, 55, 12, 111};

        fuzz.execute(array);
    }
}