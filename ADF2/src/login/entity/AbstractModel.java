package com.assignments.login.entity;

public class AbstractModel {
    private Long id;
    public AbstractModel(){}

    public AbstractModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
