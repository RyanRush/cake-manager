package com.waracle.cakemgr.repository;

import com.waracle.cakemgr.entity.Cake;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CakeRepository extends CrudRepository<Cake, Long>{}
