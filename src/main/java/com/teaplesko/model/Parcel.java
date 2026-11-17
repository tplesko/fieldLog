package com.teaplesko.model;

public class Parcel {
    private Long id;
    private final String name;
    private final double area;
    private Crop crop;

    public Parcel(String name, double area, Crop crop){
        if (area <= 0){
            throw new IllegalArgumentException("Area must be greater than 0.");
        }

        if (name == null){
            throw new IllegalArgumentException("Name cannot be null.");
        }

        String trimmedName = name.strip();

        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = trimmedName;
        this.area = area;
        this.crop = requireValidCrop(crop);

    }

    private static Crop requireValidCrop(Crop crop) {
        if (crop == null){
            throw new IllegalArgumentException("Crop cannot be null.");
        }
        return crop;
    }

    public void setCrop(Crop crop){
        this.crop = requireValidCrop(crop);
    }

    public void setId(Long id){
        if (id == null){
            throw new IllegalArgumentException("Id cannot be null.");
        }
        if (this.id != null){
            throw new IllegalStateException("Id is already set.");
        }

        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public Crop getCrop() {
        return crop;
    }
}
