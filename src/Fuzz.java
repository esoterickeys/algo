public class Fuzz {

    public Fuzz() {

    }

    public void execute(int[] array) {
        for(int value : array) {
            if(value % 3 == 0 && value % 5 == 0) {
                System.out.println("FuzzBuzz");

                continue;
            }

            if(value % 3 == 0) {
                System.out.println("Fuzz");

                continue;
            }

            if(value % 5 == 0) {
                System.out.println("Buzz");

                continue;
            }

            System.out.println(String.valueOf(value));
        }
    }
}
