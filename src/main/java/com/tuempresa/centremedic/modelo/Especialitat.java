package com.tuempresa.centremedic.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(members = 	
	"Dades{" +
		"idespecialitat;" + 
		"nom;" +
	"}" +
	"Facultatius{" +
		"facultatius;" +
	"}")
@View(name = "Simple", members = 	
	"idespecialitat;" +
	"nom;")
public class Especialitat {

	@Id
	@Column(length=5)
	int idespecialitat;
	
	@Required
	@Column(length=32)
	String nom;

	@ListProperties("idpersona, codiEmpleat, nom, cognoms, centreMedic.nom")
	@CollectionView("Simple")
	@OneToMany(mappedBy="especialitat", fetch=FetchType.LAZY)
	Collection<Facultatiu> facultatius;

}
