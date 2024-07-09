package org.example;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Gun> guns;
    private Strategy strategy;

    public Team(Strategy strategy) {
        this.guns = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            this.guns.add(new Gun());
        }
        this.strategy = strategy;
    }

    public List<Gun> getGuns() {
        return guns;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public boolean hasRemainingGuns() {
        return guns.stream().anyMatch(gun -> !gun.isDestroyed());
    }
}


