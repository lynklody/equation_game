# A number game.
The user needs to give 7 numbers in one row of input. The program will mix the first six numbers in that particular order with different combinations of the four basic operands (+, -, *, /). If the expression created is evaluated to be equal to the 7th number given, the expression will be printed out. The program has a 30-second time limit. After running for 30 sec, it will automatically stop.


# example I/O:<br/>
input: <br/>
" 10 1 25 50 75 100 813"<br/>

output: <br/>
" numbers are 10 1 25 50 75 100 <br/>
the expected result is 813<br/>
25 75 10 - * 1 + 100 50 / / <br/>
25 75 10 - * 1 + 50 * 100 / <br/>
50 75 10 - 25 * 1 + * 100 / <br/>
50 25 75 10 - * 1 + * 100 / <br/>
25 75 10 - * 1 + 50 * 100 / <br/>
25 75 10 - * 1 + 100 50 / / <br/>
25 75 10 - * 1 + 50 * 100 / <br/>
1 75 10 - 25 * + 100 50 / / <br/>
25 75 10 - * 1 + 100 50 / / <br/>
The number of expressions tried: 27746268<br/>
The number of solutions found: 9 "<br/>


# Main method description:

First, a list of operators and input numbers are created. Then if time allows (30s), generate random shuffles of the numbers. For each shuffle, iterate through all the arrangement rules and try out all the combinations of the operators. Print expression if the result after being evaluated equals to the given number. 
