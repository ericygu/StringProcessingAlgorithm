# StringProcessingAlgorithm
WIP


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

Attached is a writeup describing the recurrence I used for the dynamic programming
portion, and I explained how the splitting is reconstructed after computing the recurrence.
