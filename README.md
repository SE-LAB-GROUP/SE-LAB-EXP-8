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

#### 5
