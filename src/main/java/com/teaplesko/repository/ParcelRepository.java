package com.teaplesko.repository;

import com.teaplesko.model.Parcel;
import java.util.List;
import java.util.Optional;

public interface ParcelRepository {
    Parcel save(Parcel parcel);
    Optional<Parcel> findById(Long id);
    List<Parcel> findAll();
    void deleteById(Long id);
}
