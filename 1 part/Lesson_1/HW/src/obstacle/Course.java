package obstacle;

import competitor.CompetitorInterface;
import competitor.CompetitorParentClass;

public class Course {
    private ObstacleParentClass[] obstacle;

    public Course(ObstacleParentClass[] obstacle) {
        this.obstacle = obstacle;
    }

    public void doIt(Team team) {
        System.out.println("*************************");
        for (ObstacleParentClass a: obstacle) {
            for (CompetitorInterface c: team.getCompetitor()) {
                a.doIt(c);
            }
        }

    }
}
