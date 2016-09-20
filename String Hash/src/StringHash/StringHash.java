package strings;
import java.util.Scanner;

public class MyStrings {
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		
		String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "_123456789";
		String doublenumbers = "1011121314151617181920212223242526"
		
		System.out.println("Do you want to encrypt or decrypt E/D: ");
		String inputString = stdin.nextLine();
		inputString = inputString.toUpperCase();
		if(inputString == "E")
		{
			System.out.println("Please input your string: ");
			inputString = stdin.nextLine();
		/*for(int x = 0; x < inputString.length(); x++)
		{
			if(inputString.charAt(x) == ' ')
			{
				System.out.print('_');
			}
			if(alphabet.indexOf(inputString.charAt(x)+1) == -1)
			{
				System.out.print("This is an invalid character.");
				
			}
			else
				System.out.print(alphabet.indexOf(inputString.charAt(x)+1));
			System.out.print(" ");
			
		}*/
		}
		else if(inputString == "D")
		{
			for(int x = 0; x < inputString.length(); x++)
			{
				if(numbers.indexOf(inputString.charAt(x)+1) < 10);
				{
					numbers.indexOf
				}
				
			
			
			}
		}
		
		
		
		
	}
	
	

}
