public class Word {
	public static void main (String[] args) {
	String[] wordListOne = {"круглосуточный", "трёх-звенный", "3000-футовый", "взаимный", "обоюдный выигрышь", "фронтэнд", "на основе веб-технологий", "проникающий", "умный", "шесть сигм", "метод критического пути", "динамичный"};
	
	String[] wordListTwo = {"уполномоченный", "трудный", "чистый продукт", "ориентированный", "центральный", "распределенный", "кластеризованный", "сетевой"};
	
	String[] wordListThree = {"процесс", "пункт разгрузки", "выход из положение", "тип структуры", "талант", "подход", "портал", "период времени"};
	
	int oneLength = wordListOne.length;
	int twoLength = wordListTwo.length;
	int threeLength = wordListThree.length;
	
	int rand1 = (int) (Math.random() * oneLength);
	int rand2 = (int) (Math.random() * twoLength);
	int rand3 = (int) (Math.random() * threeLength);
	double rand4 = (int) (Math.random()*3);
	
	String phrase = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
	System.out.println("Все, что нам нужно, - это " + phrase);
	System.out.println("oneLength="+oneLength);
	System.out.println("twoLength="+twoLength);
	System.out.println("threeLength="+threeLength);
	System.out.println("rand1="+rand1);
	System.out.println("rand2="+rand2);
	System.out.println("rand3="+rand3);
	}
}