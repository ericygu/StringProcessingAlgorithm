# StringProcessingAlgorithm
Given a dictionary and a string with no whitespace, this program can determine whether or not spaces can be inserted into the string
so that each resulting word exists in the dictionary. To make things efficient, the dictionary was preprocessed into a trie (Trie.java) and the splitting was found via dynamic programming. 

My program accepts the following input as an example:
java WordSplitter [dictionary] [string]
and the output is the string with spaces inserted, or “No splitting found.” if no
such splitting exists. 

For example, using the sample words.txt and running
java WordSplitter words.txt thisisthereason
the output is:
"this is the reason"

Meanwhile, while running
java WordSplitter words.txt zzzyyyxxx
gives the output
No splitting found.

For the dynamic programming portion of WordSplitter, the final idea was to iteratively
check the string inserted char by char, adding it to an empty string storedWord to decide one of
two things - to add a space or to continue adding characters. This decision was dynamic
programming, in the sense that there would be an initial check for the first char (and continuous
chars) if it was in the dictionary and adding them if there was no match, meanwhile recursively
checking through a wordSplit(s) (called stringRecursion, which didn’t contain the initial
storedWord chars) once there was a word found in the dictionary that matched the storedWord,
making sure the wordSplit(s) of stringRecursion was still viable. What happened then, if the
wordSplit(s) was not viable, more letters would be added until that viability was the case. Once
the entire string was viable, a ‘space’ would be added to the initial word checked which was the
result of the initial storedWord. If all letters have been added and checked, and wordSplit is still
not viable, then it would return “No splitting found.” Splitting was reconstructed after computing
the recurrence through figuring out if one option was more ‘optimal’ in the sense that they would
still produce a valid permutation of words, breaking things down subproblem by subproblem in
the complicated problem of processing the entire string. Since any permutation of possible words
in a string (as long as the result was all words from the dictionary file) were accepted, one could
add to storedWord as long as the string matched a word in the dictionary only when it didn’t hurt
the validity of the rest of the string as words (if words were possible). This fits the bottom-up
approach of dynamic programming, simplifying a complicated problem by breaking it down into
simpler sub-problems in a recursive manner, looking at things character by character in order to
solve the complicated problem of spacing words included in a dictionary. 
