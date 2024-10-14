# Test Case: `testFileAnnotationTypeParse`

- **Goal**: Verify that the `parse` method correctly returns `FileAnnotationType.TEXT` for known types and `UNKNOWN` for unsupported types.
- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Validate that the `parse` method processes both valid and unknown annotation types correctly.
  - **Functionality-based characteristic**: Ensure that the method returns the appropriate `FileAnnotationType` enumeration based on the input.

## Input Domain Modelling:
1. **Identify testable function**: `FileAnnotationType.parse(PDAnnotation annotation)`
2. **Parameters**:
   - `annotation` (PDAnnotation).
3. **Return type**: FileAnnotationType.
4. **Behavior**: The method should return `FileAnnotationType.TEXT` for recognized types and `UNKNOWN` for unrecognized types.

## Model Input Domain:
- **annotation**: 
  - Valid subtype (e.g., `"Text"`).
  - Invalid subtype (e.g., `"img"`).

## Combine Partitions:
- Use **BCC (Base Choice Coverage)** for this case.

## Test Values:
- **Valid Annotation**: `PDAnnotation` with subtype `"Text"`
- **Invalid Annotation**: `PDAnnotation` with subtype `"img"`

## Expected Behavior:
- The method should return `FileAnnotationType.TEXT` for the valid subtype.
- The method should return `FileAnnotationType.UNKNOWN` for the invalid subtype.

---

# Test Case: `testIsMarkedFileAnnotationType`

- **Goal**: Verify that the `FileAnnotationType` correctly identifies marked file annotation types.
- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Ensure that the method can handle both supported and unsupported marked annotation types.
  - **Functionality-based characteristic**: Validate that the method returns `true` for recognized marked types and `false` for unsupported types.

## Input Domain Modelling:
1. **Identify testable function**: `FileAnnotationType.isMarkedFileAnnotationType(String annotationType)`
2. **Parameters**:
   - `annotationType` (String).
3. **Return type**: boolean.
4. **Behavior**: The method should return `true` for supported marked types and `false` for unsupported types.

## Model Input Domain:
- **annotationType**:
  - Supported type (e.g., `"Highlight"`).
  - Unsupported type (e.g., `"LINE"`).

## Combine Partitions:
- Use **BCC (Base Choice Coverage)** for this case.

## Test Values:
- **Supported Type**: `"Highlight"`
- **Unsupported Type**: `"LINE"`

## Expected Behavior:
- The method should return `true` for the supported type.
- The method should return `false` for the unsupported type.
