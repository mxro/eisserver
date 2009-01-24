package de.mxro.eis.data;

import com.hp.hpl.jena.ontology.OntModel;

public class Utils {
	public static String findUniqueResourceName(OntModel m, String base) {
		String id = base;
		int counter = 0;
		while (m.getIndividual(id) != null) {
			counter++;
			id = base+counter;
		}
		return id;
	}
}
