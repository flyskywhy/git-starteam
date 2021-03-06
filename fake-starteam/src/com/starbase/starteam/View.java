/*****************************************************************************
 * All public interface based on Starteam API are a property of Borland, 
 * those interface are reproduced here only for testing purpose. You should
 * never use those interface to create a competitive product to the Starteam
 * Server. 
 * 
 * The implementation is given AS-IS and should not be considered a reference 
 * to the API. The behavior on a lots of method and class will not be the
 * same as the real API. The reproduction only seek to mimic some basic 
 * operation. You will not found anything here that can be deduced by using
 * the real API.
 * 
 * Fake-Starteam is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *****************************************************************************/
package com.starbase.starteam;

import com.starbase.util.OLEDate;

public class View extends SimpleTypedResource implements ISecurableContainer, ISecurableObject {
	
	private Folder rootFolder;
	
	protected View() {
	}
	
	public View(View parent, java.lang.String name, java.lang.String description, java.lang.String defaultWorkingFolder) {
		
	}

	@Override
	public int getID() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public java.lang.String getName() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public void update() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public Project getProject() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public View getParentView() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public String getDescription() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public void setDescription(String description) {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public String getDefaultPath() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public void setDefaultPath(String path) {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public void refresh() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public void populate() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public OLEDate getCreatedTime() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
	
	public Folder getRootFolder() {
		throw new UnsupportedOperationException("Not implemented at this level");
	}
}
