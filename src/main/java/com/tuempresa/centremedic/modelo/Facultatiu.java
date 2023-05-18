package com.tuempresa.centremedic.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(
	members = 
		"Dades{" +
				"idpersona, codiEmpleat, dni;" +
				"nom, cognoms;" +
				"dataNaixement, telefon;" + 
				"email;" +
		"}" +
		"Adreça{" +
			"adreca;" +
		"}" +
		"Especialitat{" +
			"especialitat;" +
		"}" +
		"Centre médic{" +
			"centreMedic;" +
		"}" +
		"Visites{" +
			"visites;" +
		"}")
@View(name = "Simple",
	members = 
		"idpersona, codiEmpleat, dni;" +
		"nom, cognoms;" +
		"dataNaixement, telefon;" + 
		"email;")

public class Facultatiu extends Persona{

	@Required
	@Column(length=5)
	String codiEmpleat;
	
	@NoFrame
	@ReferenceView("Simple")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	Especialitat especialitat;
	
	@NoFrame
	@ReferenceView("Simple")
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	CentreMedic centreMedic;
	
	@ListProperties("idvisita, pacient.nom, centreMedic.nom, data, comentaris")
	@CollectionView("Simple")
	@OneToMany(mappedBy="facultatiu", fetch=FetchType.LAZY)
	Collection<Visita> visites;
	
}

