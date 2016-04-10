/**
 * Copyright (C) 2015 John Salatas (jsalatas@gmail.com)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License v3 (LGPL-3) 
 * as published by the Free Software Foundation.
 *
 */
package gr.ictpro.jsalatas.ane.directorylisting;

import java.io.File;
import java.util.Arrays;

import android.content.Context;
import android.os.Environment;

import com.adobe.fre.FREASErrorException;
import com.adobe.fre.FREArray;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FRENoSuchNameException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

/**
 * @author John Salatas <jsalatas@gmail.com>
 * 
 */
public class DirectoryListingFunction implements FREFunction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adobe.fre.FREFunction#call(com.adobe.fre.FREContext,
	 * com.adobe.fre.FREObject[])
	 */
	@Override
	public FREArray call(FREContext ctx, FREObject[] args) {
		FREArray returnValue = null;
		String path = Environment.getExternalStorageDirectory().getPath();
		if (args.length > 0) {
			try {
				path = args[0].getAsString();
			} catch (IllegalStateException e) {
			} catch (FRETypeMismatchException e) {
			} catch (FREInvalidObjectException e) {
			} catch (FREWrongThreadException e) {
			}
		}

		try {
			File f = new File(path);
			String[] files = f.list();
			returnValue = FREArray.newArray("String", files.length, true);

			for (int i = 0; i < files.length; i++) {
				returnValue.setObjectAt(i, FREObject.newObject(files[i]));
			}

		} catch (IllegalStateException e) {
		} catch (FRETypeMismatchException e) {
		} catch (FREInvalidObjectException e) {
		} catch (FREWrongThreadException e) {
		} catch (FREASErrorException e) {
		} catch (FRENoSuchNameException e) {
		}

		return returnValue;
	}

}
