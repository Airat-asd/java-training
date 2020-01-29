public class HW2Lesson {
	public static void main (String[] args) {
		arrLessThan6();
		squareArray();
		arrayMinElement();
	}

	public static void arrLessThan6 () {
		int [] arr = {1,5,3,2,11,4,5,2,4,8,9,1};
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 6) arr[i] *= 2;
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");
		System.out.println("-------------------");
	}

	public static void squareArray() {
		int[] [] arr = new int [10] [10];
		for (int i = 0; i <10; i++) {
			for (int j = 0; j <10; j++){
				if (i == j) arr[i][j] = 1;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		System.out.println("-------------------");
	}

	public static void arrayMinElement(){
		int[] arr = {-1,5,3,2,11,4,5,2,4,8,9,25};
		int min, max;
		min = max = arr[0];
			for (int i = 1; i< arr.length; i++) {
				if (min > arr[i]) min = arr[i];
				if (max < arr[i]) max = arr[i];
			}
		System.out.println ("min = " + min);
		System.out.println ("max = " + max);
		System.out.println("-------------------");
	}

}