package com.teaplesko.repository;

import com.teaplesko.model.Parcel;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryParcelRepository implements ParcelRepository {

    private final Map<Long, Parcel> parcelMap = new TreeMap<>();
    private final AtomicLong nextId = new AtomicLong(0);

    @Override
    public Parcel save(Parcel parcel) {
        if (parcel == null) {
            throw new IllegalArgumentException("Parcel cannot be null.");
        }
        if (parcel.getId() == null){
            parcel.setId(nextId.incrementAndGet());
        }
        parcelMap.put(parcel.getId(), parcel);
        return parcel;
    }

    @Override
    public Optional<Parcel> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null.");
        }
        return Optional.ofNullable(parcelMap.get(id));
    }

    @Override
    public List<Parcel> findAll() {
        return new ArrayList<>(parcelMap.values());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null){
            throw new IllegalArgumentException("Id cannot be null.");
        }
        parcelMap.remove(id);
    }
}
