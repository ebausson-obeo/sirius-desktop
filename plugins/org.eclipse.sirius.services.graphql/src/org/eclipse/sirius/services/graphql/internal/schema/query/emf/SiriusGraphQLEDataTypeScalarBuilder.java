/*******************************************************************************
 * Copyright (c) 2018, 2019 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.services.graphql.internal.schema.query.emf;

import org.eclipse.emf.ecore.EDataType;

import graphql.schema.GraphQLScalarType;

/**
 * Utility class used to create GraphQL scalars for EMF EDataTypes.
 * 
 * @author sbegaudeau
 */
public class SiriusGraphQLEDataTypeScalarBuilder {

    /**
     * The separator used in the description of the scalar.
     */
    private static final String SEPARATOR = ":"; //$NON-NLS-1$

    /**
     * The EDataType.
     */
    private EDataType eDataType;

    /**
     * The constructor.
     * 
     * @param eDataType
     *            The EDataType
     */
    public SiriusGraphQLEDataTypeScalarBuilder(EDataType eDataType) {
        this.eDataType = eDataType;
    }

    /**
     * Returns the GraphQL Scalar.
     * 
     * @return The GraphQL Scalar
     */
    public GraphQLScalarType build() {
        // @formatter:off
        return GraphQLScalarType.newScalar()
                .name(this.eDataType.getName())
                .description(this.eDataType.getEPackage().getNsPrefix() + SEPARATOR + this.eDataType.getName())
                .coercing(new SiriusGraphQLEDataTypeCoercing(this.eDataType))
                .build();
        // @formatter:on
    }
}
