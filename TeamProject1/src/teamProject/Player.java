/**
 /* Author: Robert Kingston
 */
package teamProject;

import java.util.Random;

public class Player
{
   private int health;
   private int maxHealth;
   private String name;
   private XP stats;
   private Weapon typeOfWeapon;
   private Food amountOfFood;
   Random rand = new Random();
   public Player(String n)
   {
       health = 100;
       name = n;
       stats = new XP(null);
       typeOfWeapon = new Weapon();
       amountOfFood = new Food(this);
   }
   public int getHealth()
   {
       return health;
   }
   public int getMaxHealth()
   {
	   return maxHealth;
   }
   public String getName()
   {
       return name; 
   }
   public int getXP()
   {
       return stats.getXP();       
   }
   public void gotBitten()
   {
       health = 0;
       System.out.println("You have been bitten by a Zombie\n "
       		+ "and you were left for dead.");
   }
   public int getFood(){
	   return amountOfFood.generateFood();
   }
   public void eatFood(){
	   amountOfFood.eatFood();
   }
   public void upgrade()
   {
	   stats = new XP(this);
       stats.LevelUP(typeOfWeapon);
   }
   public void updateHealth(int p)
   {
	   System.out.println("You now have" + getHealth() + " health");
	   health += p;
   }
   public void updateMaxHealth(int p)
   {
	   maxHealth += p;
   }
   public void setWeapon(String w){
	   typeOfWeapon = new Weapon();
	   typeOfWeapon.setWeapon(w);
   }
   public Weapon getWeapon(){
	   return typeOfWeapon;
   }
   public int useBullets(int i){
	   typeOfWeapon.updateBullets(i);
	   return typeOfWeapon.getBullets();
   }
   public String findBullets(int i){
	   int randBullets = rand.nextInt(5) + 1;
	   typeOfWeapon.updateBullets(randBullets);
	   return "You have found " + randBullets + " bullets\n" + " You now have" + typeOfWeapon.getBullets() + " bullets";
   }
   public int useArrows(int i){
	   typeOfWeapon.updateArrows(i);
	   return typeOfWeapon.getArrows();
   }
   public String findArrows(int i){
	   int randArrows = rand.nextInt(5) + 1;
	   typeOfWeapon.updateArrows(randArrows);
	   return "You have found " + randArrows + " arrows\n" + "You now have " + typeOfWeapon.getArrows() + " arrows";
   }
   public void attack(Zombie n){
	   n.changeHealth(typeOfWeapon.getDamage());
	   System.out.println("You have dealt" + typeOfWeapon.getDamage() + " damage.");
   }
   public void isDead()
   {
      
           System.out.println("You have tragically died.");
           System.out.println(":(");
           System.out.println("The military found your bio signatures");
           System.out.println("and were just minutes away from rescuing you");
           System.out.println("They followed your trail and were informed by other");
           System.out.println("survivors of your courage and bravery");
           System.out.println("A memorial was set up in your honor");
           System.out.println("and you will always be remembered as a");
           System.out.println("noble and fearless warrior.");
           System.out.println("");
           System.out.println("");
           System.out.println("                CREATED BY             ");
           System.out.println("");
           System.out.println("              MATTHEW JOHNSON");
           System.out.println("");              
           System.out.println("              ROBERT KINGSTON");
           System.out.println("");
           System.out.println("               BRYAN HERRERA");
       
   }
   public void happyEnding(){
	   System.out.println("                CREATED BY             ");
       System.out.println("");
       System.out.println("              MATTHEW JOHNSON");
       System.out.println("");              
       System.out.println("              ROBERT KINGSTON");
       System.out.println("");
       System.out.println("               BRYAN HERRERA");
   }
}