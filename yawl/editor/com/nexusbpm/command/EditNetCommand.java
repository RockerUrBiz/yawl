/*
 * This file is made available under the terms of the LGPL licence.
 * This licence can be retreived from http://www.gnu.org/copyleft/lesser.html.
 * The source remains the property of the YAWL Foundation.  The YAWL Foundation is a collaboration of
 * individuals and organisations who are commited to improving workflow technology.
 *
 */
package com.nexusbpm.command;

import au.edu.qut.yawl.elements.YNet;

import com.nexusbpm.editor.persistence.EditorDataProxy;

/**
 * The EditNetCommand is used for all updates to attributes directly related
 * to a YNet.
 * 
 * @see YNet
 * @author Matthew Sandoz
 *
 */
public class EditNetCommand extends EditCommand{

	public EditNetCommand(EditorDataProxy proxy, String attribute, Object value) {
		super(proxy, attribute, value);
	}

}
