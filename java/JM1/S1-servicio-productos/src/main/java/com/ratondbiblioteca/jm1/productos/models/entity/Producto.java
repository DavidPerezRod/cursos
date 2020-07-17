package com.ratondbiblioteca.jm1.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name="PRODUCTOS")
@Data
public class Producto implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private Double precio;
	
	@Column(name = "CREATE_AT")
	@Temporal (TemporalType.DATE)
	private Date createAt;

	@Transient
	private Integer port;
	
	private static final long serialVersionUID = 522721632664501747L;
}
