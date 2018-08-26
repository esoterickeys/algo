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

package euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Finds sum of all natural numbers that are multiples of 3 OR 5, with the limit of the target.
 */
public class MultiplesThreeFive {

    List<Integer> numbers = new ArrayList<Integer>();

    public int findMultiples(final int TARGET) {
        int sum = 0;

        for (int i = 3; i < TARGET; i += 3) {
            if (!numbers.contains(i)) {
                numbers.add(i);
            }
        }

        for (int i = 5; i < TARGET; i += 5) {
            if (!numbers.contains(i)) {
                numbers.add(i);
            }
        }

        for (Integer num : numbers) {
            sum += num;
        }

        return sum;
    }
}
