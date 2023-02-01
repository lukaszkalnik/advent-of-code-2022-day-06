# Advent of code 2022 day 6

## Task

Given a long string and a 4-character (in part 2 14-character) window scanning the string, find the first occurrence
of the window where all characters are unique.

## Solution

I solved it using Kotlin sequences. A sequence has the advantage that it is being evaluated lazily, i.e. only so many
items are produced as required by the terminal function (at the end). This saves memory.
Also sequence always executes the whole transformation chain for subsequent elements, i.e. first for element 0, then
for element 1 all transformations/filters and the terminal function is called.
This lets you have an "early return" if the condition has been fulfilled before the end of the sequence. This can save
execution time.

## What I learned

* `String.windowedSequence(size: Int)`
* `Sequence.windowed()`
* `indexOfFirst()`
* Check if all chars in a string are unique:
    * `string.toSet().size == string.size` O(nlogn)
    * `Map<Char, Boolean>` and set/check if `Char` already found
        * Variation for strings of e.g. lowercase letters only:
          Set/check bits in an `Int` (32 bits vs. 26 letters)