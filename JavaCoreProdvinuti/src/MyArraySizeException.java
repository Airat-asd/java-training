public class MyArraySizeException extends ArrayIndexOutOfBoundsException {
    public MyArraySizeException() {
        super("Размеры массива превосходят 4х4");
    }
}
