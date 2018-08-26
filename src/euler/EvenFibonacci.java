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

import java.util.Arrays;

/**
 *
 */
public class EvenFibonacci {


    public int sumEvenFibonacci() {
        int sum = 0;

        int[] window = new int[3];

        window[0] = 1;
        window[1] = 2;
        window[2] = 3;

        while (true) {
            System.out.println(Arrays.toString(window));
            int newNum = window[1] + window[2];

            if (newNum > 4000000) {
                if (window[0] % 2 == 0) {
                    sum += window[0];
                }
                if (window[1] % 2 == 0) {
                    sum += window[1];
                }
                if (window[2] % 2 == 0) {
                    sum += window[2];
                }

                break;
            }

            if (window[0] % 2 == 0) {
                sum += window[0];
            }

            window[0] = window[1];
            window[1] = window[2];
            window[2] = newNum;
        }

        return sum;
    }
}
