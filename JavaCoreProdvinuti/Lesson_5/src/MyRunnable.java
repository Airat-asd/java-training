public class MyRunnable implements Runnable {
private float[] arr2inc;

    public MyRunnable(float[] arr2inc) {
        this.arr2inc = arr2inc;
    }

    @Override
    public void run() {
       for (int i = 0; i < arr2inc.length; i++) {
           arr2inc[i] = (float)(arr2inc[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
       }
    }

    public float[] getArr2inc() {
        return arr2inc;
    }
}
