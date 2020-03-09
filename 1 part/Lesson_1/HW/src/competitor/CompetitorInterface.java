package competitor;

public interface CompetitorInterface {
    void run(int distance);
    void swim(int distance);
    void jump(int distance);
    boolean isOnDistance();
    void showResult();
    void infoCompetitor();
}
