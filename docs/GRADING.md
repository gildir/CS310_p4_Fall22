## Grading Rubric
[back](README.md)

### No Credit
- Same as previous projects! (Non submitted assignments. Assignments submitted more than 24 hours late. Non-compiling assignments. Non-independent work. Code that violates and restrictions or “you may not” mandates. "Hard coded" solutions. Code that would win an obfuscated code competition with the rest of CS310 students.)

### How will my assignment be graded?
- Grading will be divided into two portions:
  1. Manual/Automatic Testing (100%): To assess the correctness of programs.
  2. Manual Inspection (25% off the top points): A checklist of features your programs should exhibit. These comprise things that cannot be easily checked via unit tests such as good variable name selection, proper decomposition of a problem into multiple functions or cooperating objects, overall design elegance, and proper asymptotic complexity. These features will be checked by graders and assigned credit based on level of compliance.
- You CANNOT get points (even style/manual-inspection points) for code that doesn't compile or for submitting just the files given to you with the assignment. You CAN get manual inspection points for code that (a) compiles and (b) is an "honest attempt" at the assignment, but does not pass any unit tests.
- Extra credit for early submissions:
  - 1% extra credit rewarded for every 24 hours your submission made before the due time
  - Up to 5% extra credit will be rewarded
  - Your latest submission before the due time will be used for grading and extra credit checking.  You CANNOT choose which one counts.

#### Manual/Automatic Testing (100%)
- We will run unit tests on your classes, and your simulator will be run and play through Chaitin's Algorithm on several different graphs.
- We will create a 100 node graph where all nodes are connected. If your code takes more than one minute to create such a graph you will lose some points. We promise to run it on a reasonably modern laptop (not a tablet, for instance).

#### Manual Code Inspection Rubric (25% "off the top" points)
These are all "off the top" points (i.e. items that will lose you points rather than earn you points):

Inspection Point | Points | High (all points) | Med (1/2 points) | Low (no points)
:---: | :---: | :--- | :--- | :--- 
Submission Format (Folder Structure) | 5 | Code follows the submission format (see projects 1-3) |  | Code does not follow the submission format. Note: This is very, very important for these assignments; the graders need to return grades very fast. If you do not follow the submission format (the same one you’ve been using for P0-3), then they will manually deduct 5pts from your score. No exceptions.
Code Formatting | 5 | Code passes the style checker. | | Code does not pass the style checker.
JavaDocs Formatting | 5 | Code passes the JavaDoc style checker. | | Code does not pass the JavaDoc style checker.
JavaDocs | 5 | The entire code base is well documented with meaningful comments in JavaDoc format. Each class, method, and field has a comment describing its purpose. Occasional in-method comments used for clarity. | The code base has some comments, but is lacking comments on some classes/methods/fields or the comments given are mostly "translating" the code. | The only documentation is what was in the template and/or documentation is missing from the code (e.g. taken out).
Coding conventions | 5 | Code has good, meaningful variable, method, and class names. All (or almost all) added fields and methods are properly encapsulated. For variables, only class constants are public. | Names are mostly meaningful, but a few are unclear or ambiguous (to a human reader) [and/or] Not all fields and methods are properly encapsulated. |  Names often have single letter identifiers and/or incorrect/meaningless identifiers. [Note: i/j/k acceptable for indexes.] [and/or] Many or all fields and methods are public or package default.
