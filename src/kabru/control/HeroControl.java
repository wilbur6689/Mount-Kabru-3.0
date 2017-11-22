package kabru.control;

import kabru.MountKabru;
import kabru.exceptions.GameControlException;
import kabru.model.Hero;
import kabru.model.Inventory;
import kabru.model.Item;

import java.util.List;
import java.util.Scanner;

public class HeroControl {

    public static Hero createHero(String name, String answer1, String answer2, String answer3) throws GameControlException {

        if (name == null) {
            throw new GameControlException("The name variable was null.");
        }

        if (answer1 == null) {
            throw new GameControlException("The first Answer was null.");
        }
        if (answer2 == null) {
            throw new GameControlException("The second Answer was null.");
        }
        if (answer3 == null) {
            throw new GameControlException("The third Answer was null.");
        }

        int startGold = 15000;
        int strength = 0;
        int mana = 0;

        //calculate Answer1

        if (answer1.equals("M")) {
            strength += 2;
        } else if (answer1.equals("W")) {
            mana += 2;
        } else {
            return null;
        }

        //Caclulate Answer2
        if (answer2.equals("M")) {
            strength += 2;
        } else if (answer2.equals("W")) {
            mana += 2;
        } else {
            return null;
        }

        //Caclulate Answer3
        if (answer3.equals("M")) {
            strength += 2;
        } else if (answer3.equals("W")) {
            mana += 2;
        } else {
            return null;
        }

        Hero hero = new Hero();

        hero.setHeroName(name);
        hero.setLevelOfHero(1);
        hero.setXpToNextLevel(30);
        hero.setExperience(1);
        hero.setStrength(strength);
        hero.setMaxManaPoints(mana);
        hero.setCurrentManaPoints(mana);
        hero.setMaxHitPoints(20);
        hero.setCurrentHitPoints(20);
        hero.setGold(startGold);

        if (strength == 6) {
            hero.setHeroClassType("Warrior");
        } else if (mana == 6) {
            hero.setHeroClassType("Wizard");
        } else {
            hero.setHeroClassType("Paladin");
        }

        MountKabru.getCurrentGame().setHero(hero);

        Inventory inventory = InventoryControl.createInventory();
        MountKabru.getCurrentGame().getHero().setInventory(inventory);

        return hero;
    }

    public String displayHeroStats(){

        String heroName = MountKabru.getCurrentGame().getHero().getHeroName();
        String heroClass = MountKabru.getCurrentGame().getHero().getHeroClassType();
        int heroLevel = MountKabru.getCurrentGame().getHero().getLevelOfHero();
        int heroExperience = MountKabru.getCurrentGame().getHero().getExperience();
        int heroToNextLvl = MountKabru.getCurrentGame().getHero().getXpToNextLevel();
        int heroStrength = MountKabru.getCurrentGame().getHero().getStrength();
        int heroMana = MountKabru.getCurrentGame().getHero().getCurrentManaPoints();
        int heroCurrentHP = MountKabru.getCurrentGame().getHero().getCurrentHitPoints();
        int heroDefence = MountKabru.getCurrentGame().getHero().getDefense();
        int heroAttack = MountKabru.getCurrentGame().getHero().getAttack();
        int heroSpellAttack = MountKabru.getCurrentGame().getHero().getSpellAttack();
        int heroGold = MountKabru.getCurrentGame().getHero().getGold();
        String weaponSlot = MountKabru.getCurrentGame().getHero().getInventory().getWeaponSlot().getName();
        String armorSlot = MountKabru.getCurrentGame().getHero().getInventory().getArmorSlot().getName();
        String spellSlot = MountKabru.getCurrentGame().getHero().getInventory().getSpellSlot().getName();

        String stats = (
                "\n"
                        + "\n Hero Name:        " + heroName
                        + "\n Class:            " + heroClass
                        + "\n Level:            " + heroLevel
                        + "\n Experience:       " + heroExperience
                        + "\n XP to Level Up:   " + heroToNextLvl
                        + "\n Strength:         " + heroStrength
                        + "\n Mana:             " + heroMana
                        + "\n Hitpoints:        " + heroCurrentHP
                        + "\n Defence:          " + heroDefence
                        + "\n Attack:           " + heroAttack
                        + "\n Spell Atk         " + heroSpellAttack
                        + "\n Gold:             " + heroGold
                        + "\n"
                        + "\n"
        );

        return stats;
    }

    public String displayHeroInv() {

        List<Item> items = MountKabru.getCurrentGame().getHero().getInventory().getItems();
        String weaponSlot = MountKabru.getCurrentGame().getHero().getInventory().getWeaponSlot().getName();
        String armorSlot = MountKabru.getCurrentGame().getHero().getInventory().getArmorSlot().getName();
        String spellSlot = MountKabru.getCurrentGame().getHero().getInventory().getSpellSlot().getName();

        String inventory = ("\n"
                        +  "\n---------------------------------------------"
                        +  "\n"
                        +  "\n    Current Inventory:"
                        +  "\n"
                        +  "\n Current Weapon:         " + weaponSlot
                        +  "\n Current Armor:          " + armorSlot
                        +  "\n Current Spell:          " + spellSlot
                        +  "\n Backpack: "
                        +  "\n "
                        +  "\n ");

        for (Item item : items){
            inventory += item.getName().toString() + "\n";
        }

        inventory += "\n-------------------------------------------" +
                "\n";

        return inventory;
    }

    public static void healHero(Item healingItem) {

        Hero hero = MountKabru.getCurrentGame().getHero();
        int currHP = hero.getCurrentHitPoints();
        int maxHP = hero.getMaxHitPoints();
        int healPoints = healingItem.getHealthValue();

        int newHP = currHP + healPoints;
        if (newHP > maxHP){
            newHP = maxHP;
        }

        MountKabru.getCurrentGame().getHero().setCurrentHitPoints(newHP);

    }

    public static void manaHero(Item manaItem) {

        Hero hero = MountKabru.getCurrentGame().getHero();
        int currHP = hero.getCurrentHitPoints();
        int maxHP = hero.getMaxHitPoints();
        int manaPoints = manaItem.getManaValue();

        int newHP = currHP + manaPoints;
        if (newHP > maxHP){
            newHP = maxHP;
        }

        MountKabru.getCurrentGame().getHero().setCurrentHitPoints(newHP);

    }

    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
