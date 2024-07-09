package org.example;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum Strategy {
    RANDOM { // Пьяный командир
        @Override
        public void execute(List<Gun> ourGuns, List<Gun> enemyGuns) {
            Random random = new Random();
            for (Gun gun : ourGuns) {
                if (!gun.isDestroyed()) {
                    List<Gun> availableTargets = enemyGuns.stream().filter(g -> !g.isDestroyed()).collect(Collectors.toList());
                    if (!availableTargets.isEmpty()) {
                        Gun target = availableTargets.get(random.nextInt(availableTargets.size()));
                        if (random.nextDouble() < HIT_PROBABILITY) {
                            target.destroy();
                        }
                    }
                }
            }
        }
    },
    TWO_PLATOONS { // Два взвода
        @Override
        public void execute(List<Gun> ourGuns, List<Gun> enemyGuns) {
            Random random = new Random();
            int half = ourGuns.size() / 2;
            for (int i = 0; i < 2; i++) {
                List<Gun> platoon = ourGuns.subList(i * half, (i + 1) * half);
                List<Gun> availableTargets = enemyGuns.stream().filter(g -> !g.isDestroyed()).collect(Collectors.toList());
                if (!availableTargets.isEmpty()) {
                    Gun target = availableTargets.get(random.nextInt(availableTargets.size()));
                    for (Gun gun : platoon) {
                        if (!gun.isDestroyed() && random.nextDouble() < HIT_PROBABILITY) {
                            target.destroy();
                            break;
                        }
                    }
                }
            }
        }
    },
    THREE_PLATOONS { // Три взвода
        @Override
        public void execute(List<Gun> ourGuns, List<Gun> enemyGuns) {
            Random random = new Random();
            int third = ourGuns.size() / 3;
            for (int i = 0; i < 3; i++) {
                List<Gun> platoon = ourGuns.subList(i * third, (i + 1) * third);
                List<Gun> availableTargets = enemyGuns.stream().filter(g -> !g.isDestroyed()).collect(Collectors.toList());
                if (!availableTargets.isEmpty()) {
                    Gun target = availableTargets.get(random.nextInt(availableTargets.size()));
                    for (Gun gun : platoon) {
                        if (!gun.isDestroyed() && random.nextDouble() < HIT_PROBABILITY) {
                            target.destroy();
                            break;
                        }
                    }
                }
            }
        }
    },
    FOUR_PLATOONS { // Четыре взвода
        @Override
        public void execute(List<Gun> ourGuns, List<Gun> enemyGuns) {
            Random random = new Random();
            int quarter = ourGuns.size() / 4;
            for (int i = 0; i < 4; i++) {
                List<Gun> platoon = ourGuns.subList(i * quarter, (i + 1) * quarter);
                List<Gun> availableTargets = enemyGuns.stream().filter(g -> !g.isDestroyed()).collect(Collectors.toList());
                if (!availableTargets.isEmpty()) {
                    Gun target = availableTargets.get(random.nextInt(availableTargets.size()));
                    for (Gun gun : platoon) {
                        if (!gun.isDestroyed() && random.nextDouble() < HIT_PROBABILITY) {
                            target.destroy();
                            break;
                        }
                    }
                }
            }
        }
    };


    static final double HIT_PROBABILITY = 0.1;

    public abstract void execute(List<Gun> ourGuns, List<Gun> enemyGuns);
}
