package com.carlosb.herois.repositories;

import com.carlosb.herois.domain.Heroes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroesRepository extends JpaRepository<Heroes, Integer> {
}
