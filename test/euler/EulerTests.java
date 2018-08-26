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

import org.junit.Test;

/**
 *
 */
public class EulerTests {

    /**
     *
     */
    @Test
    public void multipleThreeFive() {
        MultiplesThreeFive o = new MultiplesThreeFive();

        int sum = o.findMultiples(1000);

        System.out.println(sum);
    }

    @Test
    public void evenFibonacci() {
        EvenFibonacci o = new EvenFibonacci();

        int sum = o.sumEvenFibonacci();

        System.out.println(sum);
    }

    @Test
    public void largestPrimeFactor() {
        LargestPrimeFactor o = new LargestPrimeFactor();

        long factor = o.largestPrimeFactor(600851475143L);

        System.out.println(factor);
    }

    @Test
    public void largestPalindromeProduct() {
        LargestPalindromeProduct o = new LargestPalindromeProduct();

        long factor = o.largestPalindromeProduct();

        System.out.println(factor);
    }

    @Test
    public void smallestMultiple() {
        SmallestMultiple o = new SmallestMultiple();

        long multiple = o.smallestMultiple();

        System.out.println(multiple);
    }


    @Test
    public void sumSquareDiffeerence() {
        SumSquareDifference o = new SumSquareDifference();

        long diff = o.sumSquareDiff();

        System.out.println(diff);
    }

    @Test
    public void tenThousandPrime() {
        TenThousandPrime o = new TenThousandPrime();

        long prime = o.tenThousandthPrime();

        System.out.println(prime);
    }
}
