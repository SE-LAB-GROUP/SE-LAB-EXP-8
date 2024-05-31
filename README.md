# Software Engineering Lab

## Experiment #8

### Applying Facade Technique

### Applying State/Strategy Technique or Polymorphism

Used polymorphism in `SymbolType` enum class to specify `varType` related to each symbol type.
Then replaced switch-cases with `symbolType.varType`.

### Applying Separate Query From Modifier Technique

The `getTemp` and `getDateAddress` methods in `Memory` class were both querying and modifying a field.
Added `updateTempIndex` and `updateDataAddress` methods to separate query from modifier.

### Applying Self Encapsulated Field Technique

Added getters for fields in `Address` class and use the getters to access the fields inside and outside the class.

### Applying Two Other Techniques
