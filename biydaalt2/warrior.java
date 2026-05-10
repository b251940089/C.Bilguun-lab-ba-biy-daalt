package biydaalt2;

public class warrior extends gamecharacter {
	 
    private int armor;
    private String weapon;
    private int stamina;
    private int maxStamina;
 
    public warrior(String name, int health, int level, int armor, String weapon) {
        super(name, health, level);
        this.armor = armor;
        this.weapon = weapon;
        this.stamina = 100;
        this.maxStamina = 100;
    }
 
    @Override
    protected int getPower() {
        return level * 10 + armor;
    }
 
    private String getRank() {
        if (level >= 30) {
            return "Legendary Warrior";
        } else if (level >= 15) {
            return "Elite Warrior";
        }
        return "Warrior";
    }
 
    private void recoverStamina() {
        stamina += 15;
        if (stamina > maxStamina) {
            stamina = maxStamina;
        }
    }
 
    public void attack(Monster monster) {
        if (stamina >= 25) {
            int damage = getPower() / 5;
            stamina -= 25;
            System.out.println(name + " swings " + weapon + " for " + damage + " damage! (Stamina: " + stamina + "/" + maxStamina + ")");
            monster.takeDamage(damage, weapon);
        } else {
            System.out.println(name + " is too tired to attack! (Stamina: " + stamina + "/" + maxStamina + ")");
        }
        recoverStamina();
    }
 
    public void display() {
        System.out.println("-- " + getRank() + " --");
        info();
        System.out.println("Weapon : " + weapon);
        System.out.println("Armor  : " + armor);
        System.out.println("Power  : " + getPower());
        System.out.println("Stamina: " + stamina + "/" + maxStamina);
    }
}