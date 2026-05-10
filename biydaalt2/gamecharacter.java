package biydaalt2;

public class gamecharacter {
	 
    protected String name;
    protected int health;
    protected int level;
 
    public gamecharacter(String name, int health, int level) {
        this.name = name;
        this.health = health;
        this.level = level;
    }
 
    protected int getPower() {
        return level * 10;
    }
 
    protected void info() {
        System.out.println("Name  : " + name);
        System.out.println("Health: " + health);
        System.out.println("Level : " + level);
    }
 
    public void display() {
        System.out.println("-- Character --");
        info();
        System.out.println("Power : " + getPower());
    }
}