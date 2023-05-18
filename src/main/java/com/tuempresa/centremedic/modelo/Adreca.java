package com.tuempresa.centremedic.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Embeddable @Getter @Setter
public class Adreca {

//	@Id
//	@Hidden
//	@GeneratedValue(generator="system-uuid") //Solo funciona si es un String
//	@GenericGenerator(name="system-uuid", strategy="uuid")
	
	@Required
	@Column(length=32)
	String poblacio;
	
	@Required
	@Column(length=32)
	String provincia;
	
	@Required
	@Column(length=5)
	String cp;
	
	@Column(length=52)
	String domicili;

}
