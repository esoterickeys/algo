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
package sort;

public class CombSort {

    public CombSort() {

    }

    public int[] execute(int input[]) {
        int winRatioNumerator = 30;
        int winRatioDenominator = 10;

        int window = (input.length / (winRatioNumerator / winRatioDenominator));

        boolean exec = true;

        while (exec) {
            System.out.println("Current window: " + window);

            int partialSort[] = input.clone();

            for (int i = 0; i < input.length; i++) {
                if (i + window > input.length - 1) {
                    break;
                } else if (input[i + window] < input[i]) {
                    partialSort[i] = input[i + window];
                    partialSort[i + window] = input[i];
                }
            }

            input = partialSort.clone();
            window--;

            if (window < 1) {
                exec = false;
            }
        }

        return input;
    }

}
