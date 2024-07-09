package org.example;



import java.util.Arrays;
import java.util.List;

public class Main {
    private static final int SIMULATION_COUNT = 10000;

    public static void main(String[] args) {
        List<Strategy> strategies = Arrays.asList(
                Strategy.RANDOM,
                Strategy.TWO_PLATOONS,
                Strategy.THREE_PLATOONS,
                Strategy.FOUR_PLATOONS
        );

        double[][] winRates = new double[strategies.size()][strategies.size()];

        for (int i = 0; i < strategies.size(); i++) {
            for (int j = 0; j < strategies.size(); j++) {
                int winsTeam1 = 0;
                int winsTeam2 = 0;

                for (int k = 0; k < SIMULATION_COUNT; k++) {
                    Team team1 = new Team(strategies.get(i));
                    Team team2 = new Team(strategies.get(j));
                    Battle battle = new Battle(team1, team2);
                    String result = battle.start();

                    if (result.equals("Team 1 wins")) {
                        winsTeam1++;
                    } else if (result.equals("Team 2 wins")) {
                        winsTeam2++;
                    }
                }

                winRates[i][j] = (double) winsTeam1 / SIMULATION_COUNT;
            }
        }

        double maxWinRate = 0;
        int bestStrategyIndex1 = -1;
        int bestStrategyIndex2 = -1;

        for (int i = 0; i < strategies.size(); i++) {
            for (int j = 0; j < strategies.size(); j++) {
                if (winRates[i][j] > maxWinRate) {
                    maxWinRate = winRates[i][j];
                    bestStrategyIndex1 = i + 1;
                    bestStrategyIndex2 = j + 1;
                }
            }
        }


        // Минимальная разница в эффективности.
        double minDifference = Double.MAX_VALUE;
        int minDiffStrategy1 = -1;
        int minDiffStrategy2 = -1;
        for (int i = 0; i < strategies.size(); i++) {
            for (int j = i + 1; j < strategies.size(); j++) {
                double difference = Math.abs(winRates[i][j] - winRates[j][i]);
                if (difference < minDifference) {
                    minDifference = difference;
                    minDiffStrategy1 = i;
                    minDiffStrategy2 = j;
                }
            }
        }

        System.out.println("Матрица вероятностей победы:");
        for (double[] row : winRates) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Комбинация стратегий, при которой вероятность победы одной из команд максимальная: " + bestStrategyIndex1 + " " + bestStrategyIndex2);
        System.out.println("Винрейт этой команды: " + maxWinRate);
        System.out.println("Минимальная разница в эффективности у стратегий: " + minDiffStrategy1 + " и " + minDiffStrategy2);
        System.out.println("И сама минимальная разница: " + minDifference);
    }
}

