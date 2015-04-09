Gopro-Intern-Assignment

Input: Text document from the command line, in this case constitution.txt

Output: 
	
	Line 1: equivalent to wc constitution.txt. Displays line, word, and byte
	  count of input document.

	Line 2: Modified wc to ignore words in list "I We You They a and the that 
	  of for with". Displays line, word, and byte count of input document.

	Lines 3 onward: Display total article count, total section count, and 
	  breakdown of section count by article.

Usage: 

       javac ConstitutionReader.java
       java  ConstitutionReader constitution.txt

This program fulfills the outlines set out by the Software Engineering Intern
homework assignment. A few important things to point out:

The set of ignored words counts letter case. Therefore the program ignores
"They" but not "they" in the body of the document. This can be easily changed
by editing the list of ignored words at the top of Main to include 
non-capitalized versions.

Adjusted byte count is calculated by taking the total byte count of the entire
document and subtracting the total byte count of ignored words. So whitespaces
still count.

The number of lines in the document is the same in both the "all" and proper
word counts. This is true for any input document because even if a line 
consisting of a single word is ignored from our ignore list, wc still counts
the newline character as a line.

That should be everything! 
