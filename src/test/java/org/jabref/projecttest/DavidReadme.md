## Test Cases

### 1. Test Case: `testFileAnnotationTypeParseValid`

- **Goal**: Verify that the `FileAnnotationType` correctly parses valid annotation subtypes and returns the expected result.
  
- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Validate that the `FileAnnotationType` correctly identifies and processes valid annotation subtypes.
  - **Functionality-based characteristic**: Ensure that the `parse()` method returns the appropriate `FileAnnotationType` enum value for each subtype.

- **Input Domain Modelling**:
  - **Testable function**: `FileAnnotationType.parse(PDAnnotation annotation)`
  - **Parameters**: 
    - `annotation.getSubtype()` (String) - A valid annotation subtype such as `"Text"`.
  - **Return type**: `FileAnnotationType`
  - **Behavior**: The method should return the corresponding `FileAnnotationType` based on the given annotation subtype.

- **Model Input Domain**:
  - **Base subtype**: `"Text"`
  - **Other subtypes**: `"Highlight"`, `"Underline"`

- **Combine Partitions**: 
  - Use **BCC (Base Choice Coverage)**:
    - Base case: subtype = `"Text"`
    - Variation: test with subtypes `"Highlight"`, `"Underline"`

- **Test Values**:
  - **Base case**: `"Text"`
  - **Other cases**: `"Highlight"`, `"Underline"`

- **Expected Behavior**:
  - The `parse()` method should return:
    - `FileAnnotationType.TEXT` for `"Text"`.
    - `FileAnnotationType.HIGHLIGHT` for `"Highlight"`.
    - `FileAnnotationType.UNDERLINE` for `"Underline"`.

---

### 2. Test Case: `testFileAnnotationTypeParseUnknown`

- **Goal**: Verify that the `FileAnnotationType` correctly handles unknown annotation subtypes and returns `UNKNOWN`.

- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Validate that the `FileAnnotationType` handles unknown subtypes correctly.
  - **Functionality-based characteristic**: Ensure that the `parse()` method returns `FileAnnotationType.UNKNOWN` for unrecognized subtypes.

- **Input Domain Modelling**:
  - **Testable function**: `FileAnnotationType.parse(PDAnnotation annotation)`
  - **Parameters**:
    - `annotation.getSubtype()` (String) - An unknown annotation subtype such as `"InvalidSubtype"`.
  - **Return type**: `FileAnnotationType`
  - **Behavior**: The method should return `FileAnnotationType.UNKNOWN` when given an invalid or unrecognized subtype.

- **Model Input Domain**:
  - **Base subtype**: `"Unknown"`
  - **Other subtypes**: `"InvalidSubtype"`

- **Combine Partitions**:
  - Use **BCC (Base Choice Coverage)**:
    - Base case: subtype = `"Unknown"`
    - Variation: test with `"InvalidSubtype"`

- **Test Values**:
  - **Base case**: `"Unknown"`
  - **Other case**: `"InvalidSubtype"`

- **Expected Behavior**:
  - The `parse()` method should return `FileAnnotationType.UNKNOWN` for both cases.

---

### 3. Test Case: `testFileAnnotationTypeIsMarkedFileAnnotationTypeTrue`

- **Goal**: Verify that the `FileAnnotationType` correctly identifies marked annotation subtypes and returns `true`.

- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Validate that the method correctly identifies marked annotation subtypes.
  - **Functionality-based characteristic**: Ensure that the `isMarkedFileAnnotationType()` method returns `true` for marked subtypes.

- **Input Domain Modelling**:
  - **Testable function**: `FileAnnotationType.isMarkedFileAnnotationType(String annotationType)`
  - **Parameters**:
    - `annotationType` (String) - A marked annotation type, such as `"Highlight"`.
  - **Return type**: boolean
  - **Behavior**: The method should return `true` for marked annotation types.

- **Model Input Domain**:
  - **Base annotation type**: `"Highlight"`
  - **Other annotation types**: `"Underline"`

- **Combine Partitions**:
  - Use **BCC (Base Choice Coverage)**:
    - Base case: annotation type = `"Highlight"`
    - Variation: test with `"Underline"`

- **Test Values**:
  - **Base case**: `"Highlight"`
  - **Other case**: `"Underline"`

- **Expected Behavior**:
  - The `isMarkedFileAnnotationType()` method should return `true` for both `"Highlight"` and `"Underline"`.

---

### 4. Test Case: `testFileAnnotationTypeIsMarkedFileAnnotationTypeFalse`

- **Goal**: Verify that the `FileAnnotationType` correctly identifies non-marked annotation subtypes and returns `false`.

- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Validate that the method correctly identifies non-marked annotation subtypes.
  - **Functionality-based characteristic**: Ensure that the `isMarkedFileAnnotationType()` method returns `false` for non-marked subtypes.

- **Input Domain Modelling**:
  - **Testable function**: `FileAnnotationType.isMarkedFileAnnotationType(String annotationType)`
  - **Parameters**:
    - `annotationType` (String) - A non-marked annotation type such as `"Text"`.
  - **Return type**: boolean
  - **Behavior**: The method should return `false` for non-marked annotation types.

- **Model Input Domain**:
  - **Base annotation type**: `"Text"`
  - **Other annotation types**: `"Popup"`

- **Combine Partitions**:
  - Use **BCC (Base Choice Coverage)**:
    - Base case: annotation type = `"Text"`
    - Variation: test with `"Popup"`

- **Test Values**:
  - **Base case**: `"Text"`
  - **Other case**: `"Popup"`

- **Expected Behavior**:
  - The `isMarkedFileAnnotationType()` method should return `false` for both `"Text"` and `"Popup"`.

---

### 5. Test Case: `testFileAnnotationTypeToString`

- **Goal**: Verify the string representation of the `FileAnnotationType`.

- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Validate that the `toString()` method returns the correct string representation of the annotation type.
  - **Functionality-based characteristic**: Ensure that each `FileAnnotationType` has an appropriate string representation.

- **Input Domain Modelling**:
  - **Testable function**: `FileAnnotationType.toString()`
  - **Parameters**:
    - `annotationType` (FileAnnotationType) - A known annotation type such as `FileAnnotationType.TEXT`.
  - **Return type**: String
  - **Behavior**: The `toString()` method should return the correct string representation of the `FileAnnotationType`.

- **Model Input Domain**:
  - **Base annotation type**: `FileAnnotationType.TEXT`
  - **Other annotation types**: `FileAnnotationType.HIGHLIGHT`

- **Combine Partitions**:
  - Use **BCC (Base Choice Coverage)**:
    - Base case: annotation type = `FileAnnotationType.TEXT`
    - Variation: test with `FileAnnotationType.HIGHLIGHT`

- **Test Values**:
  - **Base case**: `FileAnnotationType.TEXT`
  - **Other case**: `FileAnnotationType.HIGHLIGHT`

- **Expected Behavior**:
  - The `toString()` method should return:
    - `"Text"` for `FileAnnotationType.TEXT`.
    - `"Highlight"` for `FileAnnotationType.HIGHLIGHT`.
