package competitor;

import competitor.CompetitorInterface;

public class CompetitorParentClass implements CompetitorInterface {
    private String type;
    private String name;
    private int maxRunDistance;
    private int maxJumpDistance;
    private int maxSwimDistance;
    private boolean onDistance;

    public CompetitorParentClass(String type, String name, int maxRunDistance, int maxJumpDistance, int maxSwimDistance, boolean onDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    public CompetitorParentClass(String type, String name, int maxRunDistance, int maxJumpDistance, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }
    public CompetitorParentClass(String name, int maxRunDistance, int maxJumpDistance, int maxSwimDistance, boolean onDistance) {
        this.type = null;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    public CompetitorParentClass(String name, int maxRunDistance, int maxJumpDistance, int maxSwimDistance) {
        this.type = null;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public void run(int distance) {
        if (distance <= maxRunDistance) {
            if (type != null)
                System.out.println(type + " " + name + " успешно пробежал дистанцию " + distance + " м.");
            else System.out.println(name + " успешно пробежал дистанцию " + distance + " м.");
        }
        else {
            if (type != null)
            System.out.println(type + " " + name + " не справился с дистанцией " + distance + " м.");
        else System.out.println(name + " не справился с дистанцией " + distance + " м.");


        }
    }

    @Override
    public void swim(int distance) {
        if (maxSwimDistance == 0) {
            if (type != null)
                System.out.println(type + " " + name + " не умеет плавать.");
            else System.out.println(name + " не умеет плавать.");
            onDistance = false;
            return;
        }
        if (distance <= maxRunDistance) {
            if (type != null)
                System.out.println(type + " " + name + " успешно проплыл дистанцию " + distance + " м.");
            else System.out.println(name + " успешно проплыл дистанцию " + distance + " м.");
        }

    }

    @Override
    public void jump(int distance) {

    }

    @Override
    public boolean isOnDistance() {
        return false;
    }

    @Override
    public void showResult() {
        if (type != null) System.out.println(type + " " + name + " прошел дистанцию: " + onDistance);
        else System.out.println(name + " прошел дистанцию: " + onDistance);
    }

    @Override
    public void infoCompetitor() {
        if (type != null) System.out.println(type + " " + name);
        else System.out.println(name);
    }


}
