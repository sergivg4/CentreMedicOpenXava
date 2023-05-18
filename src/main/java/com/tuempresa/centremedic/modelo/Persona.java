package com.tuempresa.centremedic.modelo;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@MappedSuperclass @Getter @Setter
@View(
	members = 	
		"Dades{" +
			"idpersona, dni;" +
			"nom, cognoms;" +
			"dataNaixement, telefon;" + 
			"email;" +
		"}" +
		"Adreça{" +
			"adreca;" +
		"}")
public class Persona {

	@Id
//	@Hidden
//	@GeneratedValue(generator="system-uuid") //Solo funciona si es un String y sin el @Required
//	@GenericGenerator(name="system-uuid", strategy="uuid")
	@Column(length=5)
	int idpersona;
	
	@Required
	@Column(length=9)
	String dni;
	
	@Required
	@Column(length=32)
	String nom;
	
	@Required
	@Column(length=52)
	String cognoms;
	
	@Required
	LocalDate dataNaixement;
	
	@Required
	@Column(length=9)
	String telefon;
	
	@Column(length=52)
	String email;
	
	@Required
	@NoFrame
	@Embedded
	Adreca adreca; 
	
}
