package com.movsisyan.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Planet {
    @NonNull
    private String name;
    @NonNull
    private double radius;
    @NonNull
    private double circulationPeriod;

    public double rotationSpeed() {
        return 2 * Math.PI * radius / circulationPeriod;
    }

    public String behavior() {
        return this.name + " " + rotationSpeed();
    }
}
