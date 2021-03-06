/**
 * Copyright (C) 2015 John Salatas (jsalatas@gmail.com)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License v3 (LGPL-3) 
 * as published by the Free Software Foundation.
 *
 */
package gr.ictpro.jsalatas.ane.directorylisting;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

/**
 * @author John Salatas <jsalatas@gmail.com>
 *
 */
public class DirectoryListingContext extends FREContext {

    /* (non-Javadoc)
     * @see com.adobe.fre.FREContext#dispose()
     */
    @Override
    public void dispose() {
	// Do Nothing
    }

    /* (non-Javadoc)
     * @see com.adobe.fre.FREContext#getFunctions()
     */
    @Override
    public Map<String, FREFunction> getFunctions() {
	Map<String, FREFunction> functions = new HashMap<String, FREFunction>();
	functions.put("isSupported", new SupportedFunction());
	functions.put("getDirectoryListing", new DirectoryListingFunction());
	return functions ;
    }

}
