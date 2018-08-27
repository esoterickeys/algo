package euler;

public class PythagoreanTriplet {

    public int findTriplet() {
        for (int a = 1; a <= 1000; a++) {
            for (int b = 1 + a; b <= 1000; b++) {
                int c = 1000 - a - b;

                if ((a + b + c) == 1000) {
                    int a_sqr = a * a;
                    int b_sqr = b * b;
                    int c_sqr = c * c;

                    if ((a_sqr + b_sqr) == c_sqr) {
                        return a * b * c;
                    }
                }
            }
        }

        return 0;
    }
}
