package org.example;

public class Battle {
    private Team team1;
    private Team team2;

    public Battle(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public String start() {
        while (team1.hasRemainingGuns() && team2.hasRemainingGuns()) {
            team1.getStrategy().execute(team1.getGuns(), team2.getGuns());
            team2.getStrategy().execute(team2.getGuns(), team1.getGuns());
        }
        if (!team1.hasRemainingGuns() && !team2.hasRemainingGuns()) {
            return "Draw";
        }
        return team1.hasRemainingGuns() ? "Team 1 wins" : "Team 2 wins";
    }
}

