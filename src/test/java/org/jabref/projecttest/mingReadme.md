# Test Suite: `SearchGroupTest`

This test suite ensures the correctness of the `SearchGroup` class, verifying that its methods perform as expected under different scenarios.

---

## Test Case: `testSearchExpressionMatches`

- **Goal**: Verify that the `SearchGroup` class can correctly match entries based on the search expression and update the matched entries.

### Input Domain Modelling:
1. **Testable function**: `updateMatches(BibEntry entry, boolean isMatch)`
2. **Parameters**:
    - `entry1`: A BibEntry with the title `"Introduction to Java"`.
    - `entry2`: A BibEntry with the title `"Python Basics"`.
3. **Return type**: The `contains(BibEntry)` method checks whether the entry matches the search expression.

### Test Values:
- `entry1`: Title: `"Introduction to Java"`, Author: `"John Doe"`
- `entry2`: Title: `"Python Basics"`, Author: `"Jane Doe"`

### Expected Behavior:
- `searchGroup.updateMatches(entry1, true)` should add `entry1` to the matched entries.
- The `contains(entry1)` method should return `true`, while `contains(entry2)` should return `false`.

---

## Test Case: `testRemoveMatchedEntry`

- **Goal**: Verify that the `SearchGroup` correctly removes an entry that was previously matched.

### Input Domain Modelling:
1. **Testable function**: `updateMatches(BibEntry entry, boolean isMatch)`
2. **Parameters**:
    - `entry1`: A BibEntry with the title `"Introduction to Java"`.
3. **Return type**: Boolean value indicating whether the entry is in the matched set.

### Test Values:
- `entry1`: Title: `"Introduction to Java"`, Author: `"John Doe"`

### Expected Behavior:
- After matching `entry1`, calling `updateMatches(entry1, false)` should remove it from the set of matched entries.
- `contains(entry1)` should return `false`.

---

## Test Case: `testGetSearchExpression`

- **Goal**: Verify that the `SearchGroup` returns and updates the search expression correctly.

### Input Domain Modelling:
1. **Testable function**: `getSearchExpression()`, `setSearchExpression(String searchExpression)`
2. **Parameters**:
    - Initial search expression: `"title=java"`
    - Updated search expression: `"author=jane"`
3. **Return type**: String representing the current search expression.

### Test Values:
- Initial expression: `"title=java"`
- Updated expression: `"author=jane"`

### Expected Behavior:
- `getSearchExpression()` should return the initial expression `"title=java"`.
- After updating, `getSearchExpression()` should return `"author=jane"`.

---

## Test Case: `testEqualsAndHashCode`

- **Goal**: Test equality and hashcode functionality for the `SearchGroup` class.

### Input Domain Modelling:
1. **Testable function**: `equals()`, `hashCode()`
2. **Parameters**:
    - `sameGroup`: A `SearchGroup` with the same attributes as `searchGroup`.
    - `differentGroup`: A `SearchGroup` with different attributes.
3. **Return type**: Boolean for `equals()` and integer for `hashCode()`.

### Test Values:
- `sameGroup`: `"TestGroup"`, `"title=java"`
- `differentGroup`: `"AnotherGroup"`, `"title=python"`

### Expected Behavior:
- `equals(sameGroup)` should return `true` and `hashCode()` should match for both groups.
- `equals(differentGroup)` should return `false` and `hashCode()` should differ.

---

## Test Case: `testIsDynamic`

- **Goal**: Verify that the `isDynamic()` method correctly identifies if the search group is dynamic.

### Input Domain Modelling:
1. **Testable function**: `isDynamic()`
2. **Return type**: Boolean indicating whether the group is dynamic.

### Expected Behavior:
- The `isDynamic()` method should return `true` for `SearchGroup` with a search expression.

---

## Test Case: `testDeepCopy`

- **Goal**: Ensure that `deepCopy()` creates a correct deep copy of the `SearchGroup`.

### Input Domain Modelling:
1. **Testable function**: `deepCopy()`
2. **Return type**: A new instance of `SearchGroup`.

### Expected Behavior:
- The deep copy should not be the same instance as the original but should be equal in terms of attributes.

---

## Test Case: `testSetMatchedEntries`

- **Goal**: Verify that the `setMatchedEntries()` method correctly assigns matched entries.

### Input Domain Modelling:
1. **Testable function**: `setMatchedEntries(Set<String> matchedEntries)`
2. **Parameters**:
    - A set containing the ID of `entry1`.
3. **Return type**: Boolean indicating whether the entry is matched.

### Test Values:
- A set containing the ID of `entry1`.

### Expected Behavior:
- After setting the matched entries, `contains(entry1)` should return `true` and `contains(entry2)` should return `false`.

---

## Test Case: `testSetSearchExpressionAndFlags`

- **Goal**: Verify that both the search expression and search flags can be set correctly.

### Input Domain Modelling:
1. **Testable function**: `setSearchExpression(String searchExpression)`, `setSearchFlags(EnumSet<SearchFlags> searchFlags)`
2. **Parameters**:
    - Search expression: `"author=doe"`
    - Search flags: `EnumSet.of(SearchFlags.CASE_SENSITIVE)`
3. **Return type**: String for the search expression and EnumSet for search flags.

### Expected Behavior:
- The search expression should be updated to `"author=doe"`.
- The search flags should be updated to `CASE_SENSITIVE`.
