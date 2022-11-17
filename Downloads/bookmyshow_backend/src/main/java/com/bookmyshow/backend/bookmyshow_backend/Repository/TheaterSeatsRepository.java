package com.bookmyshow.backend.bookmyshow_backend.Repository;

import com.bookmyshow.backend.bookmyshow_backend.models.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatsRepository extends JpaRepository<TheaterSeatEntity,Integer> {
}
