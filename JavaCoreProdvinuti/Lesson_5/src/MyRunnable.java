public class MyRunnable implements Runnable {
    private float[][] arr2pro;
    private int part, position;

    public MyRunnable(float[][] arr2pro, int part, int position) {
        this.arr2pro = arr2pro;
        this.part = part;
        this.position = position;
    }

    @Override
    public void run() {
        for (int i = 0; i < position; i++) {
            arr2pro[part][i] = (float) (arr2pro[part][i] * Math.sin(0.2f + (i + part*position) / 5) * Math.cos(0.2f + (i + part*position) / 5) * Math.cos(0.4f + (i + part*position) / 2));
//            System.out.println("Часть "+part+" i="+i+" "+(i + part*position)+" = "+ arr2pro[part][i]);
        }
    }

    public float[][] getArr2inc() {
        return arr2pro;
    }
}
