# Palindrome Checker

## Overview
This Java application checks if a provided string is a palindrome. It supports multiple languages and offers customized greetings based on the time of day.

## Features
- **Palindrome Verification**: Determines whether the input string is a palindrome.
- **Multilingual Support**: Supports English and French for user interactions.
- **Time-Sensitive Greetings**: Outputs different greetings depending on the time of day.

## Usage
1. Create an instance of `CheckPalindrome` with the chosen language.
2. Use the `verify` method with the string you wish to check.
3. Receive a mirrored string along with appropriate greetings and, if it's a palindrome, a congratulatory message.

## Testing
Tests are built using JUnit and cover several cases:
- **Mirror Functionality**: Ensures the string is returned in reverse.
- **Language-Specific Palindrome Verification**: Validates that palindromes are recognized with language-appropriate responses.
- **Time-Based Greetings**: Checks that greetings are appropriate for the specified time of day.
- **System Language and Time Integration**: Confirms that the application correctly uses the system language and time for greetings.
- **No Final New Line in Output**: Ensures there is no unexpected final newline in the output.

## Builder Pattern
The `CheckPalindromeBuilder` facilitates object creation, allowing for easy configuration of language and time context.

## Conclusion
This exercise demonstrates Java development skills and TDD (Test-Driven Development) practices. Expand your understanding by adding new features or language support!
