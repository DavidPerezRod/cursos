package com.formacionbdi.springboot.app.item.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Producto implements Serializable{

	@SuppressWarnings("unused")
	private Long id;
	
	@SuppressWarnings("unused")
	private String nombre;
	
	@SuppressWarnings("unused")
	private Double precio;
	
	@SuppressWarnings("unused")
	private Date  createAt;

	private Integer port;
	
	private static final long serialVersionUID = 522721632664501747L;
}
