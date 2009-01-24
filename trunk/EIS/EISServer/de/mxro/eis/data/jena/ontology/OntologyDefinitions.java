package de.mxro.eis.data.jena.ontology;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;


public class OntologyDefinitions {
	
	public final String NS = "http://www.mxro.de/eis#";
	private final OntModel m;
	
	public OntClass getUserRelationClass() {
		return m.getOntClass(NS+"UserRelation");
	}
	
	public OntClass getURIResourceClass() {
		return m.getOntClass(NS+"URI_Resource");
	}
	
	public DatatypeProperty getHasURI() {
		return m.getDatatypeProperty(NS+"has_URI");
	}
	
	public boolean loadExampleData() {
		return m.read(this.getClass().getResourceAsStream("exampledata/data.rdf-xml.owl"), "") != null;
	}
	
	/**
	 * writes the basic ontology in the model m
	 * @param m
	 * @return
	 */
	private boolean insertBasicOntology(OntModel m) {
		OntModel read = ModelFactory.createOntologyModel( 
				// create without inferecing, OWL Full - With inferecing would be OWL_MEM_MICRO_RULE_INF	
				OntModelSpec.OWL_MEM );
		//read.read(this.getClass().getResourceAsStream("basic/basicOntology.owl"), "" );
	
		read.read("http://mxro.site90.com/ontologies/basic.owl", "RDF/XML");
		m.addSubModel(read);
		return true;
	}
	
	public OntologyDefinitions(OntModel m) {
		this.m = m;
		//insertBasicOntology(m);
		
	}
	
}
