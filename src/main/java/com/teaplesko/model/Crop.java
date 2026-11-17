package com.teaplesko.model;

public enum Crop {
    CORN("Kukuruz"),
    WHEAT("Pšenica"),
    SUNFLOWER("Suncokret"),
    RAPESEED("Uljana repica");

    private final String label;

    Crop(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
