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

import java.math.BigInteger;

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

    @Test
    public void largestProductSeries() {
        LargestProductSeries o = new LargestProductSeries();

        BigInteger product = o.largestProductInSeries();

        System.out.println(product.toString());
    }

    @Test
    public void findTriplet() {
        PythagoreanTriplet o = new PythagoreanTriplet();

        int product = o.findTriplet();

        System.out.println(product);
    }

    @Test
    public void sumPrimes() {
        SumPrimes o = new SumPrimes();

        long sum = o.sumPrimesBelowTwoMillion();

        System.out.println(sum);
    }

    @Test
    public void largestProduct() {
        LargestProduct o = new LargestProduct();

        long product = o.largestProduct();

        System.out.println(product);
    }

    @Test
    public void largestDivisibleTriangle() {
        TriangleDivision o = new TriangleDivision();

        long sum = o.largestDivisibleTriangle();

        System.out.println(sum);
    }

    @Test
    public void largeSum() {
        LargeSum o = new LargeSum();

        System.out.println(o.largestProduct());
    }

    @Test
    public void longestCollatz() {
        LongestCollatz o = new LongestCollatz();

        System.out.println(o.findLongestChain());
    }

    @Test
    public void latticePath() {
        LatticePaths o = new LatticePaths();

        System.out.println(o.findRoutes());
    }

    @Test
    public void powerDigitSum() {
        PowerDigitSum o = new PowerDigitSum();

        System.out.println(o.sum());
    }
}
