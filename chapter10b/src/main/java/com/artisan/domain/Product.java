package com.artisan.domain;
import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Product implements Serializable {
    private static final long serialVersionUID = 78L;

    @NotBlank
    @Size(min=1, max=10)
    private String name;

	private String description;
    private Float price;

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
}