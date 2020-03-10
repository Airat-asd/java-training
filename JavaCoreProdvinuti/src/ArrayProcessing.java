public class ArrayProcessing {
    private String[][] array;

    public ArrayProcessing(String[][] array) throws MyArraySizeException {
        if (array.length > 4 || array[0].length > 4) {
            throw new MyArraySizeException();
        } else {
            this.array = array;
        }
    }

    public int processing () throws MyArrayDataException{
        try {
            int s = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    s = s + Integer.parseInt(array[i][j]);
                }
            }
            return s;
        } catch (MyArrayDataException ex) {
            System.out.println("asdasdsd");
        }
        return 0;
    }
}
