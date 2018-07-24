import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/**
 * The main method.
 * First, a list of operators and input numbers are created. Then if time allows (30s),
 * generate random shuffles of the numbers. For each shuffle, iterate through all the
 * arrangement rules and try out all the combinations of the operators. Print expression
 * if the result after being evaluated equals to the given number. 
 * The evaluate method is created to evaluate the post-fix expressions.
 * @author Wendy
 *
 */
public class Driver 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// a list of operators
		Token[] operators = new Token[4];
		operators[0] = new Token("+");
		operators[1] = new Token("-");
		operators[2] = new Token("*");
		operators[3] = new Token("/");
		// a list of numbers / inputs
		Token[] numbers = new Token[6];
//////////////////////////////change input method/////////////////
//		System.out.println("Please enter 6 numbers");
//		Scanner kbd = new Scanner(System.in);
//		String input = kbd.nextLine();
//		String[] x = input.split(" ");
		
		String[] x = args;
		
		System.out.print("numbers are ");
		for (int i = 0; i < 6; ++i)
		{
			numbers[i] = new Token(x[i]);
			System.out.print(numbers[i].getLexeme() + " ");
		}
		int result = Integer.parseInt(x[6]);
		System.out.println();
		System.out.println("the expected result is "+result);
		
		// start counting the time
		int numExpr = 0;
		int numSolution = 0;
		// convert array into list
		java.util.List<Token> numbersList = Arrays.asList(numbers);    
		long currenttime = 0;
		BigInteger thirty = new BigInteger("30000000000");
		BigInteger starttime = new BigInteger(Long.toString(System.nanoTime()));
		BigInteger endtime = starttime.add(thirty);
		
		while (currenttime < endtime.longValue())
		{
			currenttime = System.nanoTime();
			// open the arrangement file
			Scanner in = new Scanner(new FileInputStream("arrangements.txt"));
			// shuffle numbers
			Collections.shuffle(numbersList);
			// convert the shuffled tokens back to an array of tokens
			Token[] shuffled = (Token[]) numbersList.toArray();
/*
			for(int i = 0; i < 6; ++i)
			{
				System.out.print(shuffled[i].getLexeme() + " ");
			}
			System.out.println();
*/
			while (in.hasNextLine())
			{
				String line = in.nextLine();
				// parse arrangement rule
				String[] rule = line.split(" ");
				Token[] expr = new Token[rule.length];
				
				// assemble numbers and operators together
				// count the number of operators in this rule
				int numOp = 0;   
				for (int i = 0; i < rule.length; ++i)
				{
					if (rule[i].equals("O"))
					{
						numOp++;
					}
				}
				
				int a,b,c,d,e;
				if (numOp == 1)
				{
					for (a = 0; a < 4; ++a)
					{
						numExpr++;
						for (int i = 0; i < rule.length; ++i)
						{
							if (rule[i].equals("N"))
							{
								expr[i] = new Token(shuffled[i]);
							}
							if (rule[i].equals("O"))
							{
								expr[i] = new Token(operators[a]);
							}
						}
						// print target string
						if (evaluate(expr) == result)
						{
							numSolution++;
							StringBuilder sb = new StringBuilder();
							for (int i = 0; i < expr.length; ++i)
							{
								sb.append(expr[i].getLexeme());
								sb.append(" ");
							}
							System.out.println(sb.toString());
						}
					}
				}
				else if (numOp == 2)
				{
					for (a = 0; a < 4; ++a)
					{
						for (b = 0; b < 4; ++b)
						{
							int numNumEncountered = 0;
							int numOpEncountered = 0;
							numExpr++;
							for (int i = 0; i < rule.length; ++i)
							{
								if (rule[i].equals("N"))
								{
									expr[i] = new Token(shuffled[numNumEncountered]);
									numNumEncountered++;
								}
								if (rule[i].equals("O"))
								{
									numOpEncountered++;
									if (numOpEncountered == 1)
									{
										expr[i] = new Token(operators[a]);
									}
									else if (numOpEncountered == 2)
									{
										expr[i] = new Token(operators[b]);
									}
								}
							}
							// print target string
							if (evaluate(expr) == result)
							{
								numSolution++;
								StringBuilder sb = new StringBuilder();
								for (int i = 0; i < expr.length; ++i)
								{
									sb.append(expr[i].getLexeme());
									sb.append(" ");
								}
								System.out.println(sb.toString());
							}
						}
					}
				}
				else if (numOp == 3)
				{
					for (a = 0; a < 4; ++a)
					{
						for (b = 0; b < 4; ++b)
						{
							for (c = 0; c < 4; ++c)
							{
								int numNumEncountered = 0;
								int numOpEncountered = 0;
								numExpr++;
								for (int i = 0; i < rule.length; ++i)
								{
									if (rule[i].equals("N"))
									{
										expr[i] = new Token(shuffled[numNumEncountered]);
										numNumEncountered++;
									}
									if (rule[i].equals("O"))
									{
										numOpEncountered++;
										if (numOpEncountered == 1)
										{
											expr[i] = new Token(operators[a]);
										}
										else if (numOpEncountered == 2)
										{
											expr[i] = new Token(operators[b]);
										}
										else if (numOpEncountered == 3)
										{
											expr[i] = new Token(operators[c]);
										}
									}
								}
								// print target string
								if (evaluate(expr) == result)
								{
									numSolution++;
									StringBuilder sb = new StringBuilder();
									for (int i = 0; i < expr.length; ++i)
									{
										sb.append(expr[i].getLexeme());
										sb.append(" ");
									}
									System.out.println(sb.toString());
								}
							}
						}
					}
				}
				else if (numOp == 4)
				{
					for (a = 0; a < 4; ++a)
					{
						for (b = 0; b < 4; ++b)
						{
							for (c = 0; c < 4; ++c)
							{
								for (d = 0; d < 4; ++d)
								{
									int numNumEncountered = 0;
									int numOpEncountered = 0;
									numExpr++;
									for (int i = 0; i < rule.length; ++i)
									{
										if (rule[i].equals("N"))
										{
											expr[i] = new Token(shuffled[numNumEncountered]);
											numNumEncountered++;
										}
										if (rule[i].equals("O"))
										{
											numOpEncountered++;
											if (numOpEncountered == 1)
											{
												expr[i] = new Token(operators[a]);
											}
											else if (numOpEncountered == 2)
											{
												expr[i] = new Token(operators[b]);
											}
											else if (numOpEncountered == 3)
											{
												expr[i] = new Token(operators[c]);
											}
											else if (numOpEncountered == 4)
											{
												expr[i] = new Token(operators[d]);
											}
										}
									}
									// print target string
									if (evaluate(expr) == result)
									{
										numSolution++;
										StringBuilder sb = new StringBuilder();
										for (int i = 0; i < expr.length; ++i)
										{
											sb.append(expr[i].getLexeme());
											sb.append(" ");
										}
										System.out.println(sb.toString());
									}
								}
							}
						}
					}
				}
				else if (numOp == 5)
				{
					for (a = 0; a < 4; ++a)
					{
						for (b = 0; b < 4; ++b)
						{
							for (c = 0; c < 4; ++c)
							{
								for (d = 0; d < 4; ++d)
								{
									for (e = 0; e < 4; ++e)
									{
										int numNumEncountered = 0;
										int numOpEncountered = 0;
										numExpr++;
										for (int i = 0; i < rule.length; ++i)
										{
											if (rule[i].equals("N"))
											{
												expr[i] = new Token(shuffled[numNumEncountered]);
												numNumEncountered++;
											}
											if (rule[i].equals("O"))
											{
												numOpEncountered++;
												if (numOpEncountered == 1)
												{
													expr[i] = new Token(operators[a]);
												}
												else if (numOpEncountered == 2)
												{
													expr[i] = new Token(operators[b]);
												}
												else if (numOpEncountered == 3)
												{
													expr[i] = new Token(operators[c]);
												}
												else if (numOpEncountered == 4)
												{
													expr[i] = new Token(operators[d]);
												}
												else if (numOpEncountered == 5)
												{
													expr[i] = new Token(operators[e]);
												}
											}
										}
										// print target string
										if (evaluate(expr) == result)
										{
											numSolution++;
											StringBuilder sb = new StringBuilder();
											for (int i = 0; i < expr.length; ++i)
											{
												sb.append(expr[i].getLexeme());
												sb.append(" ");
											}
											System.out.println(sb.toString());
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println("The number of expressions tried: " + numExpr);
		System.out.println("The number of solutions found: " + numSolution);
	}
	
	/**
	 * A method to evaluate post-fix expression.
	 * @param expr
	 * @return
	 */
	public static int evaluate(Token[] expr)
	{
		Stack stack = new Stack();
		for (int i = 0; i < expr.length; ++i)
		{
			if (expr[i].getType().equals("N"))
			{
				stack.push(Integer.parseInt(expr[i].getLexeme()));
			}
			if (expr[i].getType().equals("O"))
			{
				int num2 = (int) stack.pop();
				int num1 = (int) stack.pop();
				if (expr[i].getLexeme().equals("+"))
				{
					stack.push(num1 + num2);
				}
				else if ((expr[i].getLexeme().equals("-")) && (num1-num2 >= 0))
				{
					stack.push(num1 - num2);
				}
				else if ((expr[i].getLexeme().equals("-")) && (num1-num2 < 0))
				{
					stack.push(-1);
				}
				else if (expr[i].getLexeme().equals("*"))
				{
					stack.push(num1 * num2);
				}
				else // expr[i].getLexeme().equals("/")
				{
					if ((num2 != 0) && (num1 % num2 == 0))
					{
						stack.push(num1 / num2);
//						System.out.println("check whole number: "+(num1%num2));
					}
					else
					{
						stack.push(-1);
					}
				}
			}
		}
		return (int)stack.pop();
	}
}
