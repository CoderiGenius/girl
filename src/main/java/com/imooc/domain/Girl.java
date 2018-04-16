package com.imooc.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Girl {
    public Girl() {
    }
    @Id
    @GeneratedValue
    private Integer id;
    private String cupSize;
    private Integer age;
}
