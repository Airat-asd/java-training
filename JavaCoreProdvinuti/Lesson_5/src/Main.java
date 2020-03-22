import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static final int SIZE = 10;
    static final int THREAD = 2;
    static final int HALF = SIZE / THREAD;

    public static void main(String[] args) {
        Main meth1 = new Main();
        Main meth2 = new Main();
        System.out.println("Метод 1:");
        meth1.method1();
        System.out.println("Метод 2:");
        meth2.method2();
    }

    public void method1() {
        float[] arr1 = new float[SIZE];
        Arrays.fill(arr1, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.out.println("Метод1 arr["+i+"]="+arr1[i]);

        }
        System.out.println("Метод1: Время заполения - " + (System.currentTimeMillis() - a));
//        System.out.println("Метод1 arr[0] "+arr1[0]);
//        System.out.println("Метод1 arr["+HALF+"] "+arr1[HALF]);
    }

    public static void method2() {
        float[] arr2 = new float[SIZE];
        float[] arr2inc = new float[HALF];
        ArrayList<MyRunnable> function = new ArrayList<>();
        Thread[] t = new Thread[THREAD];
        Arrays.fill(arr2, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < THREAD; i++) {
            for (int j = 0; j < HALF; j++) {
                arr2inc[j] = arr2[j + HALF * i];
            }
            function.add(new MyRunnable(arr2inc, i, HALF));
        }
//        for (int i = 0; i < THREAD; i++) {
//            function.add(new MyRunnable(arr2inc, i, HALF));
//        }
        for (int i = 0; i < THREAD; i++) {
            t[i] = new Thread(function.get(i));
            t[i].start();
        }
//        MyRunnable function1 = new MyRunnable(arr2inc1, 0);
//        MyRunnable function2 = new MyRunnable(arr2inc2, HALF);
//        Thread t1 = new Thread(function1);
//        Thread t2 = new Thread(function2);
//        t1.start();
//        t2.start();
        try {
            t[0].join();
            t[1].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(function.get(0).getArr2inc(), 0, arr2, 0, HALF);
//        for (int i = 0; i < THREAD; i++) {
//            for (int j = 0; j < HALF; j++) {
//                arr2[j + HALF * i] = arr2inc[i][j];
//            }
//        }
        System.out.println("Метод2: Время заполения - " + (System.currentTimeMillis() - a));
    }
}
