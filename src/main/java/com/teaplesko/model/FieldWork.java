package com.teaplesko.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FieldWork {
    private Long id;
    private final Long parcelId;
    private final WorkType workType;
    private final LocalDate workDate;
    private final double hours;
    private final BigDecimal cost;
    private String note;

    public FieldWork(Long parcelId, WorkType workType, LocalDate workDate, double hours, BigDecimal cost, String note) {
        if (parcelId == null) {
            throw new IllegalArgumentException("Parcel id cannot be null.");
        }
        if (workType == null) {
            throw new IllegalArgumentException("Work type cannot be null.");
        }
        if (workDate == null) {
            throw new IllegalArgumentException("Work date cannot be null.");
        }
        if (workDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Work date cannot be in the future.");
        }
        if (hours <= 0) {
            throw new IllegalArgumentException("Hours must be greater than 0.");
        }
        if (cost == null) {
            throw new IllegalArgumentException("Cost cannot be null.");
        }
        if (cost.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Cost must be greater than 0.");
        }

        this.parcelId = parcelId;
        this.workType = workType;
        this.workDate = workDate;
        this.hours = hours;
        this.cost = cost;
        this.note = normalizeNote(note);
    }

    public void setId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (this.id != null) {
            throw new IllegalStateException("ID is already set.");
        }
        this.id = id;
    }

    public void setNote(String note) {
        this.note = normalizeNote(note);
    }

    public Long getId() {
        return id;
    }

    public Long getParcelId() {
        return parcelId;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public LocalDate getWorkDate() {
        return workDate;
    }

    public double getHours() {
        return hours;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getNote() {
        return note;
    }

    private static String normalizeNote(String note) {
        if (note == null) {
            return null;
        }
        String trimmedNote = note.strip();
        return trimmedNote.isEmpty() ? null : trimmedNote;
    }
}
