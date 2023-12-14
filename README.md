# Palindrome Checker Exercise

## Overview
This Java application checks if a provided string is a palindrome, supporting multiple languages and customized greetings based on the time of day.

## Features
- **Palindrome Verification**: Determines if the input string is a palindrome.
- **Multilingual Support**: English and French language support for user interaction.
- **Time-Sensitive Greetings**: Outputs greetings that vary depending on the time of day.

## Usage
1. Create an instance of `CheckPalindrome` with the chosen language.
2. Use the `verify` method with the string you wish to check.
3. Receive a mirrored string along with appropriate greetings and, if it's a palindrome, a congratulatory message.

## Testing
Tests are built using JUnit and cover several cases:
- **Mirror Functionality**: Ensures the string is returned in reverse.
- **Language-Specific Palindrome Verification**: Validates that palindromes are recognized with language-appropriate responses.
- **Time-Based Greetings**: Checks that greetings are appropriate for the specified time of day.

## Builder Pattern
The `CheckPalindromeBuilder` facilitates object creation, allowing for easy configuration of language and time context.

Explore the `test` package for examples and the `main` package for the core logic.

## Conclusion
This exercise demonstrates Java development skills, internationalization, polymorphism, and TDD practices. Expand your understanding by adding new features or language supports!
