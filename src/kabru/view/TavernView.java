
package kabru.view;

import kabru.model.Item;
import kabru.control.TavernControl;

import kabru.MountKabru;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Phill
 */
public class TavernView extends View{
    
   
    
    public TavernView() {
            super ("\n"
                + "\n--------------------------------------"
                + "\n|  You meander in the tavern looking |"
                + "\n|  as tough as you can.               |"  
                + "\n--------------------------------------"
                + "\nT - talk to the [T]avern owner    - Costs your dignity"
                + "\nS - get a room and [S]leep it off - Costs 250 Gold"
                + "\nH - buy a [H]ealth potion         - Costs 100 Gold"
                + "\nM - buy a [M]ana potion           - Costs 100 Gold"
                + "\nQ - return to town"
                + "\n--------------------------------------");}
    
    
    
    private String promptMessage;

    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); //convert choice to upper case
        
        switch (value) {
            case "T": // go talk to the tavern owner
                this.tavernOwner();
                break;
            case "S": // get a room in the tavern and sleep
                this.sleep();
                break;
            case "H": // buy a health potion
                this.buyHealthPotion();
                break;
            case "M": // buy a mana potion
                this.buyManaPotion();
                break;
            case "R": // buy a mana potion
                this.buyReturn();
                break;
                
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                
                         
        }
        return false;
    }

    
    
    private void tavernOwner() {
         String levelOfHeroString;
         int levelOfHero;
         try{
         
         this.console.println("What level are you, hero?");
         levelOfHeroString = this.keyboard.readLine();
         levelOfHero = parseInt(levelOfHeroString);

             String result = TavernControl.ownerResponse(levelOfHero);
             this.console.println("\n*** You walk over to the Tavern Owner ***"
                     + "\n*** and ask him for advise:           ***"
                     + "\n "
                     + "\n " + result);
         } catch (Exception e) {
             this.console.println(e.getMessage());
         }

    }
          
    private void sleep() {
        
        int maxHP = MountKabru.getCurrentGame().getHero().getMaxHitPoints();
        int goldBefore = MountKabru.getCurrentGame().getHero().getGold();
        
        String response;
        
        
        
        if (goldBefore < 250) {
            response = "\n Sorry you do not have enough gold";
            
        } else {
            int goldAfter = goldBefore - 250;
            MountKabru.getCurrentGame().getHero().setGold(goldAfter);
            response = "\n you sleep well and feel refreshed ";
            MountKabru.getCurrentGame().getHero().setCurrentHitPoints(maxHP);
        }
        
        this.console.println(response);
    }

    private void buyHealthPotion() {
        int beforeGold = MountKabru.getCurrentGame().getHero().getGold();

        if (beforeGold < 100) {
            this.console.println("Sorry, but you dont have enough gold.");
        } else {
            int afterGold = beforeGold - 100;
            MountKabru.getCurrentGame().getHero().setGold(afterGold);
            List<Item> items = MountKabru.getCurrentGame().getHero().getInventory().getItems();
            items.add(Item.healthPotion10);
            MountKabru.getCurrentGame().getHero().getInventory().setItems(items);
            this.console.println("Thank you for buying a health Potion");
        }
    }

    private void buyManaPotion() {
       int beforeGold = MountKabru.getCurrentGame().getHero().getGold();

        if (beforeGold < 100) {
            this.console.println("Sorry, but you dont have enough gold.");
        } else {
            int afterGold = beforeGold - 100;
            MountKabru.getCurrentGame().getHero().setGold(afterGold);
            List<Item> items = MountKabru.getCurrentGame().getHero().getInventory().getItems();
            items.add(Item.manaPotion10);
            MountKabru.getCurrentGame().getHero().getInventory().setItems(items);
            this.console.println("Thank you for buying a Mana Potion");
        }

    }

    private void buyReturn() {
        GameMenuView menu = new GameMenuView();
        menu.display();
    }
}
