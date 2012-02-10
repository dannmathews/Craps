import java.util.Random;
import java.util.Scanner;

public class Game
{
	private boolean on = true;
	private int pointScore;
	public static void main(String []args)
	{
		Game session = new Game();
		session.play();
	}
	public Game()
	{
		
	}
	public void play()
	{
		Scanner keyboard = new Scanner(System.in);
		while(true)
		{
			int roll;
			Random randomGenerator = new Random();
			roll = randomGenerator.nextInt(10)+2;
			if(on)
				System.out.print("First ");
			System.out.println("Roll: "+roll);
			if(on)
			{
				if(roll == 7 || roll == 11)
				{
					System.out.println("You win!");
					System.out.println("Would you like to play again?");
					String again = keyboard.next();
					if(!again.equalsIgnoreCase("yes") && !again.equalsIgnoreCase("y"))
						break;
					System.out.println();
				}
				else if(roll == 2 || roll == 3 || roll == 12)
				{
					System.out.println("You lose!");
					System.out.println("Would you like to play again?");
					String again = keyboard.next();
					if(!again.equalsIgnoreCase("yes") && !again.equalsIgnoreCase("y"))
						break;
					System.out.println();
				}
				else
				{
					pointScore = roll;
					System.out.println("Your number is "+roll+", please roll again");
					on = false;
				}
			}
			else
			{
				if(roll == pointScore)
				{
					System.out.println("You rolled your number, you win!");
					on = true;
					System.out.println("Would you like to play again?");
					String again = keyboard.next();
					if(!again.equalsIgnoreCase("yes") && !again.equalsIgnoreCase("y"))
						break;
					System.out.println();
				}
				else if(roll == 7)
				{
					System.out.println("You lose!");
					on = true;
					System.out.println("Would you like to play again?");
					String again = keyboard.next();
					if(!again.equalsIgnoreCase("yes") && !again.equalsIgnoreCase("y"))
						break;
					System.out.println();
				}
				else
				{
					System.out.println("You failed to roll a "+pointScore+" or 7, please roll again");
				}
			}
		}
	}
}