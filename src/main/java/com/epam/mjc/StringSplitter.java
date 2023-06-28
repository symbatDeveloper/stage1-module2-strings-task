package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringTokenizer st1 = new StringTokenizer(source, delimiters.toString());
      ArrayList<String> parts =new ArrayList<>();
      while (st1.hasMoreTokens()){
          parts.add(st1.nextToken());
      }
return parts;
    }
}
