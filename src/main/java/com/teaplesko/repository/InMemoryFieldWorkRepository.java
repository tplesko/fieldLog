package com.teaplesko.repository;

import com.teaplesko.model.FieldWork;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryFieldWorkRepository implements FieldWorkRepository {

    private final Map<Long, FieldWork> fieldWorkMap = new TreeMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public FieldWork save(FieldWork work) {
        if (work == null) {
            throw new IllegalArgumentException("Work cannot be null");
        }
        if (work.getId() == null) {
            work.setId(idGenerator.incrementAndGet());
        }
        fieldWorkMap.put(work.getId(), work);
        return work;
    }

    @Override
    public Optional<FieldWork> findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        return Optional.ofNullable(fieldWorkMap.get(id));
    }

    @Override
    public List<FieldWork> findByParcelId(Long parcelId) {
        if (parcelId == null) {
            throw new IllegalArgumentException("Parcel id cannot be null");
        }
        List<FieldWork> result = new ArrayList<>();
        for (FieldWork fieldWork : fieldWorkMap.values()) {
            if (fieldWork.getParcelId().equals(parcelId)) {
                result.add(fieldWork);
            }
        }
        return result;
    }

    @Override
    public List<FieldWork> findAll() {
        return new ArrayList<>(fieldWorkMap.values());
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        fieldWorkMap.remove(id);
    }

    @Override
    public void deleteByParcelId(Long parcelId) {
        if (parcelId == null) {
            throw new IllegalArgumentException("Parcel id cannot be null");
        }
        fieldWorkMap.values().removeIf(fieldWork -> fieldWork.getParcelId().equals(parcelId));
    }
}
