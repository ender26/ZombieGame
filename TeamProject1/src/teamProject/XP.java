/**
 * Author: Robert Kingston
 */
package teamProject;
import java.util.Scanner;
public class XP
{
   public int XP;
   public int LVL;
   public int LVLP;
   Player thePlayer;
   Zombie zombie;
   Zombie superZombie;
   XP(Player p)
   {
       XP = 0;
       LVL = 1;
       LVLP = 0;
       thePlayer = p;
   }
   public int getXP()
   {
       return XP;
   }
   public int getLVL()
   {
       return LVL;
   }
   public int getLVLP()
   {
       return LVLP;
   }
   public void LevelUP(Weapon weapon)
   {
       Scanner input = new Scanner(System.in);
       char x;
       int a;
       for(int i = 1; i < 11; i++){
           for(int j = 100; j < 200; j += 10){
               if((LVL == i) && (XP >= j))
               {
                   LVLP += 2;
                   System.out.println("You have " + LVLP + " level points");
                   System.out.println("You can upgrade your health or your weapon attack");
                   System.out.println("Do you want to upgrade your health?");
                   System.out.println("Enter y for yes or n for no");
                   x = input.next().charAt(0);
                   if(x == 'y')
                   {
                       System.out.println("How much do you want to level up?");
                       System.out.println("Press 1 to level up once");
                       System.out.println("Press 2 to level up twice");
                       a = input.nextInt();
                       if(a == 1)
                       {
                           thePlayer.updateHealth(10);
                       }
                       else if(a == 2)
                       {
                           thePlayer.updateHealth(20);
                       }
                       else if(a > LVLP)
                          System.out.println("You don't have enough level points");
                       LVLP -= a;
                   }
                   else if(x == 'n')
                   {
                       System.out.println("Do you want to upgrade your attack?");
                       System.out.println("Enter y for yes or n for no");
                       x = input.next().charAt(0);
                       if(x == 'y')
                       {
                           System.out.println("How much do you want to level up?");
                           System.out.println("Press 1 to level up once");
                           System.out.println("Press 2 to level up twice");
                           a = input.nextInt(); 
                           if(a == 1)
                           {
                               weapon.updateDamage(1);
                           }
                           else if(a == 2)
                           {
                               weapon.updateDamage(2);
                           }
                        else if(a > LVLP)
                            System.out.println("You don't have enough level points");
                        LVLP -= a;
                       }
                    }
                   LVL += 1;
                }
            }
       }
   }
   public void updateXP(Zombie zombie)
   {
	   int totalXP = 0;
       if(zombie.isDead() && zombie.getSuperZombie())
       {
           totalXP += 35;
       }
       else if(zombie.isDead())
       {
           totalXP += 20;
           System.out.println("The zombie has been killed, you have gained 20 XP");
       }
       System.out.println("You have gained " + totalXP + " XP");
       XP += totalXP;
   }
}