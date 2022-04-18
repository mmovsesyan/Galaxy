package com.movsisyan.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Data
@RequiredArgsConstructor
public class Galaxy {
    @NonNull
    private String name;
    private List<Planet> planets = new ArrayList<>();

    public void addPlanet(Planet p) {
        if (findPlanet(p) != -1) {
            throw new IllegalArgumentException("Planet exists " + p);
        }
        planets.add(p);
    }

    public Planet findPlanet(String name) {
        for (Planet p : planets) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public int findPlanet(Planet p) {
        return planets.indexOf(p);
    }

    public String behavior() {
        StringJoiner sj = new StringJoiner(", ");
        for (Planet planet : planets) {
            sj.add(planet.behavior());
        }
        return sj.toString();
    }

    public Planet removePlanet(String name) {
        Planet planet = findPlanet(name);
        if (planet != null) {
            planets.remove(planet);
            return planet;
        }
        return null;
    }

    public boolean removePlanet(Planet p) {
        return planets.remove(p);
    }
}
