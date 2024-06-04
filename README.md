# Software Engineering Lab

## Experiment #8

### Applying Facade Technique

Added 2 Classes `ParserFacade` and `CodeGeneratorFacade` to provide a simplified interface to `Parser` and `CodeGenerator`.
It helps hiding the complexity below and 3rd-parties just see the facades.

### Applying State/Strategy Technique or Polymorphism

Used polymorphism in `SymbolType` enum class to specify `varType` related to each symbol type.
Then replaced switch-cases with `symbolType.varType`.

### Applying Separate Query From Modifier Technique

The `getTemp` and `getDateAddress` methods in `Memory` class were both querying and modifying a field.
Added `updateTempIndex` and `updateDataAddress` methods to separate query from modifier.

### Applying Self Encapsulated Field Technique

Added getters for fields in `Address` class and use the getters to access the fields inside and outside the class.

### Applying Two Other Techniques

- Extracted `loadRules`, `initializeParser`, `shiftAction` and `reduceAction` methods in `Parser` class
- The parameters `className` and `methodName` were used together multiple times. Added `MethodParameters` class to pass these parameters in `SymbolTable`.

### Questions

#### 1

- **Clean Code**: Clean code refers to code that is easy to read, understand, and maintain.
- **Technical Debt**: Technical debt represents the accumulated cost of taking shortcuts or making suboptimal design decisions during software development.
- **Code Smell**: Code smells are warning signs in code that indicate potential issues. They are not bugs but suggest areas where the code could be improved.

#### 2

1. **Bloaters**: Bloaters refer to overly large and complex code that is hard to maintain and understand due to excessive size or redundant elements.
2. **Object-Orientation Abusers**: Object-Orientation Abusers occur when developers misuse object-oriented features or create unnecessary classes, leading to poor design.
3. **Change Preventers**: Change Preventers are code constructs that make it difficult to modify or extend the system.
4. **Dispensables**: Dispensables include unused code, commented-out sections, or redundant variables/functions that clutter the codebase without adding value.
5. **Couplers**: Couplers represent high coupling between classes or modules, making changes in one place affect many others.

#### 3

1. **Category**: The **Lazy Class** code smell falls under the category of Dispensables.
2. **Refactoring Suggestions**: To address this smell, we can do the following refactoring techniques:
   - **Remove Class Technique**: Determine whether the Lazy class serves a purpose in the codebase. If not, remove it.
   - **Inline Class Technique**: Merge the Lazy class with another class that uses it.
3. **When to Ignore**: You can ignore the Lazy Class smell when the class serves a valid purpose or when its functionality is genuinely needed, even if it appears underused.

#### 4  

1. Long Method -> functions longer than 20-30 lines are Long Methods based on uncle Bob's speeches. In this project we see a lot of functions with more than 30 lines that are separable.
2. Large Class -> Phase2CodeFileManipulator class is 576 lines that makes it Large Class.
3. Switching Statements -> switch statement in LexicalAnalyzer could be replaced with Strategy or making a map.
4. Feature Envy -> We see classes that access a lot of data and methods to other classes.
5. Dead Code -> In some classes some methods and attributes or even classes themselves are useless that represents dead code.
6. Speculative Generality -> Some parts of code is created “just in case” to support anticipated future features that never get implemented.
7. Inappropriate Intimacy -> In ClassStructure we have signs of this bad smells wierd interaction with other classes.
8. Temporary Field -> In ClassStructure some fields are on some circumstanses null.
9. Data Class -> ClassNode is just a data class.
10. Refused Bequest -> ValueType and its children have refusred bequest. 


#### 5

The formatter-maven-plugin is a Maven plugin that allows developers to format Java source code using the Eclipse code formatter. 
The plugin's primary purpose is to automate the process of formatting Java source code to adhere to a consistent code style.
Consistent code formatting makes the codebase more readable and maintainable. It helps eliminate visual noise and distractions caused by inconsistent indentation, spacing, and other formatting issues. Automated formatting ensures that the entire codebase adheres to the same formatting rules, even as the project evolves and multiple developers contribute.
The formatter-maven-plugin acts as a tool to simplify and streamline the code reformatting process. It allows developers to define the desired code formatting rules and have them automatically applied to the codebase during the build process. This helps ensure that the codebase maintains a consistent formatting style, which can be especially useful in large, collaborative projects.
Saves time and effort by automating the tedious task of manually reformatting code. Ensures that the codebase adheres to a predefined set of formatting rules, promoting consistency. Can be integrated into the build pipeline, ensuring that code is properly formatted before being merged or deployed. Supports various configuration options, allowing developers to customize the formatting rules to meet project-specific requirements.
