package obstacle;

import competitor.CompetitorInterface;

public class Cross extends ObstacleParentClass {
    private int distance;

    public Cross(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(CompetitorInterface competitor) {
        competitor.run(distance);
    }
}
