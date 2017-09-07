/*******************************************************************************
 * Copyright (c) 2015, 2017 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.common.tools.api.interpreter;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * Class owning methods used for service: interpreter. The service methods should be prefixed by std to avoid conflict
 * with other services.
 * 
 * @author <a href="mailto:laurent.fasani@obeo.fr">Laurent Fasani</a>
 */
public class StandardServices {

    /**
     * Default constructor.
     */
    public StandardServices() {
    }

    /**
     * Return an empty list.
     * 
     * @param context
     *            not used but necessary for the service conventions
     * @return an empty list
     */
    public List<EObject> stdEmptyCollection(EObject context) {
        return Collections.emptyList();
    }
}
