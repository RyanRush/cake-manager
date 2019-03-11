package com.waracle.cakemgr.entity;

import org.springframework.data.annotation.Id;

public class Cake {

    @Id
    private Long id;
    private String title;
    private String description;
    private String image;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

}
