package obstacle;

import competitor.CompetitorInterface;

public class Water extends ObstacleParentClass {
   private int distance;

    public Water(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(CompetitorInterface competitor) {
        competitor.swim(distance);
    }
}
