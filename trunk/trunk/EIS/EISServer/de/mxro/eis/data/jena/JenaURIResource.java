package de.mxro.eis.data.jena;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;

import de.mxro.eis.data.URIResource;

public class JenaURIResource extends URIResource implements JenaResource {
	private final Individual ind;
	private final OntModel m;

	public JenaURIResource(final OntModel m, final Individual ind) {
		this.m = m;
		this.ind = ind;
	}

	@Override
	public String getURI() {
		return null;
	}

	public Individual getIndividual() {
		return ind;
	}
	
	
	
	
}
