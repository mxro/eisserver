/* CVS $Id: $ */
package de.mxro.eis.data.jena.ontology; 
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.ontology.*; 
/**
 * Vocabulary definitions from file:/Applications/Protege_3.3.1/schemagen-temp.owl 
 * @author Auto-generated by schemagen on 24 Jan 2009 17:46 
 */
public class SchemaExport {
    /** <p>The ontology model that holds the vocabulary terms</p> */
    private static OntModel m_model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, null );
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://www.mxro.de/eis#";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    public static final ObjectProperty has_Location = m_model.createObjectProperty( "http://www.mxro.de/eis#has_Location" );
    
    public static final ObjectProperty has_Relation = m_model.createObjectProperty( "http://www.mxro.de/eis#has_Relation" );
    
    public static final ObjectProperty has_Owner = m_model.createObjectProperty( "http://www.mxro.de/eis#has_Owner" );
    
    public static final ObjectProperty inserted_By = m_model.createObjectProperty( "http://www.mxro.de/eis#inserted_By" );
    
    public static final ObjectProperty relation_Value = m_model.createObjectProperty( "http://www.mxro.de/eis#relation_Value" );
    
    public static final ObjectProperty has_System = m_model.createObjectProperty( "http://www.mxro.de/eis#has_System" );
    
    public static final DatatypeProperty has_URI = m_model.createDatatypeProperty( "http://www.mxro.de/eis#has_URI" );
    
    /** <p>An unclassified relation explicitly inserted by an user.</p> */
    public static final OntClass UserRelation = m_model.createClass( "http://www.mxro.de/eis#UserRelation" );
    
    public static final OntClass ExternalOwner = m_model.createClass( "http://www.mxro.de/eis#ExternalOwner" );
    
    public static final OntClass URI_Resource = m_model.createClass( "http://www.mxro.de/eis#URI_Resource" );
    
    public static final OntClass InternalOwner = m_model.createClass( "http://www.mxro.de/eis#InternalOwner" );
    
    public static final OntClass Person = m_model.createClass( "http://www.mxro.de/eis#Person" );
    
    public static final OntClass Information_Resource = m_model.createClass( "http://www.mxro.de/eis#Information_Resource" );
    
    public static final OntClass User = m_model.createClass( "http://www.mxro.de/eis#User" );
    
    public static final OntClass Information_System = m_model.createClass( "http://www.mxro.de/eis#Information_System" );
    
    public static final OntClass Resource = m_model.createClass( "http://www.mxro.de/eis#Resource" );
    
    public static final OntClass ResourceOwner = m_model.createClass( "http://www.mxro.de/eis#ResourceOwner" );
    
    /** <p>A possibly attributed relation between two resources.</p> */
    public static final OntClass ResourceRelation = m_model.createClass( "http://www.mxro.de/eis#ResourceRelation" );
    
}
