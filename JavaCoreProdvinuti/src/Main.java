public class Main {

    public static void main(String[] args) {
        String [][] array = {{"1", "2", "3", "s"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        try {
            ArrayProcessing arrayProcessing = new ArrayProcessing(array);
            System.out.println(arrayProcessing.processing());
        } catch (MyArraySizeException | MyArrayDataException ex) {
            System.err.print(ex);
        }


    }
}
