class HelloWorld {
	
	public static void main(String[] args) {
		int a = 5;
		int b;
		b = a + 2;
		System.out.println("Hello World!");
		System.out.println("a+b=" + add(a, b));
	}
	
	static int add(int a1, int b1) {
		return a1 + b1;
	}
}