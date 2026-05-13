package biydaalt2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your character name: ");
        String name = scanner.nextLine();

        System.out.println("Choose your class:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.print("Enter 1 or 2: ");
        int classChoice = scanner.nextInt();

        System.out.print("Choose your level (1 - 50): ");
        int level = scanner.nextInt();

        if (level < 1) level = 1;
        if (level > 50) level = 50;

        Monster monster = Monster.getRandom();
        System.out.println("\nA wild monster appears!");
        System.out.println();
        monster.display();
        System.out.println();

        int attackCount = 0;

        if (classChoice == 1) {

            System.out.println("You have chosen the path of the Warrior. Glory awaits!");
            System.out.println();

            System.out.println("Choose your armor:");
            System.out.println("1. Leather Armor  (armor: 30  - light, fast)");
            System.out.println("2. Chain Mail     (armor: 60  - balanced)");
            System.out.println("3. Plate Armor    (armor: 100 - heavy, strong)");
            System.out.print("Enter 1, 2 or 3: ");
            int armorChoice = scanner.nextInt();

            String armorName;
            int armor;

            if (armorChoice == 1) {
                armorName = "Leather Armor";
                armor = 30;
            } else if (armorChoice == 2) {
                armorName = "Chain Mail";
                armor = 60;
            } else {
                armorName = "Plate Armor";
                armor = 100;
            }

            System.out.println("Choose your weapon:");
            System.out.println("1. Iron Sword    (strong vs: Goblin)");
            System.out.println("2. Dragon Axe    (strong vs: Dragon)");
            System.out.println("3. Battle Hammer (strong vs: Orc)");
            System.out.print("Enter 1, 2 or 3: ");
            int weaponChoice = scanner.nextInt();

            String weapon;
            int weaponBonus;

            if (weaponChoice == 1) {
                weapon = "Iron Sword";
                weaponBonus = 50;
            } else if (weaponChoice == 2) {
                weapon = "Dragon Axe";
                weaponBonus = 80;
            } else {
                weapon = "Battle Hammer";
                weaponBonus = 100;
            }

            int health = 100 + level * 10;
            int stamina = 50 + level * 2;

            System.out.println("\nEquipped: " + armorName + " and " + weapon);

            warrior w = new warrior(name, health, level, armor + weaponBonus, weapon, stamina);
            System.out.println();
            w.display();
            System.out.println();

            System.out.println("--- Battle Start ---");
            while (monster.isAlive() && w.isAlive()) {
                w.attack(monster);
                if (monster.isAlive()) {
                    int damage = monster.attack(w.getArmor());
                    w.takeDamage(damage);
                }
                attackCount++;
            }

            if (!w.isAlive()) {
                System.out.println("--- You lost! ---");
                scanner.close();
                return;
            }

        } else {

            System.out.println("You have chosen the path of the Mage. May your spells never fail!");
            System.out.println();

            System.out.println("Choose your robe:");
            System.out.println("1. Cloth Robe     (armor: 5   - max mana bonus)");
            System.out.println("2. Enchanted Robe (armor: 20  - balanced)");
            System.out.println("3. Arcane Armor   (armor: 40  - tankier mage)");
            System.out.print("Enter 1, 2 or 3: ");
            int robeChoice = scanner.nextInt();

            String robeName;
            int robeArmor;
            int manaBonus;

            if (robeChoice == 1) {
                robeName = "Cloth Robe";
                robeArmor = 5;
                manaBonus = 100;
            } else if (robeChoice == 2) {
                robeName = "Enchanted Robe";
                robeArmor = 20;
                manaBonus = 50;
            } else {
                robeName = "Arcane Armor";
                robeArmor = 40;
                manaBonus = 0;
            }

            System.out.println("Choose your spell:");
            System.out.println("1. Fireball       (strong vs: Goblin)");
            System.out.println("2. Ice Bolt        (strong vs: Dragon)");
            System.out.println("3. Thunder Strike  (strong vs: Orc)");
            System.out.print("Enter 1, 2 or 3: ");
            int spellChoice = scanner.nextInt();

            String spell;
            int mana;

            if (spellChoice == 1) {
                spell = "Fireball";
                mana = 100 + level * 5 + manaBonus;
            } else if (spellChoice == 2) {
                spell = "Ice Bolt";
                mana = 80 + level * 5 + manaBonus;
            } else {
                spell = "Thunder Strike";
                mana = 120 + level * 5 + manaBonus;
            }

            int health = 80 + level * 8;

            System.out.println("\nEquipped: " + robeName);

            mage m = new mage(name, health, level, mana, spell, robeArmor);
            System.out.println();
            m.display();
            System.out.println();

            System.out.println("--- Battle Start ---");
            while (monster.isAlive() && m.isAlive()) {
                m.attack(monster);
                if (monster.isAlive()) {
                    int damage = monster.attack(robeArmor);
                    m.takeDamage(damage);
                }
                attackCount++;
            }

            if (!m.isAlive()) {
                System.out.println("--- You lost! ---");
                scanner.close();
                return;
            }
        }

        System.out.println("--- Battle Over ---");
        System.out.println("You defeated the enemy in " + attackCount + " attacks!");

        if (attackCount <= 3) {
            System.out.println("Flawless Victory!");
        } else if (attackCount <= 6) {
            System.out.println("Well fought!");
        } else {
            System.out.println("That was a tough fight...");
        }

        scanner.close();
    }
}