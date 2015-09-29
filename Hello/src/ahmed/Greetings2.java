package ahmed;

/* This program prompts the user to enter his or her first name and last name and displays a greeting message. Author: Maria Litvin
 */
import java.util.Scanner;
public class Greetings2
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your first name: ");
		String firstName = scan.nextLine();
		System.out.print("Enter your last name: ");
		String lastName = scan.nextLine();
		System.out.println("Hello " + firstName + " " + lastName); System.out.println("Welcome to Java!");
	}
}