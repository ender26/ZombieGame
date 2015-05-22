/**
 * Author: Matthew Johnson
 */
package teamProject;

import java.util.Random;
import java.util.Scanner;

public class Food {

	Random rand = new Random();
	Scanner input = new Scanner(System.in);
	private Player user;
	private int amountOfFood;
	private boolean hasFood;
	

	public Food(Player p){
		user = p;
		amountOfFood = 15;
		hasFood = false;
	}

	public int getFood(){
		
		return amountOfFood;
	}

	public boolean hasFood(){

		return hasFood;
	}

	public int generateFood(){

		int food = rand.nextInt(75) + 1;
		System.out.println("You have found " + food + " items of food.");
		amountOfFood += food;
		return amountOfFood;
	}
	
	public void eatFood(){

		System.out.println("You have " + amountOfFood + " items of food.");
		System.out.println("How much food would you like to eat?");
		int food = input.nextInt();
		int x = 0;
		do{

			if(food <= amountOfFood){
				user.updateHealth(x);
				System.out.println("Your health has increased by " + x);
				x++;
			}
			if(food >= 75){
				System.out.println("You ate too much and as a result you got fat\n"
						+ " which made it easier for the zombies to cath you...the zombies ate you.");
				x++;
				user.isDead();
			}
			if(food == 0){
				System.out.println("Im sure you'll have plenty of health for the next battle");
			}
			if(food > amountOfFood) {
				System.out.println("You do not have that much food");
				x++;
			}
		}while(x <= 1);
	}
}