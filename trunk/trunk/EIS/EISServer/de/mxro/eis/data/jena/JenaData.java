package de.mxro.eis.data.jena;

import java.net.URI;
import java.net.URISyntaxException;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Selector;

import de.mxro.UserError;
import de.mxro.eis.data.Data;
import de.mxro.eis.data.Resource;
import de.mxro.eis.data.URIResource;
import de.mxro.eis.data.User;
import de.mxro.eis.data.UserRelation;
import de.mxro.eis.data.jena.ontology.OntologyDefinitions;
import de.mxro.eis.data.jena.ontology.SchemaExport;

public abstract class JenaData implements Data {
	
	public final String ns;
	
	protected OntModel m;
	protected OntologyDefinitions definitions;
	
	public abstract boolean initialize();
	
	
	public OntologyDefinitions getDefinitions() {
		return definitions;
	}
	
	public URIResource getURIResource(String uri) {
		
		String queryString =
			 de.mxro.jena.Utils.createSPARQLPrefixes(m)+
			 "SELECT ?object " +
			 "WHERE { ?object eis:has_URI \""+uri+"\" . "+
				     "?object rdf:type eis:URI_Resource }";
		
		Query query = QueryFactory.create(queryString);
		
		QueryExecution qe = QueryExecutionFactory.create(query, m);
		
		ResultSet results = qe.execSelect();
		
		while (results.hasNext()) {
			QuerySolution qs = results.nextSolution();
			com.hp.hpl.jena.rdf.model.Resource r = qs.getResource("object");
			
			return new JenaURIResource(m, m.getIndividual(r.getURI()));
		}
		//ResultSetFormatter.out(System.out, results, query);
		
		qe.close();
		
		return null;
	}
	
	public URIResource addURIResource(String uri, User user) {
		URI ruri;
		try {
			ruri = new URI(uri);
		} catch (URISyntaxException e) {
			UserError.singelton.log(e);
			return null;
		}

		Individual resource = definitions.getURIResourceClass().createIndividual(ns+"uriresource/"+ruri.getHost()+"/"+ruri.getPath());
		resource.setPropertyValue(definitions.getHasURI(), m.createLiteral(uri));
		return new JenaURIResource(m, resource);
	}

	private Individual getIndividual(Resource res) {
		if (!(res instanceof JenaResource)) {
			UserError.singelton.log("JenaData.getIndividual expects JenaResource", UserError.Priority.HIGH);
			return null;
		}
		return ((JenaResource) res).getIndividual();
	}
	
	public UserRelation addUserRelation(User user, Resource source,
			Resource target) {
		Individual sourceInd = getIndividual(source);
		Individual targetInd = getIndividual(target);
		
		Individual rel = m.createIndividual(this.definitions.getUserRelationClass());
		
		sourceInd.setPropertyValue(SchemaExport.has_Relation, rel);
		rel.setPropertyValue(SchemaExport.relation_Value, targetInd);
		
		return new JenaUserRelation(m, rel);
	}
	
	public JenaData(String dataNamespace) {
		this.ns = dataNamespace;
		initialize();
	}

	public void printData() {
		m.write(System.out);
	}

		
}
