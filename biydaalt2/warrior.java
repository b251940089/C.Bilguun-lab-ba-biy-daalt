package biydaalt2;

public class warrior extends gamecharacter {

    private int armor;
    private String weapon;
    private int stamina;
    private int maxStamina;

    public warrior(String name, int health, int level, int armor, String weapon, int stamina) {
        super(name, health, level);
        this.armor = armor;
        this.weapon = weapon;
        this.stamina = stamina;
        this.maxStamina = stamina;
    }

    @Override
    protected int getPower() {
        return level * 10 + armor;
    }

    public int getArmor() {
        return armor;
    }

    // Warrior amid ym uu uguin shalga
    public boolean isAlive() {
        return health > 0;
    }

    // mangasaas damage avah
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " has " + health + " HP left!");
        if (health == 0) {
            System.out.println(name + " has been defeated! Game over.");
        }
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

    private boolean isCrit() {
        return (int) (Math.random() * 4) == 0;
    }

    public void attack(Monster monster) {
        if (stamina >= 25) {
            int damage = getPower() / 5;
            stamina -= 25;

            if (isCrit()) {
                damage = damage * 2;
                System.out.println("CRITICAL HIT! " + name + " swings " + weapon + " for " + damage + " damage! (Stamina: " + stamina + "/" + maxStamina + ")");
            } else {
                System.out.println(name + " swings " + weapon + " for " + damage + " damage! (Stamina: " + stamina + "/" + maxStamina + ")");
            }

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