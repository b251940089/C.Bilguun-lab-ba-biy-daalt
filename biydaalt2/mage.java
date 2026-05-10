package biydaalt2;

public class mage extends gamecharacter {
	 
    private int mana;
    private int maxMana;
    private String spell;
 
    public mage(String name, int health, int level, int mana, String spell) {
        super(name, health, level);
        this.mana = mana;
        this.maxMana = mana;
        this.spell = spell;
    }
 
    @Override
    protected int getPower() {
        return level * 10 + mana / 2;
    }
 
    public void attack(Monster monster) {
        if (mana >= 50) {
            int damage = getPower() / 4;
            mana -= 50;
            System.out.println(name + " casts " + spell + " for " + damage + " damage! (Mana: " + mana + "/" + maxMana + ")");
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
        System.out.println("Mana  : " + mana + "/" + maxMana);
        System.out.println("Spell : " + spell);
        System.out.println("Power : " + getPower());
    }
}
 