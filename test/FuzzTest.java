import org.junit.Test;

public class FuzzTest  {

    @Test
    public void execute() {
        Fuzz fuzz = new Fuzz();

        int[] array = new int[100];

        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }

        fuzz.execute(array);
    }
}