package com.test.decompress.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class DecompressService {

    public String decompressWithSearching(String s) {
        if ((s == null) || (s.length() == 0)) {
            return s;
        }
        return recurDecompress(s, false);
    }


    String recurDecompress(String input, boolean isRecur) {
        String num = "";
        String result = "";
        String temp = "";
        boolean inBracket = false;

        for (int i = 0; i < input.length(); i++) {

            if (Character.isDigit(input.charAt(i))) {
                num += input.charAt(i);
            } else if (input.charAt(i) == '[') {
                inBracket = true;
                temp = recurDecompress(input.substring(i + 1), true);
                i = i + temp.length();
                int n = 0;
                if (num.length() > 0)
                    n = Integer.parseInt(num);
                String finalTemp = temp;
                if (n > 0)
                    result += IntStream.range(0, n).mapToObj(x -> finalTemp).collect(Collectors.joining(""));
                else
                    result += temp;

                num = "";
                isRecur = false;
            } else if (input.charAt(i) == ']') {
                if (isRecur)
                    return input.substring(0, i);
                else
                    inBracket = false;
            } else if (!inBracket) {
                result += input.charAt(i);
            }
        }
        return result;

    }

}

