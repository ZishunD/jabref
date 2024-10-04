# Test Case: `testUnicodeConversion`
- **Goal**: Verify that the `UnicodeToReadableCharMap` class correctly converts specific Unicode characters to their readable equivalents, and returns `null` for unmapped or non-Unicode characters.
- **Input Space Partitioning Characteristics**:
    - **Interface-based characteristic**: Validate that the `UnicodeToReadableCharMap` class handles various Unicode characters and converts them appropriately.
    - **Functionality-based characteristic**: Ensure that the `get()` method returns the correct mapped readable character or `null` for unmapped characters.

## Input Domain Modelling:
1. **Testable function**: `UnicodeToReadableCharMap.get(String unicode)`
2. **Parameters**:
    - `unicode` (String)
3. **Return type**: String (the mapped readable character or `null`)
4. **Behavior**: The method should return the mapped readable character for Unicode inputs and `null` for unmapped or ASCII characters.

## Model Input Domain:
- **Mapped Unicode values** (e.g., `\u00C0`, `\u00C4`, `\u00DF`, `\u0178`, `\u00E6`, `\u00D3`, `\u00FC`, `\u00FF`)
- **Non-mapped Unicode and ASCII characters** (e.g., `A`, `Z`, `1`, `@`, `\u2603`)

## Combine Partitions:
- Use **BCC (Base Choice Coverage)** to cover common and edge cases.

## Test Values:
- **Mapped Unicode values**:
    - Input: `\u00C0` (À), Expected: `"A"`
    - Input: `\u00C4` (Ä), Expected: `"Ae"`
    - Input: `\u00DF` (ß), Expected: `"ss"`
    - Input: `\u0178` (Ÿ), Expected: `"Y"`
    - Input: `\u00E6` (æ), Expected: `"ae"`
    - Input: `\u00D3` (Ó), Expected: `"O"`
    - Input: `\u00FC` (ü), Expected: `"ue"`
    - Input: `\u00FF` (ÿ), Expected: `"y"`
- **Non-mapped Unicode and ASCII values**:
    - Input: `"A"`, Expected: `null`
    - Input: `"Z"`, Expected: `null`
    - Input: `"1"`, Expected: `null`
    - Input: `"@"`, Expected: `null`
    - Input: `\u2603` (☃), Expected: `null` (Unmapped Unicode snowman)

## Expected Behavior:
- The `get()` method should return the correct readable character for mapped Unicode inputs and `null` for non-Unicode or unmapped characters.

---

# Test Case: `testIsUnicode`

- **Goal**: Verify that the `isUnicode()` method correctly identifies whether a string contains Unicode characters and the `UnicodeToReadableCharMap` recognizes mapped characters.
- **Input Space Partitioning Characteristics**:
    - **Interface-based characteristic**: Check that the `UnicodeToReadableCharMap.containsKey()` method recognizes the Unicode characters mapped to readable equivalents.
    - **Functionality-based characteristic**: Ensure that the `isUnicode()` helper method detects the presence of Unicode characters.

## Input Domain Modelling:
1. **Testable function**:
    - `UnicodeToReadableCharMap.containsKey(String unicode)`
    - `isUnicode(String str)`
2. **Parameters**:
    - `unicode` (String)
3. **Return type**:
    - `containsKey()`: Boolean (whether the Unicode character exists in the map)
    - `isUnicode()`: Boolean (whether the string contains Unicode characters)
4. **Behavior**: The `containsKey()` method should return `true` for known Unicode characters in the map, and the `isUnicode()` method should return `true` for strings containing Unicode characters.

## Model Input Domain:
- **Unicode characters** (e.g., `\u00C0`, `\u00FC`, `\u1EF9`)
- **ASCII characters** (e.g., `A`, `B`, `1`, `!`)

## Combine Partitions:
- Use **ECC (Each Choice Coverage)** to cover cases with Unicode and ASCII characters.

## Test Values:
- **Unicode values**:
    - Input: `\u00C0` (À), Expected: `true` (is Unicode and mapped)
    - Input: `\u00FC` (ü), Expected: `true`
    - Input: `\u1EF9` (ỹ), Expected: `true`
- **ASCII values**:
    - Input: `"A"`, Expected: `false` (not Unicode)
    - Input: `"B"`, Expected: `false`



# Test Case: `testUnicodeConversion`

- **Goal**: Verify that the `UnicodeToReadableCharMap` class correctly converts Unicode characters to their readable equivalents and returns `null` for unmapped or non-Unicode characters.
- **Input Space Partitioning Characteristics**:
    - **Interface-based characteristic**: Validate that the `UnicodeToReadableCharMap` class correctly handles Unicode characters by mapping them to the expected readable characters.
    - **Functionality-based characteristic**: Ensure that the `get()` method accurately converts specific Unicode characters and returns `null` for characters that are not mapped.

## Input Domain Modelling:
1. **Identify testable function**: `UnicodeToReadableCharMap.get(String unicode)`
2. **Parameters**:
    - `unicode` (String)
3. **Return type**: String (the mapped readable character)
4. **Behavior**: The method should return the mapped readable character for known Unicode inputs or `null` for unmapped or non-Unicode characters.

## Model Input Domain:
- **unicode**: Unicode characters that should be converted and unmapped non-Unicode characters:
    - Mapped Unicode characters (e.g., `\u00C0`, `\u00C4`, `\u00DF`, `\u0178`, `\u00E6`)
    - Non-mapped Unicode characters and ASCII (e.g., `A`, `Z`, `1`, `@`, `\u2603`)

## Combine Partitions:
- Use **BCC (Base Choice Coverage)** to cover common and boundary cases.

## Test Values:
- **Mapped Unicode values**:
    - Input: `\u00C0`, Expected: `"A"`
    - Input: `\u00C4`, Expected: `"Ae"`
    - Input: `\u00DF`, Expected: `"ss"`
    - Input: `\u0178`, Expected: `"Y"`
    - Input: `\u00E6`, Expected: `"ae"`
    - Input: `\u00D3`, Expected: `"O"`
    - Input: `\u00FC`, Expected: `"ue"`
    - Input: `\u00FF`, Expected: `"y"`
- **Unmapped Unicode values**:
    - Input: `A`, Expected: `null`
    - Input: `Z`, Expected: `null`
    - Input: `1`, Expected: `null`
    - Input: `@`, Expected: `null`
    - Input: `\u2603`, Expected: `null` (Unmapped Unicode snowman)

## Expected Behavior:
- The `get()` method should return the correct readable character for mapped Unicode inputs and `null` for unmapped or ASCII characters.

---

# Test Case: `testIsUnicode`

- **Goal**: Verify that the `isUnicode` method correctly identifies whether a string contains Unicode characters, and the `UnicodeToReadableCharMap` correctly recognizes characters that should be mapped.
- **Input Space Partitioning Characteristics**:
    - **Interface-based characteristic**: Validate that the `UnicodeToReadableCharMap.containsKey()` method accurately detects the presence of Unicode characters in the map.
    - **Functionality-based characteristic**: Ensure that the `isUnicode()` helper method detects whether a string contains any non-ASCII characters.

## Input Domain Modelling:
1. **Identify testable function**:
    - `UnicodeToReadableCharMap.containsKey(String unicode)`
    - `isUnicode(String str)`
2. **Parameters**:
    - `unicode` (String)
3. **Return type**:
    - For `containsKey`: Boolean (whether the Unicode character exists in the map)
    - For `isUnicode`: Boolean (whether the string contains Unicode characters)
4. **Behavior**: The `containsKey()` method should return `true` for mapped Unicode characters and `false` otherwise, while `isUnicode()` should return `true` if the string contains Unicode characters.

## Model Input Domain:
- **unicode**: A string that may or may not contain Unicode characters (e.g., `\u00C0`, `\u00FC`, `A`, `1`, `!`)

## Combine Partitions:
- Use **ECC (Each Choice Coverage)** for both Unicode and ASCII characters.

## Test Values:
- **Mapped Unicode values**:
    - Input: `\u00C0` (À), Expected: `true` (exists in map and is Unicode)
    - Input: `\u00FC` (ü), Expected: `true`
- **Non-Unicode and ASCII characters**:
    - Input: `A`, Expected: `false` (does not exist in map and is ASCII)
    - Input: `B`, Expected: `false`
    - Input: `1`, Expected: `false`
    - Input: `!`, Expected: `false`

## Expected Behavior:
- The `containsKey()` method should return `true` for mapped Unicode characters and `false` for unmapped or ASCII characters.
- The `isUnicode()` method should return `true` for Unicode strings and `false` for ASCII strings.

---

