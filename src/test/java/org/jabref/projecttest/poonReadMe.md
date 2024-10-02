# Test Case: `testPageContent`

- **Goal**: Verify that the `Page` class correctly stores and returns the content, and ensure the content is unchangeable.
- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Validate that the `Page` class correctly stores the content passed to it and that the content is immutable.
  - **Functionality-based characteristic**: Ensure that the `getContent()` method accurately returns the stored content, and verify that the returned collection cannot be modified.

## Input Domain Modelling:
1. **Identify testable function**: `Page(String query, int pageNumber, Collection<T> content)`
2. **Parameters**:
   - `query` (String)
   - `pageNumber` (int)
   - `content` (Collection of type T).
3. **Return type**: Collection of type T.
4. **Behavior**: The method should return an unmodifiable collection containing the elements of the content.

## Model Input Domain:
- **content**: A collection of non-null strings (e.g., `["Moon", "Sun", "Cloud"]`).
- **query**: A valid string (e.g., `"TestQuery"`).
- **pageNumber**: A positive integer (e.g., `1`).

## Combine Partitions:
- Use **ACoC (All Combinations Coverage)** for this case.

## Test Values:
- **query**: `"TestQuery"`
- **pageNumber**: `1`
- **content**: `["Moon", "Sun", "Cloud"]`

## Expected Behavior:
- The `getContent()` method should return a collection containing `["Moon", "Sun", "Cloud"]`.
- Attempting to modify this collection (e.g., by adding `"Rainbow"`) should throw an `UnsupportedOperationException`.

---

# Test Case: `testEmptyPage`

- **Goal**: Verify that the `Page` class correctly handles an empty page (no content) and returns the correct page number and query.
- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Validate that the `Page` class can correctly handle an empty content scenario and returns an empty collection.
  - **Functionality-based characteristic**: Ensure that the `getContent()`, `getSize()`, `getPageNumber()`, and `getQuery()` methods return expected results for an empty page.

## Input Domain Modelling:
1. **Identify testable function**: `Page(String query, int pageNumber)`
2. **Parameters**:
   - `query` (String)
   - `pageNumber` (int).
3. **Return type**: Various methods return a collection (for content), an integer (for page number), and a string (for query).
4. **Behavior**: The `Page` object should return an empty collection for content, a page size of 0, and the correct query and page number.

## Model Input Domain:
- **query**: A valid string (e.g., `"TestQuery"`).
- **pageNumber**: A positive integer (e.g., `1`).

## Combine Partitions:
- Use **ECC (Each Choice Coverage)** for this case.

## Test Values:
- **query**: `"TestQuery"`
- **pageNumber**: `1`

## Expected Behavior:
- The `getContent()` method should return an empty collection.
- The `getSize()` method should return `0`.
- The `getPageNumber()` method should return `1`.
- The `getQuery()` method should return `"TestQuery"`.

---

# Test Case: `testNullQuery`

- **Goal**: Verify that the `Page` class correctly handles a null query.
- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Handle cases where the query string is `null`.
  - **Functionality-based characteristic**: Ensure that the `getContent()`, `getPageNumber()`, and `getQuery()` methods still function correctly when the query is `null`.

## Input Domain Modelling:
1. **Testable function**: `Page(String query, int pageNumber, Collection<T> content)`
2. **Parameters**:
   - `query` (which can be `null`)
   - `pageNumber`
   - `content`
3. **Return type**:
   - The `getContent()` and `getPageNumber()` should return valid results even with a `null` query.
4. **Behavior**: Ensure that the `Page` still works as expected when the query is `null`.

## Model Input Domain:
- **query**: `null`
- **pageNumber**: Positive integer (e.g., `2`).
- **content**: A collection of strings (e.g., `["Star", "Planet", "Galaxy"]`).

## Test Values:
- **query**: `null`
- **pageNumber**: `2`
- **content**: `["Star", "Planet", "Galaxy"]`

## Expected Behavior:
- The `getContent()` method should return a collection containing `["Star", "Planet", "Galaxy"]`.
- The `getPageNumber()` method should return `2`.
- The `getQuery()` method should return `null`.
