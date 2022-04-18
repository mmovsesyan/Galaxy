package com.movsisyan.model;

import com.movsisyan.util.Generator;

import java.util.ArrayList;
import java.util.List;

public class Universe {
    private List<Galaxy> galaxyList = new ArrayList<>();

    public void addGalaxy(Galaxy galaxy) {
        if (findGalaxy(galaxy) != null) {
            throw new IllegalArgumentException("Galaxy exists " + galaxy);
        }
        galaxyList.add(galaxy);
    }

    public Galaxy findGalaxy(String name) {
        for (Galaxy galaxy : galaxyList) {
            if (galaxy.getName().equalsIgnoreCase(name)) {
                return galaxy;
            }
        }
        return null;
    }

    public int[] findGalaxy(Galaxy g) {
        for (int i = 0; i < galaxyList.size(); i++) {
            if (findGalaxy(g.getName()) != null) {
                int galaxyNumber = galaxyList.indexOf(g);
                return new int[]{galaxyNumber, i};
            }
        }
        return null;
    }

    public Planet findPlanet(String name) {
        for (Galaxy galaxy : galaxyList) {
            Planet planet = galaxy.findPlanet(name);
            if (planet != null) {
                return planet;
            }
        }
        return null;
    }

    public int[] findPlanet(Planet p) {
        for (int i = 0; i < galaxyList.size(); i++) {
            if (galaxyList.get(i).findPlanet(p) >= 0) {
                int planetNumber = galaxyList.get(i).findPlanet(p);
                return new int[]{i, planetNumber};
            }
        }
        return null;
    }

    public void behavior() {
        while (true) {
            try {
                ArrayList<Galaxy> galaxies = Generator.generateGalaxies(10);
                this.galaxyList.addAll(galaxies);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
