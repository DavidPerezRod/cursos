package com.formacionbdi.springboot.app.item.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Producto implements Serializable{

	private Long id;
	private String nombre;
	private Double precio;
	private Date  createAt;
	private Integer port;
	
	private static final long serialVersionUID = 522721632664501747L;
}
