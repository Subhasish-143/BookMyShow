package com.bookmyshow.backend.bookmyshow_backend.Controller;

import com.bookmyshow.backend.bookmyshow_backend.DTO.ShowDTO;
import com.bookmyshow.backend.bookmyshow_backend.Services.impl.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowServiceImpl showService;

    @PostMapping("add/{mov_id}/{tht_id}")
    public ResponseEntity addShow(@RequestBody ShowDTO showDTO,@PathVariable int mov_id,@PathVariable int tht_id) {
        showService.addShow(showDTO,mov_id,tht_id);
        return new ResponseEntity<>("Show Added successfully", HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ShowDTO> getShow(@PathVariable int id) {
        return new ResponseEntity<>(showService.getShow(id),HttpStatus.FOUND);
    }
}
