package obstacle;

import competitor.CompetitorInterface;

public class Team {
    private CompetitorInterface[] competitor;
    private String nameTeam;

    public Team(String nameTeam, CompetitorInterface[] competitor) {
        this.competitor = competitor;
        this.nameTeam = nameTeam;
    }

    public CompetitorInterface[] getCompetitor() {
        return competitor;
    }

    public void setCompetitor(CompetitorInterface[] competitor) {
        this.competitor = competitor;
    }

    public void showResults() {
        System.out.println("********************************");
        System.out.println("Результаты команды \"" + nameTeam + "\":");
        for (CompetitorInterface a: competitor) {
            a.showResult();
        }
    }

    public void infoTeam() {
        System.out.println("********************************");
        System.out.println("Информация о команде \"" + nameTeam + "\":");
        for (CompetitorInterface a: competitor) {
            a.infoCompetitor();
        }
    }

}
