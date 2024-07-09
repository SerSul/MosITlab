package org.example;

import java.util.List;
import java.util.Random;

public enum Strategy {
    RANDOM { //Пьяный командир
        @Override
        public void execute(List<Gun> ourGuns, List<Gun> enemyGuns) {
            Random random = new Random();
            for (Gun gun : ourGuns) {
                if (!gun.isDestroyed()) {
                    int targetIndex = random.nextInt(enemyGuns.size());
                    if (random.nextDouble() < 0.1) {
                        enemyGuns.get(targetIndex).destroy();
                    }
                }
            }
        }
    },
    TWO_PLATOONS { //Два взвода
        @Override
        public void execute(List<Gun> ourGuns, List<Gun> enemyGuns) {
            Random random = new Random();
            int size = ourGuns.size() / 2;
            for (int i = 0; i < 2; i++) {
                int targetIndex = random.nextInt(enemyGuns.size());
                for (int j = i * size; j < (i + 1) * size; j++) {
                    if (!ourGuns.get(j).isDestroyed() && random.nextDouble() < 0.1) {
                        enemyGuns.get(targetIndex).destroy();
                    }
                }
            }
        }
    },
    THREE_PLATOONS { //Три взвода
        @Override
        public void execute(List<Gun> ourGuns, List<Gun> enemyGuns) {
            Random random = new Random();
            int size = ourGuns.size() / 3;
            for (int i = 0; i < 3; i++) {
                int targetIndex = random.nextInt(enemyGuns.size());
                for (int j = i * size; j < (i + 1) * size; j++) {
                    if (!ourGuns.get(j).isDestroyed() && random.nextDouble() < 0.1) {
                        enemyGuns.get(targetIndex).destroy();
                    }
                }
            }
        }
    },
    FOUR_PLATOONS { //Четыре взвода
        @Override
        public void execute(List<Gun> ourGuns, List<Gun> enemyGuns) {
            Random random = new Random();
            int size = ourGuns.size() / 4;
            for (int i = 0; i < 4; i++) {
                int targetIndex = random.nextInt(enemyGuns.size());
                for (int j = i * size; j < (i + 1) * size; j++) {
                    if (!ourGuns.get(j).isDestroyed() && random.nextDouble() < 0.1) {
                        enemyGuns.get(targetIndex).destroy();
                    }
                }
            }
        }
    };

    public abstract void execute(List<Gun> ourGuns, List<Gun> enemyGuns);
}
