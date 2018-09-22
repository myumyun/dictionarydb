package com.dictionarydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dictionarydb.entity.Family;

public interface FamilyRepository extends JpaRepository<Family, Integer> {

}
