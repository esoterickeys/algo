package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class CombSortTest {

    private int max = 2000;
    private int size = 100;

    @Test
    public void test() {
        Random rand = new Random();

        int input[] = new int[size];

        for (int i = 0; i < size; i++) {
            input[i] = rand.nextInt(max) - (max / 2);
        }

        CombSort ob = new CombSort();
        int output[] = ob.execute(input);

        System.out.println("Sorted Array");
        for (int i = 0; i < size; i++) {
            System.out.print(output[i] + " ");
        }

        for (int i = 0; i < size - 1; i++) {
            Assert.assertTrue(output[i] <= output[i + 1]);
        }
    }
}
