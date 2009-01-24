package de.mxro.eis.data;


public interface Data {
	
	public URIResource addURIResource(String uri, User user);
	public UserRelation addUserRelation(User user, Resource source, Resource target);
	public URIResource getURIResource(String uri);
	
	public void printData();
	
}
