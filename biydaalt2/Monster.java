package biydaalt2;

public class Monster {

    private String name;
    private int health;
    private int maxHealth;
    private String weakness1;
    private String weakness2;

    public Monster(String name, int health, String weakness1, String weakness2) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.weakness1 = weakness1;
        this.weakness2 = weakness2;
    }

    public void takeDamage(int damage, String usedEquipment) {
        if (usedEquipment.equals(weakness1) || usedEquipment.equals(weakness2)) {
            damage = damage * 2;
            System.out.println("Its super effective against " + name + "!");
        }
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " took " + damage + " damage! (" + health + "/" + maxHealth + " HP left)");
        if (health == 0) {
            System.out.println(name + " has been defeated!");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void display() {
        System.out.println("-- Monster --");
        System.out.println("Name  : " + name);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Hint  : This monster has a weakness...");
    }

    public static Monster getRandom() {
        int roll = (int) (Math.random() * 3);

        if (roll == 0) return new Monster("Goblin",  80,  "Iron Sword",    "Fireball");
        if (roll == 1) return new Monster("Orc",     150, "Battle Hammer", "Thunder Strike");
        return             new Monster("Dragon",  300, "Dragon Axe",    "Ice Bolt");
    }
}