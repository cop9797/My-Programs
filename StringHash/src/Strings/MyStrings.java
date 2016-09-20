package Strings;
import java.util.Scanner;

public class MyStrings {
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		Scanner secin = new Scanner(System.in);
		System.out.print("Would you like to encrypt to decrypt (E/D): ");
		
		String inputString1 = secin.next();
		inputString1.toUpperCase();
		System.out.print(inputString1);
		if(inputString1.equals("E"))
		{
			System.out.print("Please input your message: ");
			String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String inputString = stdin.nextLine();
		
			inputString = inputString.toUpperCase();
			for(int x = 0; x < inputString.length();x++)
			{
				if(inputString.charAt(x) == ' ')
				{
					System.out.print('_');
				}
				else
					if(alphabet.indexOf(inputString.charAt(x)) < 0)
					{
						System.out.print("This Character is Invalid!");
					}
					else
						System.out.print(alphabet.indexOf(inputString.charAt(x)));
						System.out.print(" ");
			}
		
		
		}
		else
		{
			
		}
		
	}
	
	

}