import java.util.Arrays;

public class Main {
    static final int SIZE = 3_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        Main meth1 = new Main();
        Main meth2 = new Main();
        meth1.method1();
        meth2.method2();
    }

    public void method1() {
        float[] arr1 = new float[SIZE];
        Arrays.fill(arr1, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Метод1: Время заполения - " + (System.currentTimeMillis()-a));
    }

    public static void method2() {
        float[] arr2 = new float[SIZE];
        float[] arr2inc1 = new float[HALF];
        float[] arr2inc2 = new float[HALF];
        Arrays.fill(arr2, 1);
        long a = System.currentTimeMillis();
        System.arraycopy(arr2, 0, arr2inc1, 0, HALF );
        System.arraycopy(arr2, HALF, arr2inc2, 0, HALF );
        MyRunnable function1 = new MyRunnable(arr2inc1);
        MyRunnable function2 = new MyRunnable(arr2inc2);
        Thread t1 = new Thread(function1);
        Thread t2 = new Thread(function2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(function1.getArr2inc(), 0, arr2, 0, HALF);
        System.arraycopy(function2.getArr2inc(), 0, arr2, HALF, HALF);
        System.out.println("Метод2: Время заполения - " + (System.currentTimeMillis()-a));
    }
}
