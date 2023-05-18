package com.tuempresa.centremedic.modelo;

import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Entity @Getter @Setter
@View(members = 	
	"Dades{" +
		"idvisita;" +
		"data;" +
		"comentaris;" +
	"}" +
	"Pacient{" +
		"pacient;" +
	"}" +
	"Centre médic{" +
		"centreMedic;" +
	"}" +
	"Facultatiu{" +
		"facultatiu;" +
	"}" //+
//	"Visita anterior{" +
//		"visitaAnterior;" +
//	"}"
	)
@View(name = "Simple", members = 	
	"idvisita;" +
	"data;" +
	"comentaris;")
public class Visita {
	
	@Id
	@Column(length=5)
	int idvisita;
	
	@Required
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@NoFrame
	@ReferenceView("Simple")
	Pacient pacient;
	
	@NoFrame
	@Required
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@ReferenceView("Simple")
	CentreMedic centreMedic;
	
	@Required
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@ReferenceView("Simple")
	@NoFrame
	Facultatiu facultatiu;
	
	@Required
	@DefaultValueCalculator(CurrentLocalDateCalculator.class)
	LocalDate data;
	
	@TextArea
	String comentaris;
	
//	@DefaultValueCalculator(CalculadorVisitaAnterior.class)
//	Visita visitaAnterior;

}
