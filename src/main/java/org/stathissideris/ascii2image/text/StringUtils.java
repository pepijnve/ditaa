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
package org.stathissideris.ascii2image.text;

/**
 * @author sideris
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class StringUtils {

    /**
     * The indexOf idiom
     */
    public static boolean contains(String big, String fragment)
    {
        return (big.indexOf(fragment) != -1);
    }

    public static String repeatString(String string, int repeats)
    {
        if (repeats == 0) return "";
        String buffer = "";
        for (int i = 0; i < repeats; i++) {
            buffer += string;
        }
        return buffer;
    }

    public static boolean isBlank(String s)
    {
        return (s.length() == 0 || s.matches("^\\s*$"));
    }

    /**
     *
     * Converts the first character of <code>string</code> into a capital letter
     */
    public static String firstToUpper(String string)
    {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static String insertSpaceAtCaps(String string)
    {

        int uppers = 0;

        //first we count
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) uppers++;
        }

        int[] indexes = null;

        if (Character.isUpperCase(string.charAt(0))) {
            indexes = new int[uppers];
        } else {
            indexes = new int[++uppers];
        }
        indexes[0] = 0;
        int k = 1;

        //then we find the indexes (we have ckecked the first char already)
        for (int j = 1; j < string.length(); j++) {
            if (Character.isUpperCase(string.charAt(j))) indexes[k++] = j;
        }

        StringBuilder buffer = new StringBuilder();
        //and finally we breakup the String
        for (int i = 0; i < indexes.length; i++) {
            if (i + 1 < indexes.length) {
                buffer.append(string.substring(indexes[i], indexes[i + 1]));
                buffer.append(" ");
            } else {
                buffer.append(string.substring(indexes[i]));
            }
        }
        return buffer.toString();
    }


    public static boolean isOneOf(char c, char[] group)
    {
        for (char aGroup : group) if (c == aGroup) return true;
        return false;
    }

    public static boolean isOneOf(String str, String[] group)
    {
        for (String aGroup : group) if (str.equals(aGroup)) return true;
        return false;
    }

    public static String getPath(String fullPath)
    {
        if (fullPath.lastIndexOf("\\") != -1)
            return fullPath.substring(0, fullPath.lastIndexOf("\\"));
        else return "";
    }

    public static String getBaseFilename(String fullPath)
    {
        if (fullPath.lastIndexOf(".") != -1 && fullPath.lastIndexOf("\\") != -1)
            return fullPath.substring(fullPath.lastIndexOf("\\") + 1, fullPath.lastIndexOf("."));
        else return fullPath;
    }

    public static String getExtension(String fullPath)
    {
        if (fullPath.lastIndexOf(".") != -1)
            return fullPath.substring(fullPath.lastIndexOf(".") + 1);
        else return "";
    }
}
