package com.bookmyshow.backend.bookmyshow_backend.Controller;

import com.bookmyshow.backend.bookmyshow_backend.DTO.TheaterDTO;
import com.bookmyshow.backend.bookmyshow_backend.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;

    @GetMapping("{id}")
    public ResponseEntity<TheaterDTO> getTheater(@PathVariable int id) {
        return new ResponseEntity<>(theaterService.getTheater(id), HttpStatus.FOUND);
    }

    @PostMapping("add")
    public ResponseEntity addTheater(@RequestBody TheaterDTO theaterDTO) {
        theaterService.addTheater(theaterDTO);
        return new ResponseEntity<>("Theater added successfully",HttpStatus.CREATED);
    }
}
