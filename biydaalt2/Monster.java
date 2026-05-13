package biydaalt2;

public class Monster {

    private String name;
    private int health;
    private int maxHealth;
    private String weakness1;
    private String weakness2;
    private int attackPower;

    public Monster(String name, int health, String weakness1, String weakness2, int attackPower) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.weakness1 = weakness1;
        this.weakness2 = weakness2;
        this.attackPower = attackPower;
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

    // mangas dovtlono , armor ni damageiig bagasgana
    public int attack(int armor) {
        int damage = attackPower - armor / 5;
        if (damage < 1) {
            damage = 1; // urgelj ydaj 1 damage ogno
        }
        System.out.println(name + " strikes back for " + damage + " damage!");
        return damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void display() {
        System.out.println("-- Monster --");
        System.out.println("Name   : " + name);
        System.out.println("Health : " + health + "/" + maxHealth);
        System.out.println("Attack : " + attackPower);
        System.out.println("Hint   : This monster has a weakness...");
    }

    public static Monster getRandom() {
        int roll = (int) (Math.random() * 3);

        if (roll == 0) {
            String[] goblinNames = {"Goblin", "Ancient Goblin", "Goblin Chief"};
            String picked = goblinNames[(int) (Math.random() * goblinNames.length)];
            return new Monster(picked, 80, "Iron Sword", "Fireball", 20);
        }
        if (roll == 1) {
            String[] orcNames = {"Orc", "Orc Warlord", "Battle Orc"};
            String picked = orcNames[(int) (Math.random() * orcNames.length)];
            return new Monster(picked, 150, "Battle Hammer", "Thunder Strike", 35);
        }
        String[] dragonNames = {"Dragon", "Elder Dragon", "Shadow Dragon"};
        String picked = dragonNames[(int) (Math.random() * dragonNames.length)];
        return new Monster(picked, 300, "Dragon Axe", "Ice Bolt", 60);
    }
}