package com.miniCompiler;

import java.util.List;

public class SemanticAnalyzer {
    public String analyze(List<String> lines) {
        boolean valid = true;

        for (String line : lines) {
            String result = analyzeLine(line);
            if (!result.equals("Semantic Analysis Successful!")) {
                valid = false;
                break;
            }
        }
        return valid ? "Semantic Analysis Successful!" : "Semantically Incorrect!";
    }

    private String analyzeLine(String line) {
        String result;
        line = line.trim();
        line = line.substring(0, line.length() - 1);

        String[] lineParts = line.split("=");
        String declaration = lineParts[0].trim();
        String value = lineParts[1].trim();

        String[] declarationParts = declaration.split(" ");
        String dataType = declarationParts[0];

        if ("int".equals(dataType)) {
            result = isInteger(value) ? "Semantic Analysis Successful!" : "Semantically Incorrect!";
        } else if ("double".equals(dataType)) {
            result = isDouble(value) ? "Semantic Analysis Successful!" : "Semantically Incorrect!";
        } else if ("String".equals(dataType)) {
            result = (value.startsWith("\"") && value.endsWith("\"")) ? "Semantic Analysis Successful!" : "Semantically Incorrect!";
        } else if ("boolean".equals(dataType)) {
            result = ("true".equals(value) || "false".equals(value)) ? "Semantic Analysis Successful!" : "Semantically Incorrect!";
        } else if ("char".equals(dataType)) {
            result = (value.startsWith("'") && value.endsWith("'") && value.length() == 3) ? "Semantic Analysis Successful!" : "Semantically Incorrect!";
        } else {
            result = "Invalid Input!";
        }

        return result;
    }

    private boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
