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

/**
 * Solves the following problem:
 *
 * <p>Given an array of positive numbers, print classes.Fuzz if the number is divisible by 3, print Buzz if the number is
 * divisible by 5, print FuzzBuzz if the number is divisible by both, otherwise print the number itself.</p>
 */
public class Fuzz {

    /**
     * Generic constructor.
     */
    public Fuzz() {

    }

    /**
     * Tests the validity of integer array, then exercises FuzzBuzz algorithm.
     *
     * @param array
     */
    public void execute(int[] array) {
        try {
            testArray(array);
        } catch (Exception e) {
            System.out.println("Encountered exception: " + e.getMessage());

            return;
        }

        for (int value : array) {
            if (testFuzzBuzz(value) || testFuzz(value) || testBuzz(value)) {
                continue;
            }

            System.out.println(String.valueOf(value));
        }
    }

    /**
     * Test supplied array for initialization and values.
     *
     * @param array
     * @throws Exception
     */
    private void testArray(int[] array) throws Exception {
        if (array == null) {
            throw new Exception("Null array.");
        }

        for (int value : array) {
            if (value < 0) {
                throw new Exception("Value [" + value + "] is negative.");
            }
        }
    }

    /**
     * Check if value is divisible by 3.
     *
     * @param value
     */
    private boolean testFuzz(int value) {
        if (value % 3 == 0) {
            System.out.println("Fuzz");
            return true;
        }

        return false;
    }

    /**
     * Check if value is divisible by 5.
     *
     * @param value
     */
    private boolean testBuzz(int value) {
        if (value % 5 == 0) {
            System.out.println("Buzz");
            return true;
        }

        return false;
    }

    /**
     * Check if value is divisible by 3 and 5.
     *
     * @param value
     */
    private boolean testFuzzBuzz(int value) {
        if (value % 3 == 0 && value % 5 == 0) {
            System.out.println("FuzzBuzz");
            return true;
        }

        return false;
    }
}
