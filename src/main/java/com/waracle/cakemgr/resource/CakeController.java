package com.waracle.cakemgr.resource;

import com.waracle.cakemgr.entity.Cake;
import com.waracle.cakemgr.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class CakeController {

    private final CakeRepository cakeRepository;

    @Autowired
    public CakeController(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    @GetMapping("/")
    public List<Cake> getCakes(){
        return fetchCakesFromRepository();
    }

    // todo https://www.jeejava.com/junit-testing-of-file-upload-and-download-in-spring-rest-controllers/
    @GetMapping("/cakes")
    public ResponseEntity<List<Cake>> downloadCakeJsonFile() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=cakes.json")
                .body(fetchCakesFromRepository());
    }

    @PostMapping("/cakes")
    public Cake newEmployee(@RequestBody Cake cake) {
        return cakeRepository.save(cake);
    }

    private List<Cake> fetchCakesFromRepository() {
        return StreamSupport
                .stream(cakeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
