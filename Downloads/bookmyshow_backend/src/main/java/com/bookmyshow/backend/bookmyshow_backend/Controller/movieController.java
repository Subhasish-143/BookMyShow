package com.bookmyshow.backend.bookmyshow_backend.Controller;

import com.bookmyshow.backend.bookmyshow_backend.DTO.MovieDTO;
import com.bookmyshow.backend.bookmyshow_backend.Services.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class movieController {
    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("add")
    public ResponseEntity addMovie(@RequestBody()MovieDTO movieDTO) {
        movieService.addMovie(movieDTO);
        return new ResponseEntity<>("Movie added Successfully", HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable() int id) {
        return new ResponseEntity<>(movieService.getMovie(id),HttpStatus.FOUND);
    }

    @GetMapping("get")
    public ResponseEntity<MovieDTO> getMovieByName(@RequestParam String name) {
        return new ResponseEntity<>(movieService.getMovie(name),HttpStatus.FOUND);
    }
}
