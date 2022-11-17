package com.bookmyshow.backend.bookmyshow_backend.Repository;

import com.bookmyshow.backend.bookmyshow_backend.models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
}
