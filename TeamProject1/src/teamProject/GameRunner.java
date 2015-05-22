/**
 * Author: Matthew Johnson
 */
package teamProject;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class GameRunner {
   private Player user;
   int numOfZombies;
   Zombie superZombie = new Zombie();
   
   ArrayList<Zombie> zombies = new ArrayList<Zombie>();
   
   Scanner input = new Scanner(System.in);
   
   Random rand = new Random();
   public GameRunner(){
	   getName();
	   weaponInfo();
   }
   
   public  String getName(){
	   System.out.println("Welcome to our game.");
       System.out.println("What do you want to name your character?");
       String name = input.next();
       user = new Player(name);
	return name;
   }
   
   public void weaponInfo(){
	   System.out.println("You have woken up to a strange noise down stairs");
       System.out.println("You do not remember how you got here or how you came to be unconscious\n (enter a to continue)");
       String enter = input.next();
    		   
       System.out.println("All you remember is everybody screaming and people killing each other.\n"
           + "you see in front of you a gun with 5 bullets left, a sword, and a bow with 10 arrows. \n (enter a to continue)");
       String enter1 = input.next();
       System.out.println("The Gun has only five bullets but you have a chance of finding some on your journey\n"
           + "The Bow has 10 arrows and you can also find them along your journey\n"
           + "The sword never breaks and you have a 1 in 4 chance of hitting a zombie twice in a row, \ndealing double the damage\n (enter a to continue)");
       String enter2 = input.next();
       System.out.println("Gun: 15 dps\n"
            + "Bow: 12 dps\n"
       		+ "Sword: 10 dps\n\n\n");

           System.out.println("What weapon would you like?\n"
           + "Press 1: gun\n"
           + "Press 2: bow\n"
           + "Press 3: sword\n");
           String weapon = input.next();
           user.setWeapon(weapon);
   }
   
    public  void play(){
              
    	System.out.println("You hear the noise again");
    	System.out.println("You have no idea what it is but you are curious");
    
    	System.out.println("You also see a broken window would you like to jump out? \n"
    			+ "Im sure its not that high up");
    	System.out.println("Press 1: jump out the window\n" 
    			+ "Press 2: go downstairs and investigate");
    	int choice = input.nextInt();
    	if(choice == 1){
    		user.updateHealth(0);
    		System.out.println("You could not handle the Stress so you decide to jump out the window to run away\n"
    				+ "but you did not realize that you were on the fifteenth floor\n"
    				+ " and you plummetted to your death");
    		user.isDead();
    	}
    	if(choice == 2){
    		generateZombies();
    		System.out.println("You had to climb down 15 flights of stairs\n"
    				+ "and you are exausted but you finally made it to the bottom.\n\n\n"
    				+ "You see two doors. \n"
    				+ "In the front door, you emediatley see a pack of " + zombies.size() + " Zombies\n"
    				+ "You can not see passed the back doors.");
    		System.out.println("Would you like to go through the back door or the front door?\n"
    				+ "Press 1: for the back door \n"
    				+ "Press 2: for the front door");
    		int choice1 = 0;
    		do{
    		choice1 = input.nextInt();
    		if(choice1 == 1){
    			generateZombies();
    			System.out.println("You go out the door and imediatley find a pack of" + zombies.size() + " zombies");
    			battle();
    			
    			
    			System.out.println("After the battle, you find a map that shows you are close to a nearby Millitary base\n"
    	    			+ "You begin walking in the direction of the Military base but night begins to fall\n"
    	    			+ "You find a car that is safe enough to sleep in overnight.\n"
    	    			+ "do you want to stay overnight and sleep in the car, or keep walking?\n"
    	    			+ "Press 1: keep walking\n"
    	    			+ "Press 2: sleep in the car");
    	    	int choice2 = input.nextInt();
    	    	if(choice2 == 1){
    	    		System.out.println("As you are walking it continues to get darker and darker and you can no longer see");
    	    		System.out.println("You did not hear a pack of zombies approaching you, and they killed you");
    	    		user.isDead();
    	    	}
    	    	if(choice2 == 2){
    	    		generateZombies();
    	    		System.out.println("You wake up in the morning to see a pack of " + zombies.size() + " zombies surrounding your car\n"
    	    				+ "would you like to wait the zombies out, or try to escape?\n"
    	    				+ "Press 1: to escape\n"
    	    				+ "Press 2: to wait");
    	    		int choice3 = input.nextInt();
    	    		if(choice3 == 1){
    	    			System.out.println("You break the window, and kill a zombie.\n	"
    	    					+ "You decide to make a run for it but you are hit by one of the zombies loosing 3 health");
    	    			user.updateHealth(-3);
    	    			System.out.println("You are walking along the highway and you find a dirtbike lying on the ground.\n"
    	    					+ "You go to check it out and find that there is still a key inside,\n"
    	    					+ " so you check the gas and it turns out it is half way full.\n");
    	    			System.out.println("So, you hop onto the motorcycle\n"
    	    					+ "on your way there you think that you see a survivor.\n"
    	    					+ "Press 1: go save the survivor\n"
    	    					+ "Press 2: mind your own buisness and drive away.");
    	    			int choice4 = input.nextInt();
    	    			do{
    	    				if(choice4 == 1){
    	    					System.out.println("It turns out the survivor is actually a zombie and as you are hit for double damage.\n"
    	    							+ "the good news is you found some food");
    	    					user.updateHealth(-6);
    	    					user.getFood();
    	    				}
    	    				if(choice4 == 2){
    	    					generateLastZombies();
    	    					System.out.println("Oh well, he probably wouldn't have survived anyway... right?");
    	    					System.out.println("On your way you run into a couple of problems but you finally see the military base\n"
    	    							+ "you see a crowd of " + zombies.size() + " Zombies\n"
    	    							+ "In order to get to the military base, you have to fight the zombies.\n"
    	    							+ "Press 1: fight the zombies\n"
    	    							+ "Press 2: run away");
    	    					int choice5 = input.nextInt();
    	    					do{
    	    						if(choice5 == 1){
    	    							battle();
    	    						}
    	    						if(choice5 == 2){
    	    							System.out.println("You decide to live another day.\n");
    	    							user.happyEnding();
    	    						}
    	    					}while(choice5 <= 2);
    	    				}
    	    			}while(choice4 <= 3);
    	    		}
    	    		if(choice3 == 2){
    	    			System.out.println("You run out of food supply and starve to death.");
    	    			user.isDead();
    	    		}
    		}
    		else if(choice1 == 2){
    			battle();
    		}
    		
    			System.out.println("You need to enter a valid response");
    		}
    		
    		}while(choice != 1 || choice != 2);
    	}
    	
    }
    
    public void battle(){
    	System.out.println("Would you like to fight or run away?\n"
    			+ "Press 1: run away\n"
    			+ "Press 2: fight\n");
    	int choice = input.nextInt();
    	if(choice == 1){
    		System.out.println("You start to run away, but the zombies attack you");
    		for(Zombie el: zombies){
    			el.attack(user);
    			el.bite();
    		}
    		System.out.println("You have lost" + zombies.size() * 3 + "health");
    	}
    	if(choice == 2){
    		do{
        		for(Zombie el: zombies){
        			el.attack(user);
        			System.out.println(el.getName() + " has attack you for 3 damage");
        			if(user.getHealth() == 0){
        				user.isDead();
        			}
        		}
        		System.out.println("there are " + zombies.size() + "zombies");
        		System.out.println("Which Zombie do you want to attack?\n"
        				+ "Press: 0 zombie #1, Press 1 for Zombies #2 and so on.");
        	
        		int zombie = input.nextInt();
        		for(int i = 0; i < zombies.size(); i++){
        			if(zombie == i){
        				user.attack(zombies.get(i));
        				if(user.getWeapon().getWeapon().equals("1")){
        					user.useBullets(1);
        					System.out.println(zombies.get(i).getName() + " now has " + zombies.get(i).getHealth() + " health");
        				}
        				if(user.getWeapon().getWeapon().equals("2")){
        					user.useArrows(1);
        					System.out.println(zombies.get(i).getName() + " now has " + zombies.get(i).getHealth() + " health");
        				}
        				if(user.getWeapon().getWeapon().equals("3")){
        					int doubleHit = rand.nextInt(4);
        					if(doubleHit == 0){
        						user.attack(zombies.get(i));
        						System.out.println("You have attacked the zombie twice");
        					}
        				}
        			}
        			if(zombies.get(i).isDead()){
        				zombies.remove(i);
        			}
        		}
    		}while(zombies.size() != 0);
    	}
    	user.getFood();
       	user.eatFood();
    }
    
    public void generateZombies(){
    	zombies.removeAll(zombies);
    	Random rand = new Random();
        numOfZombies = rand.nextInt(5) + 1;
        for(int i = 0; i <= numOfZombies; i++){
        	zombies.add(new Zombie());
        }

    }
    public void generateLastZombies(){
    	Random rand = new Random();
    	zombies.removeAll(zombies);
        numOfZombies = rand.nextInt(10) + 1;
        for(int i = 0; i <= numOfZombies; i++){
        	zombies.add(new Zombie());
        }
        superZombie.generateSuperZombie();
    }
    public static void main(String[] args){
        GameRunner startGame = new GameRunner();
        startGame.play();
    }
}