# 🖥️ Mini Compiler  

## 📖 Description  
The **Mini Compiler** is a Java-based application with a **Graphical User Interface (GUI)** designed to perform the initial stages of code compilation:  
- **Lexical Analysis**  
- **Syntax Analysis**  
- **Semantic Analysis**  

It accepts `.java` and `.txt` files as input, analyzing their content for errors and correctness to help developers debug their code efficiently.  

---

## ✨ Features  
### 1. **Lexical Analysis**  
- Breaks the input into meaningful elements like keywords, identifiers, and symbols.  
- Detects invalid tokens or unrecognized characters.  

### 2. **Syntax Analysis**  
- Verifies code structure against Java grammar rules.  
- Identifies issues such as missing braces or incorrect statement formats.  

### 3. **Semantic Analysis**  
- Checks for logical errors, such as undeclared variables or type mismatches.  

---

## 🏗️ Project Structure  

### **Interface Classes (GUI Design)**  
- **`CurveTextField.java`**  
  - Custom-styled text field component for enhanced input design.  

- **`RoundedStud.java`**  
  - Custom button component with a rounded design for a user-friendly interface.  

### **Core Algorithm and Functionality Classes**  
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

## 💻 Development Environment  
- **IDEs**:  
  - IntelliJ IDEA  
  - Visual Studio Code (VS Code)  

- **Language**:  
  - Java  

---

## 🚀 How to Use  

-leave blank muna natin until we finish our project

---

## 👥 Authors  
- **Bulatao, Luis Joshua D.**  
- **Daanoy, Venus Ruselle B.**  
- **Mercado, John Keith S.**  
