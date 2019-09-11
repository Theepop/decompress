package com.test.decompress.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Service
public class DecompressService {

    public String decompressWithSearching(String s) {
        if ((s == null) || (s.length() == 0)) {
            return s;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i)) && s.charAt(i + 1) != '[') {
                String part = s.substring(i + 1, i + 2);
                String countStr = "";
                int j = i;
                for (; j >= 0 && Character.isDigit(s.charAt(j)); j--) {
                    countStr = s.charAt(j) + countStr;
                }
                int count = Integer.parseInt(countStr);
                String replacePart = repeat(part, count);
                s = s.substring(0, j + 1) + replacePart + s.substring(i + 2);
            }
        }

        int closing;
        while ((closing = s.indexOf(']')) > -1) {
            int opening = s.lastIndexOf('[', closing);
            String what = s.substring(opening + 1, closing);
            String countStr = "";
            int numPartIndex = opening - 1;
            while (numPartIndex >= 0 && Character.isDigit(s.charAt(numPartIndex))) {
                countStr = s.charAt(numPartIndex) + countStr;
                numPartIndex--;
            }
            int count = Integer.parseInt(countStr);
            String replacePart = repeat(what, count);
            s = s.substring(0, numPartIndex + 1) + replacePart + s.substring(closing + 1);
        }

        return s;
    }

    private String repeat(String what, int times) {
        if ((times <= 0) || (what == null) || (what.length() == 0)) {
            return "";
        }
        StringBuilder buffer = new StringBuilder(times * what.length());
        for (int i = 0; i < times; i++) {
            buffer.append(what);
        }
        return buffer.toString();
    }

}

