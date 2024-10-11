# SearchQueryTest Class Documentation
# Test Case: `SearchQueryTest`

- **Goal**: Verify how `SearchQuery` class handle different type of query string and determine how it will process based on `SearchFlags`.
- **Input Space Partitioning Characteristics**:
  - **Interface-based characteristic**: Validate that different given query in `SearchQuery` can handle different flag combinations correctly.
  - **Functionality-based characteristic**: Ensure that all querry as normal plain text, text with special characters, and text with regular expressions searches are treated properly based on the provided flags.

## Input Domain Modelling:
1. **Identify testable function**: `SearchQuery(String query, EnumSet<SearchFlags> searchFlags)`
2. **Parameters**:
    - `query` (String): The search query string, which may contain special characters(Regex).
    - `searchFlags` (EnumSet<SearchFlags>): Flags indicating how the query should be processed (e.g., regular expression search, full-text search).
3. **Return type**: Various methods return a collection of search words, an optional `Pattern`, or a string indicating the search expression.
4. **Behavior**: The method should return valid search words, handle special characters appropriately, and return expected results based on the flags set.

## Model Input Domain:
- **query**: A string that come in form of plain text or may contain special characters (e.g., `Destiny`, `"a+b*c?d"`).
- **searchFlags**: An `EnumSet` indicating the search mode (e.g., `EnumSet.noneOf(SearchFlags.class)`, `EnumSet.of(SearchFlags.REGULAR_EXPRESSION)`).
## Combine Partitions:
- Use **PWC (Pairwise Testing)** for this case.

## Test Values:
- **query**:
    - `"a+b*c?d"` (Query that contains special characters)
    - `"Destiny", "space research",` (For valid query)
    - `"", "John[Halo",` (For invalid query)
- **searchFlags**:
    - `EnumSet.noneOf(SearchFlags.class)` (no flags)
    - `EnumSet.of(SearchFlags.REGULAR_EXPRESSION)` (regular expression flag)
    - `EnumSet.of(SearchFlags.FULLTEXT)` (full-text flag)
    - `EnumSet.of(SearchFlags.REGULAR_EXPRESSION, SearchFlags.FULLTEXT)` (both flags)

## Expected Behavior:
1. **Test Case 1**: 
    When the query is `"Destiny"` with no flags:
    - The `isValid()` method should return `true`.
    - The `getSearchExpression()` method should return `Destiny`.

2. **Test Case 2**: 
    When the query is `"a+b*c?d"` with regular expression and fulltext flag:
    - The `isValid()` method should return `true`.
    - The `getSearchWords()` method should return `["a+b*c?d"]`.
    - The expected pattern should be `"(a\\+b\\*c\\?d)"`.

3. **Test Case 3**: 
    When the query is `""` (empty) with no flags:
    - The `isValid()` method should return `false`.
    - The `getSearchWords()isEmpty()` method should return `true`.
    - The `getSearchExpression()` should return `""` (empty).

4. **Test Case 4**: 
   When the query is `"space research"` with full-text flag:
    - The `isValid()` method should return `true`.
    - The `getSearchExpression()` method should return query `["space research"]`.

5. **Test Case 5**: 
   When the query is Invalid `John[Halo`  with regular expression and fulltext flag:
    - The `isValid()` method should return `false`.
    - This making `getParsedQuery()` method should return null.
    - The `parseError` should contain an appropriate error message

6. **Test Case 6**: 
   When the query is `"a+b*c?d"` with no flags:
    - The `isValid()` method should return `true`.
    - The `getPatternForWords()` should return null since no regex expression enabled causing `pattern.isPresent()` return `false`.
    - The pattern should be escape through literal pattern String for the specified String `Pattern.quote("a+b*c?d")`.
    - The expected pattern should be `"\Qa+b*c?d\E"`.
---
# CitationTest Class Documentation

# Test Case: `testConstructorKey`
**Goal:**
Verify that the `Citation` class correctly handles valid and invalid citation keys by checking with `BibDatabase` class and returns the expected lookup results.

### Input Space Partitioning Characteristics:
- **Interface-based characteristic:**
    - Validate that the `Citation` class can correctly handle both valid and invalid citation keys, including an empty string.

- **Functionality-based characteristic:**
    - Ensure that the `lookupInDatabases()` method accurately checks for the existence of a citation key within provided `BibDatabase`  and that the `getLookupResult()` method returns the Optional result within same key.

### Input Domain Modelling:
- **Identify testable function:**
  `Citation(String citationKey)`

- **Parameters:**
    - `citationKey` (String): The citation key being constructed and validated.

- **Return type:**
    - Various methods return:
      `Optional<BibDatabase>` for the lookup result if it valid or invalid key.

- **Behavior:**
    - The Citation object should return a present value for a valid citation key if it exist, and an empty optional for an invalid key or an empty string.

### Model Input Domain:
- **Input Key:**
    - `citationKey`: A valid string (e.g., "Captain2024").
    
### Combine Partitions:
- **Use ECC (Each Choice Coverage)** for this case.

### Test Values:
- **Valid Key:**
    - `citationKey`: "Captain2024"

- **Invalid Key:**
    - `citationKey`: "Jeremy2003"

- **Empty Key:**
    - `citationKey`: ""

### Expected Behavior:
1. For a valid citation key ("Captain2024"):
    - `getLookupResult().isPresent()` should return `true`.

2. For an invalid citation key ("Jeremy2003"):
    - `getLookupResult().isPresent()` should return `false`.

3. For an empty citation key (""):
    - `getLookupResult().isPresent()` should return `false`.

---

