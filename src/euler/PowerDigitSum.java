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

import java.math.BigInteger;

/**
 *
 */
public class PowerDigitSum {


    public String sum() {
        BigInteger powerVal = new BigInteger("2");

        powerVal = powerVal.pow(1000);

        char[] digits = powerVal.toString().toCharArray();

        BigInteger sum = new BigInteger("0");

        for (int i = 0; i < digits.length; i++) {
            sum = sum.add(new BigInteger(String.valueOf(digits[i])));
        }

        return sum.toString();
    }
}
