import competitor.Cat;
import competitor.CompetitorInterface;
import competitor.CompetitorParentClass;
import competitor.Human;
import obstacle.*;

public class MainClass {
    public static void main(String[] args) {
        Team team = new Team("Сборная России", new CompetitorParentClass[]{new Cat("Кот", "Мурзик", 80, 8, 0, true), new Human("Человек", "Василий", 100,5, 50, true)});
        Course c = new Course(new ObstacleParentClass[]{new Cross(100), new Water(50)}); // Создаем полосу препятствий
        team.infoTeam();
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
    }
}
