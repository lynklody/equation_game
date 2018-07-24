/**
 * The token objects consist of two attributes, lexeme and type.
 * The lexeme is the string literal of a token and the type is
 * either a number (N) or an operator (O). The program will
 * halt when a token is neither a number nor an operator.
 * @author Wendy
 *
 */
public class Token 
{
	private String lexeme;
	private String type;
	
	public Token(String token)
	{
		lexeme = token;
		
		if (token.equals("+") || token.equals("-") 
				|| token.equals("*") || token.equals("/"))
		{
			type = "O"; // operator
//			System.out.println("O");
		}
		else
		{
			try
			{
				int x = Integer.parseInt(token);
				type = "N";  // number
//				System.out.println("N");
			}
			catch (NumberFormatException e)
			{
				System.out.println(token + " is neither a number nor an "
						+ "operator!");
				System.exit(1);
			}
		}
	}
	
	public Token(Token t)
	{
		lexeme = t.lexeme;
		type = t.type;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getLexeme()
	{
		return lexeme;
	}
}
