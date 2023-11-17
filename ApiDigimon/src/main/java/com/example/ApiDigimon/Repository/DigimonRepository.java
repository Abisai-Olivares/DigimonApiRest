package com.example.ApiDigimon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ApiDigimon.Model.Digimon;

@Repository
public interface DigimonRepository extends JpaRepository<Digimon, Long> {

}
