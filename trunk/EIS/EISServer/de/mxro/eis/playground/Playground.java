package de.mxro.eis.playground;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import de.mxro.eis.data.URIResource;
import de.mxro.eis.data.jena.JenaData;
import de.mxro.eis.data.jena.JenaInMemoryData;
import de.mxro.eis.data.jena.ontology.OntologyDefinitions;

public class Playground {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JenaData data = new JenaInMemoryData("http://www.auckland.ac.nz/semdata#");
		data.getDefinitions().loadExampleData();
		
		data.addURIResource("http://www.google.com", null);
		data.addURIResource("http://www.yahoo.com", null);
		
		URIResource uri1 = data.getURIResource("http://www.google.com");
		URIResource uri2 = data.getURIResource("http://www.yahoo.com");
		
		data.addUserRelation(null, uri1, uri2);
		
		data.printData();
	}

}
