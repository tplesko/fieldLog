package com.teaplesko.repository;

import com.teaplesko.model.FieldWork;

import java.util.List;
import java.util.Optional;

public interface FieldWorkRepository {
    FieldWork save(FieldWork work);
    Optional<FieldWork> findById(Long id);
    List<FieldWork> findByParcelId(Long parcelId);
    List<FieldWork> findAll();
    void deleteById(Long id);
    void deleteByParcelId(Long parcelId);
}
