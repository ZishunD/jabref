## Test Case: `testFileAnnotationTypeParseValid`

**Goal**:  
Verify that the `FileAnnotationType.parse()` method correctly determines the `FileAnnotationType` for a valid `PDAnnotation` subtype.

### Input Space Partitioning Characteristics:
- **Interface-based characteristic**: Ensure that the method correctly maps valid `PDAnnotation` subtypes to corresponding `FileAnnotationType` enums.
- **Functionality-based characteristic**: Check that the method returns the correct type when the subtype matches one of the predefined types.

### Input Domain Modelling:
- **Testable function**: `FileAnnotationType.parse(PDAnnotation annotation)`
- **Parameters**:
    - `annotation`: A valid `PDAnnotation` object with a specific subtype.
- **Return type**: `FileAnnotationType` enum.
- **Behavior**: The method should return the appropriate `FileAnnotationType` based on the subtype provided.

### Model Input Domain:
- **PDAnnotation subtype**: `"Text"`, `"Highlight"`, `"Underline"`, etc.

### Test Values:
- **Annotation subtype**: `"Text"` (for this specific case).

### Expected Behavior:
- The `parse()` method should return `FileAnnotationType.TEXT` for a `PDAnnotation` with subtype `"Text"`.

---

## Test Case: `testFileAnnotationTypeParseUnknown`

**Goal**:  
Verify that the `FileAnnotationType.parse()` method returns `UNKNOWN` for an unsupported `PDAnnotation` subtype.

### Input Space Partitioning Characteristics:
- **Interface-based characteristic**: Ensure the method returns `FileAnnotationType.UNKNOWN` when given an unsupported subtype.
- **Functionality-based characteristic**: Check for the correct log message and return behavior for unknown subtypes.

### Input Domain Modelling:
- **Testable function**: `FileAnnotationType.parse(PDAnnotation annotation)`
- **Parameters**:
    - `annotation`: A `PDAnnotation` with an unsupported subtype.
- **Return type**: `FileAnnotationType.UNKNOWN`.
- **Behavior**: The method should return `UNKNOWN` if the subtype does not match any predefined annotation type.

### Model Input Domain:
- **PDAnnotation subtype**: Any string not in the predefined list (e.g., `"InvalidSubtype"`).

### Test Values:
- **Annotation subtype**: `"InvalidSubtype"`.

### Expected Behavior:
- The `parse()` method should return `FileAnnotationType.UNKNOWN` and log an appropriate message.

---

## Test Case: `testFileAnnotationTypeIsMarkedFileAnnotationTypeTrue`

**Goal**:  
Verify that the `FileAnnotationType.isMarkedFileAnnotationType()` correctly identifies supported marked annotation types.

### Input Space Partitioning Characteristics:
- **Interface-based characteristic**: Ensure that the method correctly identifies valid marked annotation types.
- **Functionality-based characteristic**: Check the correctness of the method for known marked types.

### Input Domain Modelling:
- **Testable function**: `FileAnnotationType.isMarkedFileAnnotationType(String annotationType)`
- **Parameters**:
    - `annotationType`: A valid marked annotation type.
- **Return type**: `boolean`.
- **Behavior**: The method should return true for valid marked annotation types.

### Model Input Domain:
- **annotationType**: `"Highlight"`, `"Underline"`, `"Squiggly"`, `"StrikeOut"`.

### Test Values:
- **annotationType**: `"Highlight"`.

### Expected Behavior:
- The method should return `true` for the `"Highlight"` annotation type.

---

## Test Case: `testFileAnnotationTypeIsMarkedFileAnnotationTypeFalse`

**Goal**:  
Verify that the `FileAnnotationType.isMarkedFileAnnotationType()` correctly returns false for unsupported or unmarked annotation types.

### Input Space Partitioning Characteristics:
- **Interface-based characteristic**: Ensure that the method returns false for invalid or unmarked annotation types.
- **Functionality-based characteristic**: Check the correctness of the method for types that are not linked.

### Input Domain Modelling:
- **Testable function**: `FileAnnotationType.isMarkedFileAnnotationType(String annotationType)`
- **Parameters**:
    - `annotationType`: An invalid or unmarked annotation type.
- **Return type**: `boolean`.
- **Behavior**: The method should return false for unsupported or unmarked annotation types.

### Model Input Domain:
- **annotationType**: `"Text"`, `"Line"`, `"Circle"`, `"Unknown"`.

### Test Values:
- **annotationType**: `"Text"`.

### Expected Behavior:
- The method should return `false` for the `"Text"` annotation type.

---

## Test Case: `testFileAnnotationTypeToString`

**Goal**:  
Verify that the `toString()` method of the `FileAnnotationType` enum returns the correct string representation.

### Input Space Partitioning Characteristics:
- **Interface-based characteristic**: Ensure that the `toString()` method correctly returns the string name of the `FileAnnotationType`.
- **Functionality-based characteristic**: Validate that the string name matches the expected value for each enum type.

### Input Domain Modelling:
- **Testable function**: `FileAnnotationType.toString()`
- **Parameters**: None.
- **Return type**: `String`.
- **Behavior**: The method should return the correct string representation of the enum.

### Model Input Domain:
- **FileAnnotationType**: Any valid enum type, e.g., `TEXT`, `HIGHLIGHT`, etc.

### Test Values:
- **FileAnnotationType**: `FileAnnotationType.TEXT`.

### Expected Behavior:
- The `toString()` method should return `"Text"` for `FileAnnotationType.TEXT`.

---
