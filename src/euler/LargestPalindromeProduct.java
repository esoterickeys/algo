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

import java.util.*;

/**
 *
 */
public class LargestPalindromeProduct {

    public int largestPalindromeProduct() {
        int largest = 0;

        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                int product = i * j;

                List<Integer> backward = new LinkedList<Integer>();

                int multiplier = product;

                while (multiplier > 0) {
                    backward.add(multiplier % 10);

                    multiplier /= 10;
                }

                List<Integer> forward = backward.subList(0, backward.size());

                Collections.reverse(forward);

                boolean isMatch = true;

                for (int k = 0; k < forward.size(); k++) {
                    if (forward.get(k).intValue() != backward.get(backward.size() - k - 1).intValue()) {
                        isMatch = false;

                        break;
                    }
                }

                if (isMatch && (product > largest)) {
                    largest = product;
                }
            }
        }

        return largest;
    }
}
