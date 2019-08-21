package com.ing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Breach {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long breachId;
	private String franchise;
	private String businessArea;
	private String breachCategory;
	private String priority;
	private String status;
	
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserDetails userDetails;

}
