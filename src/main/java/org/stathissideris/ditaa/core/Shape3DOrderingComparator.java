/**
 * ditaa - Diagrams Through Ascii Art
 * <p/>
 * Copyright (C) 2004-2011 Efstathios Sideris
 * <p/>
 * ditaa is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * <p/>
 * ditaa is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Lesser General Public
 * License along with ditaa.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.stathissideris.ditaa.core;

import org.stathissideris.ditaa.graphics.DiagramShape;

import java.util.Comparator;

/**
 *
 * @author Efstathios Sideris
 */
public class Shape3DOrderingComparator implements Comparator<DiagramShape> {

    /**
     * Puts diagram shapes in pseudo-3d order starting from back to front
     *
     */
    public int compare(DiagramShape shape1, DiagramShape shape2)
    {
        double y1 = shape1.makeIntoPath().getBounds().getCenterY();
        double y2 = shape2.makeIntoPath().getBounds().getCenterY();

        if (y1 > y2) return -1;
        if (y1 < y2) return 1;

        return 0;
    }

}
