package euler;

public class LongestCollatz {

    public long findLongestChain() {
        int longestChainCount = 0;
        long longestChainSeed = 0;

        for (int i = 1; i < 1000000; i++) {
            int chainCount = 0;
            long currentSeed = i;

            while (true) {
                chainCount++;

                if (currentSeed == 1) {
                    break;
                }

                if (currentSeed % 2 == 0) {
                    currentSeed = currentSeed / 2;
                } else {
                    currentSeed = (3 * currentSeed) + 1;
                }
            }

            if (chainCount > longestChainCount) {
                longestChainCount = chainCount;
                longestChainSeed = i;
            }
        }

        return longestChainSeed;
    }
}
