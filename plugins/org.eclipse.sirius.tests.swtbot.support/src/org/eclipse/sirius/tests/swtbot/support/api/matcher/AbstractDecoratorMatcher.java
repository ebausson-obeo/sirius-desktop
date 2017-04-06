/**
 * Copyright (c) 2010, 2017 THALES GLOBAL SERVICES
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Obeo - Initial API and implementation
 */
package org.eclipse.sirius.tests.swtbot.support.api.matcher;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration;
import org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx;
import org.eclipse.sirius.tests.support.api.ImageEquality;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swtbot.swt.finder.matchers.AbstractMatcher;

/**
 * 
 * This class is used to check if a graphical element has a decorator.
 * 
 * @author amartin
 */
public abstract class AbstractDecoratorMatcher extends AbstractMatcher<EditPart> {

    /**
     * return the image of the targeted decorator.
     * 
     * @return the image of te decorator
     */
    protected abstract Image getImage();

    @Override
    protected boolean doMatch(final Object item) {
        if (item instanceof EditPart) {
            EditPart part = (EditPart) item;
            EditPartViewer viewer = part.getViewer();
            Map<IFigure, EditPart> mapDecorator = viewer.getVisualPartMap();

            for (final Entry<IFigure, EditPart> entry : mapDecorator.entrySet()) {
                final EditPart currentPart = entry.getValue();
                final IFigure visual = entry.getKey();
                if (currentPart.equals(part) && visual instanceof IDecoration) {
                    return findFigureWithImage(visual, getImage());
                }

            }
        }
        return false;
    }

    @SuppressWarnings("restriction")
    private boolean findFigureWithImage(IFigure figure, Image image) {
        if (figure instanceof ImageFigureEx) {
            if (ImageEquality.areEqualImages(((ImageFigureEx) figure).getImage(), image)) {
                return true;
            }
        }

        boolean imageFigureExFound = false;
        Iterator<Figure> it = figure.getChildren().iterator();
        while (it.hasNext() && !imageFigureExFound) {
            Figure innerFigure = it.next();
            imageFigureExFound = findFigureWithImage(innerFigure, image);
        }

        return imageFigureExFound;
    }
}
