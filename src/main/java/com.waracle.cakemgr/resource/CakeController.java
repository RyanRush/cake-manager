package com.waracle.cakemgr.resource;

import com.waracle.cakemgr.entity.Cake;
import com.waracle.cakemgr.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/cakes")
    public List<Cake> getCakes() {
        return StreamSupport
                .stream(cakeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
