# Mini Compiler  

## Description  
The **Mini Compiler** is a Java-based application with a **Graphical User Interface (GUI)** designed to perform the initial stages of code compilation:  
- **Lexical Analysis**  
- **Syntax Analysis**  
- **Semantic Analysis**  

It accepts `.java` and `.txt` files as input, analyzing their content for errors and correctness to help developers debug their code efficiently.  

---

## Features  
### 1. **Lexical Analysis**  
- Breaks the input into meaningful elements like keywords, identifiers, and symbols.  
- Detects invalid tokens or unrecognized characters.  

### 2. **Syntax Analysis**  
- Verifies code structure against Java grammar rules.  
- Identifies issues such as missing braces or incorrect statement formats.  

### 3. **Semantic Analysis**  
- Checks for logical errors, such as undeclared variables or type mismatches.  

---

## Project Structure  

### Interface Classes (GUI Design)  
- **`CurveTextField.java`**  
  - Custom-styled text field component for enhanced input design.  

- **`RoundedStud.java`**  
  - Custom button component with a rounded design for a user-friendly interface.  

### Core Algorithm and Functionality Classes  
- **`DisplayCompiler.java`**  
  - Main class that integrates the GUI with the compiler logic.  
  - Provides an interface to load files and run analyses.  

- **`ReadLexical.java`**  
  - Implements Lexical Analysis to tokenize input and detect lexical errors.  

- **`ReadSyntax.java`**  
  - Implements Syntax Analysis to parse code and validate structural rules.  

- **`ReadSemantic.java`**  
  - Handles Semantic Analysis to ensure logical consistency in the code.  

---

## Development Environment  
- **IDEs**:  
  - IntelliJ IDEA  
  - Visual Studio Code (VS Code)  

- **Language**:  
  - Java  

### How to use
- ### 1. **Launching the Application**
- Open the Mini Compiler application from your device.
- The application features a user-friendly interface with styled input fields (CurveTextField) and intuitive buttons (RoundedStud).

### 2. **Loading a File**
- Click the **“Load File”** button.
- Choose a `.java` or `.txt` file from your computer that you want to analyze.
- Once loaded, the file content will appear in the display area.

### 3. **Running the Compilation Stages**

The compiler automatically processes the loaded file through the following stages:

#### Lexical Analysis
- The first stage of analysis.
- The compiler breaks the code into **tokens** (keywords, symbols, identifiers, etc.).
- **Errors detected**:
  - Invalid characters (e.g., `@`, `#` outside comments).
  - Variables starting with a digit (e.g., `int 3x = 100;`).

#### Syntax Analysis
- The second stage, which checks the **structure** of the code against Java's grammar rules.
- **Errors detected**:
  - Missing semicolons.
  - Unmatched parentheses or braces.
  - Incorrect statement formatting.

#### Semantic Analysis
- The final stage ensures the **logical correctness** of the code.
- **Errors detected**:
  - Using undeclared variables.
  - Mismatched data types (e.g., assigning an `int` value to a `double` variable).

### 4. **Reviewing and Correcting Errors**
- Errors detected at any stage are displayed in the **error log** with:
  - Type of error (Lexical, Syntax, or Semantic).
  - Error description.
  - Line number.
- Open the file in your code editor, make the necessary corrections, and reload the file into the Mini Compiler for verification.

### 5. **Verifying Corrected Code**
- After making corrections, reload the updated file.
- Repeat the analysis until the compiler confirms the code is error-free.

---

## Example Scenarios

#### Lexical Error Example
- **Input**: `int 3x = 100;`
- **Error**: "Invalid identifier. Variable names cannot start with a digit."
- **Fix**: Change to `int x3 = 100;`.

#### Syntax Error Example
- **Input**: `int x = 100`
- **Error**: "Missing semicolon at line 1."
- **Fix**: Add a semicolon: `int x = 100;`.

#### Semantic Error Example
- **Input**: `double x = 199;`
- **Error**: "Type mismatch: Cannot assign int value to a double variable."
- **Fix**: Use `double x = 199.0;`.

---

## Fully Functional State

You can test the Mini Compiler with an error-free file, such as:

```java
int x = 100;
double y = 50.5;
String name = "Your name";
```
---

## Authors  
- *Bulatao, Luis Joshua D.*  
- *Daanoy, Venus Ruselle B.*  
- *Mercado, John Keith S.*  
