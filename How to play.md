# A number game.
The user needs to give 7 numbers in one row. The program will mix the first six numbers in that particular order with different combinations of the four basic operands (+, -, *, /). If the expression created is evaluated to be equal to the 7th number given, the expression will be printed out.


# example I/O:
input: 
" 10 1 25 50 75 100 813"

output: 
" numbers are 10 1 25 50 75 100 
the expected result is 813
25 75 10 - * 1 + 100 50 / / 
25 75 10 - * 1 + 50 * 100 / 
50 75 10 - 25 * 1 + * 100 / 
50 25 75 10 - * 1 + * 100 / 
25 75 10 - * 1 + 50 * 100 / 
25 75 10 - * 1 + 100 50 / / 
25 75 10 - * 1 + 50 * 100 / 
1 75 10 - 25 * + 100 50 / / 
25 75 10 - * 1 + 100 50 / / 
The number of expressions tried: 27746268
The number of solutions found: 9 "


# Main method description:

First, a list of operators and input numbers are created. Then if time allows (30s), generate random shuffles of the numbers. For each shuffle, iterate through all the arrangement rules and try out all the combinations of the operators. Print expression if the result after being evaluated equals to the given number. 
