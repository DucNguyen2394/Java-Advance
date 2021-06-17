package com.assignments.mvcDesign.entity;

public class Product {
    private Integer id;
    private String name;
    private String desc;
    private Double price;
    private Integer category_Id;

    public  Product(){

    }
    public Product( String name, String desc, Double price) {
        this.name = name;
        this.desc = desc;
        this.price = price;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(Integer category_Id) {
        this.category_Id = category_Id;
    }
}
