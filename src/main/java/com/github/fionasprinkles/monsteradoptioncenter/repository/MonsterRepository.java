package com.github.fionasprinkles.monsteradoptioncenter.repository;

import com.github.fionasprinkles.monsteradoptioncenter.entity.Monster;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterRepository extends ListCrudRepository<Monster, Long> {
}
