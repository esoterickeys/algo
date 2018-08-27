package euler;

public class SumPrimes {

    public long sumPrimesBelowTwoMillion() {
        long sum = 0;

        boolean[] primeBitMap = new boolean[2000000];
        primeBitMap[0] = false; // 0
        primeBitMap[1] = false; // 1

        for (int i = 2; i <= primeBitMap.length - 1; i++) {
            primeBitMap[i] = true;
        }

        for (int p = 2; p * p <= primeBitMap.length - 1; p++) {
            if (primeBitMap[p] == true) {
                for (int i = 2 * p; i <= primeBitMap.length - 1; i += p) {
                    primeBitMap[i] = false;
                }
            }
        }

        for (int i = 0; i < primeBitMap.length; i++) {
            if (primeBitMap[i] == true) {
                sum += i;
            }
        }

        return sum;
    }
}
