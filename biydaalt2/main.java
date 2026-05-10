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
 
        Monster monster = Monster.getRandom();
        System.out.println("\nA wild monster appears!");
        System.out.println();
        monster.display();
        System.out.println();
 
        if (classChoice == 1) {
 
            System.out.println("Choose your weapon:");
            System.out.println("1. Iron Sword    (strong vs: Goblin)");
            System.out.println("2. Dragon Axe    (strong vs: Dragon)");
            System.out.println("3. Battle Hammer (strong vs: Orc)");
            System.out.print("Enter 1, 2 or 3: ");
            int weaponChoice = scanner.nextInt();
 
            String weapon;
            int armor;
 
            if (weaponChoice == 1) {
                weapon = "Iron Sword";
                armor = 50;
            } else if (weaponChoice == 2) {
                weapon = "Dragon Axe";
                armor = 80;
            } else {
                weapon = "Battle Hammer";
                armor = 100;
            }
 
            warrior w = new warrior(name, 250, 20, armor, weapon);
            System.out.println();
            w.display();
            System.out.println();
 
            System.out.println("--- Battle Start ---");
            while (monster.isAlive()) {
                w.attack(monster);
            }
 
        } else {
 
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
                mana = 200;
            } else if (spellChoice == 2) {
                spell = "Ice Bolt";
                mana = 150;
            } else {
                spell = "Thunder Strike";
                mana = 250;
            }
 
            mage m = new mage(name, 150, 18, mana, spell);
            System.out.println();
            m.display();
            System.out.println();
 
            System.out.println("--- Battle Start ---");
            while (monster.isAlive()) {
                m.attack(monster);
            }
        }
 
        System.out.println("--- Battle Over ---");
        scanner.close();
    }
}
