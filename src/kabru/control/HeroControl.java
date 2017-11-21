package kabru.control;

import kabru.MountKabru;
import kabru.model.Item;

import java.util.List;
import java.util.Scanner;

public class HeroControl {

    public String displayHeroStats(){

        String heroName = MountKabru.getCurrentGame().getHero().getHeroName();
        String heroClass = MountKabru.getCurrentGame().getHero().getHeroClassType();
        int heroLevel = MountKabru.getCurrentGame().getHero().getLevelOfHero();
        int heroExperience = MountKabru.getCurrentGame().getHero().getExperience();
        int heroToNextLvl = MountKabru.getCurrentGame().getHero().getXpToNextLevel();
        int heroStrength = MountKabru.getCurrentGame().getHero().getStrength();
        int heroMana = MountKabru.getCurrentGame().getHero().getMana();
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

        String inventory = "\n"
                        +  "\n---------------------------------------------" +
                "\n" +
                "\n    Current Inventory:" +
                "\n";

        for (Item item : items){
            inventory += item.getName().toString() + "\n";
        }

        inventory += "\n-------------------------------------------" +
                "\n";

        return inventory;
    }

    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
