/**
 * Copyright (c) Red Hat, Inc., contributors and others 2013 - 2014. All rights reserved
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.jboss.tools.aesh.core.internal.ansi;

import org.jboss.tools.aesh.core.document.Document;
import org.jboss.tools.aesh.core.internal.AeshCorePlugin;

public class CursorForward extends AbstractCommand {

	private int amount = 0;

	public CursorForward(String arguments) {
		try {
			amount = Integer.parseInt(arguments);
		} catch (NumberFormatException e) {
			AeshCorePlugin.log(e);
		}
	}

	@Override
	public CommandType getType() {
		return CommandType.CURSOR_FORWARD;
	}

	@Override
	public void handle(Document document) {
		document.moveCursorTo(document.getCursorOffset() + amount);
	}

}
