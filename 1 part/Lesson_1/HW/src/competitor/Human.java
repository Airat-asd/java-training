package competitor;

import competitor.CompetitorParentClass;

public class Human extends CompetitorParentClass {
    public Human(String type, String name, int maxRunDistance, int maxJumpDistance, int maxSwimDistance, boolean onDistance) {
        super(null, name, maxRunDistance, maxJumpDistance, maxSwimDistance, onDistance);
    }
}
