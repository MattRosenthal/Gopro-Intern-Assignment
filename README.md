Gopro-Intern-Assignment

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