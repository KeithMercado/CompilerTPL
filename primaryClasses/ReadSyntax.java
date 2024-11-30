package com.miniCompiler;

import java.util.List;

public class ReadSyntax {
    public boolean analyze(List<String> parse) {
        String valid = "<data_type> <identifier> <assignment_operator> <value> <delimiter>";

        for (String line : parse) {
            if (!line.trim().equals(valid)) {
                return false;
            }
        }

        return true;
    }
}
