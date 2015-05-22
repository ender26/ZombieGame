package teamProject;



import java.util.Random;

/**

 * Write a description of class Zombie here.

 * 

 * @author (your name) 

 * @version (a version number or a date)

 */

public class Zombie

{

    private int damage;
    private int health;
    private int superZombieHealth;
    private boolean superZombie;
    private String zombieName;
    Player player;
    
    Random gen = new Random();

    String[] bite ={"bite", "miss", "miss", "miss", "miss", "miss", "miss", "miss", "miss", "miss"};

    public Zombie()
    {
        damage = -3;
        health = 15;
        superZombie = false;
        zombieName = "zombie";
    }

    public Zombie(int h, int d)
    {
        damage = d;
        health = h;
        superZombie = true;
    }
    
    public String getName(){
    return zombieName;
    }
    
    public boolean getSuperZombie()
    {
        return superZombie;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getHealth()
    {
        return health;
    }

    public void attack(Player player)
    {
        player.updateHealth(damage);
    }

    public void changeHealth(int points)
    {
        health-=points; 
    }

    public void bite()
    {
        int i = gen.nextInt(7);
        
        if(player.getHealth() <= 30) 
        { 
            System.out.print(bite[i]);
            if(i == 0)
            {
            player.updateHealth(0);
                System.out.println("\n\n\nYou have been bitten by a zombie.\n" 
                + "You slowly go insane and die.");
            }
        }
    }

    public void generateSuperZombie()
    {
        int randNum = gen.nextInt(10) + 1;
        if(randNum == 5)
        {   
            if(superZombie == true){
                health = 25;
                damage = 6;
            }
        }
    }

    public boolean isDead(){
    if(health <= 0){
    System.out.println("The zombie has died");
    return true;
    }
    else 
    return false;
    }
}