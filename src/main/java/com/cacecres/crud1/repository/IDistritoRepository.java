package com.cacecres.crud1.repository;

import com.cacecres.crud1.entity.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDistritoRepository extends JpaRepository<Distrito,Long> {
}
