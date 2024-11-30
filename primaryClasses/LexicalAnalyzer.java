package com.miniCompiler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {
    public List<String> analyze(List<String> input) {
        String[] dataTypes = {"int", "double", "char", "String", "boolean"};
        String[] booleans = {"true", "false"};
        String identifier = "[a-zA-Z_][a-zA-Z0-9_]*";
        String value = "\"(?:[^\"\\\\]|\\\\.)*\"|'[^']*'|\\d+(\\.\\d+)?";
        String[] operator = {"="};
        String[] delimiter = {";"};

        Pattern stringPattern = Pattern.compile("\"[^\"]*\"");
        List<String> output = new ArrayList<>();
        Pattern pattern = Pattern.compile("(" + identifier + "|" + value + "|.)");

        for (String statement : input) {
            Matcher matcher = pattern.matcher(statement);
            StringBuilder token = new StringBuilder("");
            while (matcher.find()) {
                String lexeme = matcher.group();
                if (isInArray(lexeme, dataTypes)) {
                    token.append("<data_type> ");
                } else if (isInArray(lexeme, operator)) {
                    token.append("<assignment_operator> ");
                } else if (isInArray(lexeme, booleans)) {
                    token.append("<value> ");
                } else if (lexeme.matches(identifier)) {
                    token.append("<identifier> ");
                } else if (stringPattern.matcher(lexeme).matches()) {
                    token.append("<value> ");
                } else if (lexeme.matches(value)) {
                    token.append("<value> ");
                } else if (isInArray(lexeme, delimiter)) {
                    token.append("<delimiter> ");
                }
            }
            output.add(token.toString().trim());
        }

        return output;
    }

    private static boolean isInArray(String result, String[] array) {
        for (String item : array) {
            if (item.equals(result)) {
                return true;
            }
        }
        return false;
    }
}
