package com.bookmyshow.backend.bookmyshow_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmyshow.backend.bookmyshow_backend.models.ShowEntity;

@Repository
public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
    
}
