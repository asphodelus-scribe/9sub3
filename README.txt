Description:
A basic text cipher in which each letter of the alphabet is mapped to a pair of two integers, a base which may be any integer from 1 to 9, and a subscript of either 1, 2, or 3 (see cipher table below)
Encrypted text is presented as a sequence of headers in their correct order, and text may be decrypted by generating all possible permutations of subscripts of the same length as the input text
then applying each arrangement of subscripts to the given set of bases and checking if the output forms any valid words. This is a computationally intensive and non-functional mapping
in that there is not necessarily only one output for a given input. It is also notably limited in cases where nonstandard words are encrypted. For an example of a word with multiple valid decodings,
"yes" yields a base string of 751, which evaluates to yea, pea, and yes, among 24 other non-word strings.
This project was motivated by the question of how likely a given set of bases was to yield multiple valid output words, a mathematical solution for which would likely be quite involved. 
The total number of possible decodings for an input string of length n is 3^n, owing to the fact that each of the n headers may take on three distinct values.

Cipher Table:
a: 1₁	b: 2₁	c: 3₁
d: 4₁	e: 5₁	f: 6₁
g: 7₁	h: 8₁	i: 9₁
j: 1₂	k: 2₂	l: 3₂
...
y: 7₃	z: 8₃	-: 9₃




