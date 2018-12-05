# Enigma

Create your own ciphering machine in Java.

Requirements:
    - Each team member should implement at least two of the basic ciphers.
        Before starting the implementation a team should prepare the list of tasks for the sprint. Each task may be broken into sub-tasks later by the person responsible for the task.
    -The program’s used should be as shown below:
        java Application -e | -d (enciper/decipher) CIPHER [KEY] To start it in encrypting mode use -e option; -d to start in decrypting mode CIPHER says what kind of cipher we want to use and KEY is the optional KEY to be used with the CIPHER (if selected cipher requires a key)
    - The program should take every line (a string of characters) from standard input and process it according to   the options used. The result should be printed to the standard output.
    - The user should be able to list all available (implemented) ciphers using -l option
        java Application -l
    - You can implement the program in one Application class with all static methods.
    - Focus on the proper way of exceptions handling.
    - Work with GIT branches and remember about pull requests.