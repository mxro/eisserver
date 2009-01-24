package de.mxro.eis.data.jena;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;

import de.mxro.eis.data.UserRelation;

public class JenaUserRelation extends UserRelation implements JenaResource {
	private final Individual ind;
	private final OntModel m;

	public Individual getIndividual() {
		return ind;
	}

	public JenaUserRelation(final OntModel m, final Individual ind) {
		super();
		this.m = m;
		this.ind = ind;
	}
	
	
	
}
