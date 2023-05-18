package com.tuempresa.facultatiu.calculadores;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

import com.tuempresa.centremedic.modelo.*;

public class CalculadorVisitaAnterior implements ICalculator{
	
    public Object calculate() throws Exception {
        Visita visitaAnterior = null;
        // Lógica para obtener la visita anterior, por ejemplo, consulta a la base de datos
        // Aquí puedes usar el EntityManager de OpenXava para obtener la visita anterior según tus necesidades
        // Por simplicidad, se asume que la visita anterior es la última visitada en la base de datos
        EntityManager entityMgr = XPersistence.getManager();
        visitaAnterior = (Visita) entityMgr.createQuery("SELECT v FROM Visita v ORDER BY v.idvisita DESC")
                .setMaxResults(1)
                .getSingleResult();
        entityMgr.close();
        return visitaAnterior;
    }
}
