package de.mxro.eis.data.jena;

import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;

import de.mxro.eis.data.jena.ontology.OntologyDefinitions;

public class JenaInMemoryData extends JenaData {

	@Override
	public boolean initialize() {
		m = ModelFactory.createOntologyModel( 
				// create without inferecing, OWL Full - With inferecing would be OWL_MEM_MICRO_RULE_INF	
				OntModelSpec.OWL_MEM );
		definitions = new OntologyDefinitions(m);
		return definitions != null;
	}

	public JenaInMemoryData(String dataNamespace) {
		super(dataNamespace);
	}
	
	

}
