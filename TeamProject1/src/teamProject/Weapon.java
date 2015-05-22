/**
 * Author: Matthew Johnson
 */
package teamProject;

public class Weapon {
	 private String weapon;
	    private int bullets;
	    private int arrow;
	    //private int attack; attack and damage are the same thing
	    private int damage;
	    
	    public Weapon(){
	       weapon = null;
	       bullets = 0;
	       arrow = 0;
	    }
	    public void setWeapon(String w){
	    	 weapon = w;
		        if(w.equals("1"))
		        {
		            bullets = 5;
		            damage = 15;
		        }
		        if(w.equals("2"))
		        {
		            arrow = 10;
		            damage = 12;
		        }
		        if(w.equals("3"))
		        {
		            damage = 10;
		        }
	    }
	    public String getWeapon(){
	        return weapon;
	    }
	    public int getBullets(){
	        return bullets;
	    }
	    public int getArrows(){
	        return arrow;
	    }
	    public int getDamage(){
	        return damage;
	    }
	    public void updateBullets(int i){
	    	bullets += i;
	    }
	    public void updateArrows(int i){
	    	arrow += i;
	    }
	    public void updateDamage(int d){
	    	damage += d;
	    }
}