package com.raxixor.simplelog;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

/**
 * This class has a major inspiration from <a href="https://commons.apache.org/proper/commons-lang/" target="_blank>Lang 3</a>
 *
 * <p>Specifically StringUtils.java and ExceptionUtils.java</p>
 */
public final class Helpers {
    
    // ## StringUtils ##
    
    public static boolean isEmpty(final CharSequence seq) {
        return seq == null || seq.length() == 0;
    }
    
    public static boolean containsWhitespace(final CharSequence seq) {
        if (isEmpty(seq))
            return false;
        for (int i = 0; i < seq.length(); i++)
            if (Character.isWhitespace(seq.charAt(i)))
                return true;
        
        return false;
    }
    
    public static boolean isBlank(final CharSequence seq) {
        if (isEmpty(seq))
            return true;
        for (int i = 0; i < seq.length(); i++)
            if (!Character.isWhitespace(seq.charAt(i)))
                return false;
        
        return true;
    }
    
    public static boolean equalsIgnoreCase(final String seq0, final String seq1) {
        return Objects.equals(seq0, seq1) || (seq0 != null && seq0.equalsIgnoreCase(seq1));
    }
    
    public static int countMatches(final CharSequence seq, final char c) {
        if (isEmpty(seq))
            return 0;
        int count = 0;
        for (int i = 0; i < seq.length(); i++)
            if (seq.charAt(i) == c)
                count++;
        
        return count;
    }
    
    public static String turncate(final String input, final int maxWidth) {
        if (input == null)
            return null;
        Checks.notNegative(maxWidth, "maxWidth");
        if (input.length() <= maxWidth)
            return input;
        if (maxWidth == 0)
            return "";
        return input.substring(0, maxWidth);
    }
    
    public static String rightPad(final String input, final int size) {
        int pads = size - input.length();
        if (pads <= 0)
            return input;
        StringBuilder out = new StringBuilder(input);
        for (int i = pads; i > 0; i--)
            out.append(' ');
        return out.toString();
    }
    
    public static String leftPad(final String input, final int size) {
        int pads = size - input.length();
        if (pads <= 0)
            return input;
        StringBuilder out = new StringBuilder();
        for (int i = pads; i > 0; i--)
            out.append(' ');
        return out.append(input).toString();
    }
    
    // ## ExceptionUtils ##
    
    //Copied from org.apache.commons:commons-lang3:3.5 ExceptionUtils.java
    public static String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
