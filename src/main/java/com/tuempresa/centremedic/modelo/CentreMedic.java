package com.tuempresa.centremedic.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(members = 	
	"Dades{" +
		"idcentre;" +
		"nom;" +
		"telefon;" +
	"}" +
	"Adreça{" +
		"adreca;" +
	"}" +
	"Visites{" +
		"visites;" +
	"}" +
	"Facultatius{" +
		"facultatius;" +
	"}")
@View(name = "Simple", members = 	
	"idcentre;" +
	"nom;" +
	"telefon;")
public class CentreMedic {

	@Id
	@Column(length=5)
	int idcentre;
	
	@Required
	@Column(length=32)
	String nom;
	
	@Required
	@NoFrame
	Adreca adreca;
	
	@Required
	@Telephone
	@Column(length=9)
	String telefon;
	
	@ListProperties("idvisita, pacient.nom, facultatiu.nom, data, comentaris")
	@CollectionView("Simple")
	@OneToMany(mappedBy="centreMedic", fetch=FetchType.LAZY)
	Collection<Visita> visites;

	@ListProperties("idpersona, codiEmpleat, nom, cognoms")
	@CollectionView("Simple")
	@OneToMany(mappedBy="centreMedic", fetch=FetchType.LAZY)
	Collection<Facultatiu> facultatius;
	
	
}
