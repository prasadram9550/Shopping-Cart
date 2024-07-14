package com.rr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@RequiredArgsConstructor

@Table(name = "category")

public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
private Integer id;
	private String name;
	
	public void setId(Integer id) {
	    this.id = id;
	}
	public Integer getId() {
        return id;
    }
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	

}
