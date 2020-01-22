class Movie {
	String title;
	String genre;
	int rating;
	void plaIt() {
		if (title == null) {
			System.out.println("Проигрывание фильма без названия");
		} else {
			System.out.println("Проигрывание фильма "+title);
			}
	}
}