package euler;

public class TenThousandPrime {

    public long tenThousandthPrime() {
        int val;
        int count = 0;

        for (val = 1; count <= 10001; ++val) {
            if (isPrime(val)) {
                System.out.println(val);
                count++;
            }
        }

        return val - 1;
    }

    private boolean isPrime(int num) {
        for (int j = 2; j < num; j++) {
            if (num % j == 0) {
                return false;
            }
        }

        return true;
    }
}
