package com.swagger.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private long id;
	
	@NotBlank
	@Size(min = 3, max =15)
	private String name;
	
	@Email
	private String email;
	
	@Min(18)
	private int age;
	
}
