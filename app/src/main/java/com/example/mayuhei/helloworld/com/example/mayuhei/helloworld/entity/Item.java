package com.example.mayuhei.helloworld.com.example.mayuhei.helloworld.entity;

/**
 * Created by mayuhei on 2016/12/12.
 */

public class Item {
    private Long id;
    private String name;
    private String imageUrl;
    private Integer price;

    private String detail;

    public Item(String name, String image){
        this.name = name;
        this.imageUrl = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image) {
        this.imageUrl = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


}
