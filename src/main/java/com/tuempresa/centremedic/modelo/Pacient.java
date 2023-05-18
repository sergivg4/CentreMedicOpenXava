package com.tuempresa.centremedic.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity @Getter @Setter
@View(extendsView = "super.DEFAULT",
		members = 
			"Visites{" +
				"visites;" +
			"}")
@View(name = "Simple", 
		members = 	
			"idpersona, dni;" +
			"nom, cognoms;" +
			"dataNaixement, telefon;" + 
			"email;")
public class Pacient extends Persona{

	@CollectionView("Simple")
	@ListProperties("idvisita, data, comentaris")
	@OneToMany(mappedBy="pacient", fetch=FetchType.LAZY)
	Collection<Visita> visites;
	
}
