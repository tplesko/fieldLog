package com.teaplesko.model;

public enum WorkType {
    MULCHING("Malčiranje"),
    SUBSOILING("Podrivanje"),
    PLOWING("Oranje"),
    CULTIVATING("Grubiranje"),
    SEEDBED_PREPARATION("Sjetvospremanje"),
    ROLLING("Valjanje"),
    SOWING("Sjetva"),
    FERTILIZING("Gnojidba"),
    SPRAYING("Prskanje"),
    HARVESTING("Žetva");

    private final String label;

    WorkType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
