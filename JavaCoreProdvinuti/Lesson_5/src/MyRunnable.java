public class MyRunnable implements Runnable {
    private float[] arr2inc;
    private int part, position;

    public MyRunnable(float[] arr2inc, int part, int position) {
        this.arr2inc = arr2inc;
        this.part = part;
        this.position = position;
    }

    @Override
    public void run() {
        for (int i = 0; i < position; i++) {
            arr2inc[i] = (float) (arr2inc[i] * Math.sin(0.2f + (i + part*position) / 5) * Math.cos(0.2f + (i + part*position) / 5) * Math.cos(0.4f + (i + part*position) / 2));
            if (i<5) {
                System.out.println("Часть "+part+" i="+i+" "+(i + part*position)+" - "+ arr2inc[i]);
//                System.out.println("(arr1["+i+"] * Math.sin(0.2f + "+i+" / 5) * Math.cos(0.2f + "+i+ "/ 5) * Math.cos(0.4f + "+i+ "/ 2));");
            }
        }
    }

    public float[] getArr2inc() {
        return arr2inc;
    }
}
