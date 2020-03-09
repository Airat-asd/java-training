package obstacle;

import competitor.CompetitorInterface;

public abstract class ObstacleParentClass implements ObstacleInterface {

    @Override
    public abstract void doIt(CompetitorInterface competitor);
}
