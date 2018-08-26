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

/**
 *
 */
public class SumSquareDifference {


    public long sumSquareDiff() {
        long sumOfSquares = 0;

        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
        }

        long squareOfSum = 0;

        for (int i = 1; i <= 100; i++) {
            squareOfSum += i;
        }

        squareOfSum = squareOfSum * squareOfSum;

        return squareOfSum - sumOfSquares;
    }
}
