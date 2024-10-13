# Unit Test Documentation
#### Unnamed_404
(Editing in Progress)

---
### Project: JabRef
- **Build**: Gradle
- **Package Name**: `projecttest`
### List of Test Suites in the Package
1. `PagingTest`: ACoC, (ECC)*
2. `PaginationTest`: M-BCC, (BCC)*
3. `SearchFlagCombTest`: M-BCC*
4. `CitationKeyTest`: ACoC*
5. `UnicodeMapTest`: ECC*
6. `testGetSearchExpression`
7. `testEqualsAndHashCode`: PWC
8. `testIsDynamic`: ECC
9. `testDeepCopy`: BCC
10. `testSetMatchedEntries`: BCC
11. `testSetSearchExpressionAndFlags`: -
12. `testRemoveMatchedEntry`
13. `SearchQueryTest`: PWC*
14. `testSearchExpressionMatches`
15. `NullQueryTest`*Discarded

---
## -- Paging --

## Test Suite 1: `PagingTest`
**Goal**: Verify that the `Page` class correctly stores
and returns the content, and ensure the content is unchangeable.
- **Testable Function**: `getContent` method in the `Page` class.
- **Parameter**: The method uses the variable from `Page`'s parameter.
    - `query` *(String)*
    - `pageNumber` *(int)*
    - `content` *(Collection of type `T`)*
    - However, the only field that affects the method is `content`.
- **Return Type**: `Collection<T>`
- **Return Values**:
    - A non-empty collection if content exists in the page.
    - An empty collection if the content in page is empty.
- **Exceptional Behaviour**: With `Collections.unmodifiableCollection()`, any attempt to modify the content
should throw an `UnsupportedOperationException`.

    
- **Input Space Partitioning Characteristics**:
    - **Interface-based characteristic**:
      - C1: The number of items inside the collection
    - **Functionality-based characteristic**:
      - C2: Existence of duplicate items inside the collection

### Model Input Domain:
1. **Content Size Domain**: 
   - Empty collection `(size = 0)`
   - Single-element collection `(size = 1)`
   - Multiple-element collection `(size > 1)`
2. **Duplication Domain**:
   - No content duplicated: `(["Moon", "Sun", "Star"])`
   - Content duplicated: `(["Moon", "Sun", "Sun"])`
3. **Modification Behaviour**:
   - Attempt to modify the collection after retrieval should throw `UnsupportedOperationException`.

### Combine Partitions:
#### Using **ACoC (All Combinations Coverage)**: 
  - Content size: {0, 1, >1}.
  - Duplicated content: {True, False}.

**Test Values and Expected Values**
- Number of Tests: 3*2 = 6
- However, it is not possible to have duplicated item with the number of item lower than 2.
- Number of Real Tests: 4
  
  | **Test Case** | **Size** | **Collection Value**  | **Duplication** | **Expected Value** |
  |---------------|----------|-----------------------|-----------------|--------------------|
  | 1             | 0        | []                    | False           | Empty collection   |
  | 2             | 1        | ["Moon"]              | False           | Moon               |
  | 3             | 3        | ["Moon","Sun","Star"] | False           | Moon, Sun, Star    |
- | 4             | 3        | ["Moon","Sun","Sun"]  | True            | Moon, Sun, Sun     |

- Test case 1: `EmptyCollectionTest`
- Test case 2: `SingleCollectionTest`
- Test case 3: `MultipleCollectionTest`
- Test case 4: `DuplicatedCollectionTest`

#### Using **ECC (Each Choice Coverage)**:
- Content size: {3}
- Duplicated content: {True, False}.

**Test Values and Expected Values**
- Number of Tests: Highest = 2

  | **Test Case** | **Size** | **Collection Value**  | **Duplication** | **Expected Value** | 
  |---------------|----------|-----------------------|-----------------|--------------------|
  | 1             | 3        | ["Moon","Sun","Star"] | False           | Empty collection   |
  | 2             | 3        | ["Moon","Sun","Sun"]  | True            | Empty collection   |
- Both of the test cases are already covered by ACoC

---

## Test Suite 2: `PaginationTest`
- **Goal**: Verify that the `Page` class correctly returns page numbers.
- **Testable Function**: `getPageNumber` method in the `Page` class.
- **Parameter**: The method uses the variable from `Page`'s parameter.
    - `query` *(String)*
    - `pageNumber` *(int)*
    - `content` *(Collection of type `T`)*
    - However, the only field that affects the method is `pageNumber`.
- **Return Type**: `int`
- **Return Values**:
    - Only a positive integer.
- **Exceptional Behaviour**:
    - Any illegal page number
should throw a `IllegalArgumentException`.


- **Input Space Partitioning Characteristics**:
    - **Interface-based characteristic**:
        - C1: The value of the page number
    - **Functionality-based characteristic**:
        - C2: The existence of the content in the page

### Model Input Domain:
1. **Page Number Value**:
    - Negative number: `(num < 0)`
    - 1 or above: `(num >= 1)`
    - No page: `(num = 0)`
2. **Correct Number**:
    - The page is empty: `(True)`
    - The page is not empty (has content): `(False)`
3. **Illegal Value**:
    - Illegal number should throw `IllegalArgumentException`.

### Combine Partitions:
#### Using **M-BCC (Multiple Base Choice Coverage)**:
- Content size: {<0, 0, >=1}.
- Empty page: {True,False}.

**Test Values and Expected Values**
- Base tests: (int = -1, empty = True), (int = 0, empty = False)
- Number of Tests: 2+((3-2)+(2-2)) = 3


| **Test Case** | **Value Domain** | **pageNumber** | **Empty Content** | **Expected Result** | 
|---------------|------------------|----------------|-------------------|---------------------|
| 1 (base)      | negative         | -1             | True              | Exception           |
| 2 (base)      | zero             | 0              | False             | No page             |
| 3             | 1 or above       | 3              | False             | 3                   |

- Test case 1: `testNegativePageNumber`
- Test case 2: `testPageNumberZero`
- Test case 3: `testPositivePageNumber`

#### Using **BCC (Base Choice Coverage)**:
- Content size: {<0, 0, >=1}.
- Empty page: {True,False}.

**Test Values and Expected Values**
- Base tests: (int = 3, empty = True)
- Number of Tests: 1+((3-1)+(2-1)) = 4

| **Test Case** | **Value Domain** | **pageNumber** | **Empty Content** | **Expected Result** | 
|---------------|------------------|----------------|-------------------|---------------------|
| 1 (base)      | Positive         | 3              | True              | 3                   |
| 2             | zero             | 0              | False             | No page             |
| 3             | Negative         | -1             | False             | Exception           |
| 4             | Positive         | 3              | False             | 3                   |

- Test case 4: `testNoContentPageNumber`
- Test case 5: `testNegWithContentPageNumber`
- Other domains are already covered by MBCC.

---
## Test Suite 3: `SearchFlagCombTest`
- **Goal**: Verify how different combinations of search flags in `SearchGroup` class are correct when enabled multiple flags.
- **Testable Function**: `getSearchFlags` in the `SearchGroup` class.
- **Parameter**: The method uses the variable from `SearchGroup`'s parameter.
  - `name` *String*
  - `context` *GroupHierarchyType*
  - `searchExpression` *String*
  - `searchFlags` *EnumSet\<SearchFlags>*
  -  However, the only field that affects the method is `searchFlags`.
- **Return Type**: `EnumSet\<SearchFlags>`
- **Return Values**:
  - The method is expected to return the enabled search flags of a `SearchQuery` object. 
- **Exceptional Behaviour**: -


- **Input Space Partitioning Characteristics**:
    - **Interface-based characteristic**:
        - C1: The type of search flags
    - **Functionality-based characteristic**:
        - C2: The existence of Fulltext flag, 
      as the flag is for an advance search that search beyond the content and tends to face many error.

### Model Input Domain:
1. **Flag Type Combination**:
    - Flag for regex search: `(REGULAR_EXPRESSION)`
    - Flag for advance search: `(FULLTEXT)`
    - Flag for case-sensitive search: `(CASE_SENSITIVE)`
    - Two flags Combinations: 
      - `(REGULAR_EXPRESSION,FULLTEXT)`
      - `(REGULAR_EXPRESSION,CASE_SENSITIVE)`
      - `(FULLTEXT,CASE_SENSITIVE)`
    - Three flags Combination: `(REGULAR_EXPRESSION,FULLTEXT,CASE_SENSITIVE)`
    - No flag: `()`
2. **Fulltext Enabled**:
    - No Fulltext: `False`
    - Contain Fulltext: `True`

### Combine Partitions:
#### Using **M-BCC (Multiple Base Choice Coverage)**:
- Flag Type: {Regex, Fulltext, Sensitive}.
- Flag Enum Length: {0,1,2,3}.

**Test Values and Expected Values**
- Base tests: (type = {Regex}, contain = False), (type = {Fulltext}, contain = True)
- Number of Tests: 2+((8-2)+(2-2)) = 8

| **Test Case** | **Type**                   | **Contain Fulltext** | **Expected Result**      | 
|---------------|----------------------------|----------------------|--------------------------|
| 1 (base)      | {Regex}                    | False                | Regex                    |
| 2 (base)      | {Fulltext}                 | True                 | Fulltext                 |
| 3             | {Sensitive}                | False                | Sensitive                |
| 4             | {Fulltext,Sensitive}       | True                 | Fulltext,Sensitive       |
| 5             | {Regex,Fulltext}           | True                 | Regex,Fulltext           |
| 6             | {Regex,Sensitive}          | False                | Regex,Sensitive          |
| 7             | {Regex,Fulltext,Sensitive} | True                 | Regex,Fulltext,Sensitive |
| 8             | {}                         | False                | No flag                  |

- Test case 1: `testFlag1`
- Test case 2: `testFlag2`
- Test case 3: `testFlag3`
- Test case 4: `testFlag4`
- Test case 5: `testFlag5`
- Test case 6: `testFlag6`
- Test case 7: `testFlag7`
- Test case 8: `testFlag8`

---

## Test Suite 4: `CitationKeyTest`
- **Goal**: Verify that the `Citation` class correctly handles valid and invalid citation keys by checking with `BibDatabase` class and returns the expected lookup results.
- **Testable Function**: `getLookupResult` in the `Citation` class.
- **Parameter**: The method uses the variable from `Citation`'s parameter.
    - `citationKey` *String*
    -  The citation key will be used in `CitationLookupResult` to look up for databases.
- **Return Type**: `Optional<CitationLookupResult> db`
- **Return Values**:
    - The method is expected to return the database according to the citation key.
  However, the test used `citation.getLookupResult().isPresent()` which return a boolean value.
- **Exceptional Behaviour**: -


- **Input Space Partitioning Characteristics**:
    - **Interface-based characteristic**:
        - C1: The type of citation key
    - **Functionality-based characteristic**:
        - C2: The existence of citation key

### Model Input Domain:
1. **Key Type**:
    - Valid key
    - Invalid key
2. **Key Exist**:
    - No key: `False`
    - Has a key: `True`

### Combine Partitions:
#### Using **ACoC (All Combinations Coverage)**:
- Key Type: {valid, invalid}.
- Key Existence: {True,False}.

**Test Values and Expected Values**
- Number of Tests: 2*2 = 4 tests
- However, when there is a key, the key existence can only be true.
- Real Number of Tests: 3 tests

| **Test Case** | **Type** | **Exist** | **Expected Result**    | 
|---------------|----------|-----------|------------------------|
| 1             | Valid    | True      | Can find db (True)     |
| 2             | Invalid  | True      | Cannot find db (False) |
| 3             | No key   | False     | Cannot find db (False) |

- Test case 1: `testValidKey`
- Test case 2: `testInvalidKey`
- Test case 3: `testNoKey`

---

## Test Suite 5: `UnicodeMapTest`
- **Goal**: Verify that the `UnicodeToReadableCharMap` class correctly converts specific Unicode characters to their readable equivalents, and returns `null` for unmapped or non-Unicode characters.
- **Testable Function**: `get` method that is an extension of `HashMap` from `java.util.HashMap`.
- **Parameter**: The method uses the variable from `HashMap`'s parameter.
    - `string` *String*
- **Return Type**: `String`
- **Return Values**:
    - The method is expected to return the string that mapped in unicode.
  This string will then be used to check with `assertEquals` which return a boolean value.
- **Exceptional Behaviour**: -

- **Input Space Partitioning Characteristics**:
    - **Interface-based characteristic**:
        - C1: Mapped/Unmapped characters
    - **Functionality-based characteristic**:
        - C2: English/Non-english alphabets

### Model Input Domain:
1. **Mapped/Unmapped**:
    - Mapped key: `True` (e.g. A, Oe, ij, ss)
    - Unmapped key: `False` (e.g. @, 1, æ, empty string)
2. **English/Non-english**:
    - English: `True` (e.g. A, O, u)
    - Non-english: `False` (e.g. æ, Ỹ, À)

### Combine Partitions:
#### Using **PWC (Pair-Wise Coverage)**:
- Mapped/Unmapped: {True, False}.
- English/Non-english: {True,False}.

**Test Values and Expected Values**
- Number of Tests: 2*2 = 4 tests

| **Test Case** | **Mapped/Unmapped**          | **English/Non-english** | **Expected Result** | 
|---------------|------------------------------|-------------------------|---------------------|
| 1             | Mapped (A)                   | True                    | True (\u00C0)       |
| 2             | Mapped (ae)                  | False                   | True (\u00E6)       |
| 3             | Unmapped (Regular ASCII 'A') | True                    | False  (Null)       |
| 4             | Unmapped (@)                 | False                   | False  (Null)       |

- Test case 1: `testMapEng`
- Test case 2: `testMapNoEng`
- Test case 3: `testUnmapEng`
- Test case 4: `testUnmapNoEng`

---
