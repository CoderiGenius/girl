package com.imooc.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Girl {
    public Girl() {
    }
    @Id
    @GeneratedValue
    private Integer id;
	@NotNull
    private String cupSize;
	@NotNull
    @Min(value = 18,message = "未成年")
    private Integer age;
    @NotNull(message = "没付钱")
    private  Integer money;
}
