package biydaalt2;

public class mage extends gamecharacter {

    private int mana;
    private int maxMana;
    private String spell;
    private int armor;

    public mage(String name, int health, int level, int mana, String spell, int armor) {
        super(name, health, level);
        this.mana = mana;
        this.maxMana = mana;
        this.spell = spell;
        this.armor = armor;
    }

    @Override
    protected int getPower() {
        return level * 10 + mana / 2;
    }

    public boolean isAlive() {
        return health > 0;
    }

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

    private boolean isCrit() {
        return (int) (Math.random() * 4) == 0;
    }

    public void attack(Monster monster) {
        if (mana >= 50) {
            int damage = getPower() / 4;
            mana -= 50;

            if (isCrit()) {
                damage = damage * 2;
                System.out.println("CRITICAL HIT! " + name + " casts " + spell + " for " + damage + " damage! (Mana: " + mana + "/" + maxMana + ")");
            } else {
                System.out.println(name + " casts " + spell + " for " + damage + " damage! (Mana: " + mana + "/" + maxMana + ")");
            }

            monster.takeDamage(damage, spell);
        } else {
            System.out.println(name + " is out of mana and cannot cast!");
            System.out.println("Game over - " + name + " is powerless!");
            System.exit(0);
        }
    }

    public void display() {
        System.out.println("-- Mage --");
        info();
        System.out.println("Armor : " + armor);
        System.out.println("Mana  : " + mana + "/" + maxMana);
        System.out.println("Spell : " + spell);
        System.out.println("Power : " + getPower());
    }
}