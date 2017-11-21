package kabru.view;

import kabru.MountKabru;
import kabru.control.HeroControl;
import kabru.model.Item;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UsePotionView extends View {

    public UsePotionView() {
        super("\n"
                + "\n----------------------------------------"
                + "\n|  You look through your bag in hopes  |"
                + "\n|  for something good to drink...      |"
                + "\n----------------------------------------"
                + "\nH - [H]ealth Potion"
                + "\nM - [M]ana Potion"
                + "\nC - [C]heck your stats"
                + "\nI - [I]nventory"
                + "\nR - [R]eturn back to your Adventure"
                + "\n--------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); //convert choice to upper case

        switch (choice) {
            case "H": // view your stats
                this.drinkHealth();
                break;
            case "M": //vier your inventory
                this.drinkMana();
                break;
            case "C": // view your stats
                this.checkStats();
                break;
            case "I": //vier your inventory
                this.checkInv();
                break;
            case "R": // use a potion
                return true;

            default:
                this.console.println("\n*** Invalid selection *** Try again");

        }
        return false;
    }

    private void drinkHealth() {

        //look through the inventory for a health potion
        List<Item> items = MountKabru.getCurrentGame().getHero().getInventory().getItems();
        List<Item> healthPotions = items.stream().filter(item -> item.getHealthValue() > 0).collect(Collectors.toList());
        int index = 0;

        String healthDisplay = "\n-------------------------------------------------"
                    + "\n"
                    + "\n      Here are your health potions: \n";
        for (Item item : healthPotions){
            healthDisplay += " "+ index + ". " + item.getName().toString() + "\n";
            index++;
        }
        healthDisplay += "\n-------------------------------------------------" +
                      "\n";

        this.console.println(healthDisplay);

        Scanner scanner = new Scanner(System.in);

        HeroControl.healHero(healthPotions.get(scanner.nextInt()));

    }

    private void drinkMana() {

        //look through the inventory for a mana potion
        List<Item> items = MountKabru.getCurrentGame().getHero().getInventory().getItems();
        List<Item> manaPotions = items.stream().filter(item -> item.getManaValue() > 0).collect(Collectors.toList());
        int index = 0;

        String manaDisplay = "\n-------------------------------------------------"
                + "\n"
                + "\n      Here are your mana potions: \n";

        for (Item item : manaPotions){
            manaDisplay += " "+ index + ". " + item.getName().toString() + "\n";
            index++;
        }

        manaDisplay += "\n-------------------------------------------------" +
                "\n";

        this.console.println(manaDisplay);

        Scanner scanner = new Scanner(System.in);

        HeroControl.manaHero(manaPotions.get(scanner.nextInt()));

    }


    private void checkStats() {
        HeroControl heroControl = new HeroControl();
        this.console.println(heroControl.displayHeroStats());
        heroControl.promptEnterKey();
    }

    private void checkInv() {
        HeroControl heroControl = new HeroControl();
        this.console.println(heroControl.displayHeroInv());
        heroControl.promptEnterKey();
    }
}
