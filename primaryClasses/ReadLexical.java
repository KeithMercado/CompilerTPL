package com.miniCompiler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class ReadLexical {
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
            StringBuilder token = new StringBuilder();
            boolean hasDataType = false;
            boolean hasIdentifier = false;
            boolean hasAssignmentOperator = false;
            boolean hasValue = false;
            boolean hasDelimiter = false;

            while (matcher.find()) {
                String lexeme = matcher.group();
                if (isInArray(lexeme, dataTypes)) {
                    token.append("<data_type> ");
                    hasDataType = true;
                } else if (isInArray(lexeme, operator)) {
                    token.append("<assignment_operator> ");
                    hasAssignmentOperator = true;
                } else if (isInArray(lexeme, booleans)) {
                    token.append("<value> ");
                    hasValue = true;
                } else if (lexeme.matches(identifier)) {
                    token.append("<identifier> ");
                    hasIdentifier = true;
                } else if (stringPattern.matcher(lexeme).matches()) {
                    token.append("<value> ");
                    hasValue = true;
                } else if (lexeme.matches(value)) {
                    token.append("<value> ");
                    hasValue = true;
                } else if (isInArray(lexeme, delimiter)) {
                    token.append("<delimiter> ");
                    hasDelimiter = true;
                }
            }

            List<String> missingTokens = new ArrayList<>();
            if (!hasDataType) missingTokens.add("<data_type>");
            if (!hasIdentifier) missingTokens.add("<identifier>");
            if (!hasAssignmentOperator) missingTokens.add("<assignment_operator>");
            if (!hasValue) missingTokens.add("<value>");
            if (!hasDelimiter) missingTokens.add("<delimiter>");

            if (!missingTokens.isEmpty()) {
                output.add("Error: Missing tokens: " + String.join(", ", missingTokens));
            } else {
                output.add(token.toString().trim());
            }
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
