/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabru.view;

import kabru.control.ActorControl;
import kabru.control.EventControl;
import kabru.control.HeroControl;
import kabru.control.WorldControl;
import kabru.model.*;

import kabru.MountKabru;

import java.util.List;

/**
 *
 * @author Phill
 */
public class AdventureView extends View {

    public AdventureView() {
        super("\n"
                + "\n----------------------------------------"
                + "\n|  You wander out of town and try to   |"
                + "\n|  decide what to fight next...        |"
                + "\n----------------------------------------"
                + "\nS - [S]earch for a monster"
                + "\nP - use a [P]otion"
                + "\nC - [C]heck your stats"
                + "\nI - [I]nventory"
                + "\nR - [R]eturn back to Map"
                + "\n--------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {

        choice = choice.toUpperCase(); //convert choice to upper case

        switch (choice) {
            case "S": // go kill stuff in the Jungle
                this.searchForMonster();
                if (MountKabru.getCurrentGame().isEndOfGame()){
                    return true;
                }
                break;
            case "P": // use a potion
                this.usePotion();
                break;
            case "C": // view your stats
                this.checkStats();
                break;
            case "I": //vier your inventory
                this.checkInv();
                break;
            case "L": // use a potion
                this.curLocation();
                break;
            case "X": // use a potion
                this.changeLocation();
                break;
            case "R": // use a potion
                return true;

            default:
                this.console.println("\n*** Invalid selection *** Try again");

        }
        return false;
    }

    private void searchForMonster() {

        Actor[] monsters = MountKabru.getCurrentGame().getHero().getCurrentLocation().getEvent().getActors();

        if (monsters != null) {
            Actor monsterYouFight = monsters[ActorControl.pickRandomMonster()];
            int maxHP = monsterYouFight.getMaxHitPoints();
            monsterYouFight.setCurrentHitPoints(maxHP);
            MountKabru.getCurrentGame().getHero().setFoundMonster(monsterYouFight);

            //create the Attack Monster view object
            AttackMonsView attackMonsView = new AttackMonsView();
            //display the Attack Monster view
            attackMonsView.display();
            return;
        } else {
            int[] goldEvents = MountKabru.getCurrentGame().getHero().getCurrentLocation().getEvent().getGoldEvent();

            int goldFound = goldEvents[ActorControl.pickRandomGold()];
            this.console.println("You Found this much GOLD: " + goldFound);
            int givePlayerGold = MountKabru.getCurrentGame().getHero().getGold() + goldFound;
            MountKabru.getCurrentGame().getHero().setGold(givePlayerGold);

            World world = MountKabru.getCurrentGame().getWorld();
            Location[][] locations = MountKabru.getCurrentGame().getWorld().getLocations();
            Event[][] events = EventControl.createEvents();

            for (int i = 0; i < locations.length; i++) {
                for (int j = 0; j < locations[i].length - 1; j++) {
                    //                events[i][j] = locations[i][j].getEvent();
                    //System.out.println(locations[i][j].getEvent().getEventType());
                }
            }
            WorldControl.setEventsToLocations(world, events);

        }

    }

    private void usePotion() {

        UsePotionView potionView = new UsePotionView();
        potionView.display();
        
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

    private void curLocation() {
        String eventType = MountKabru.getCurrentGame().getHero().getCurrentLocation().getEvent().getEventType();
        String locationType = MountKabru.getCurrentGame().getHero().getCurrentLocation().getEvent().getLocationType();
        String eventName = MountKabru.getCurrentGame().getHero().getCurrentLocation().getEvent().getEventName();

        this.console.println("This is your event type: " + eventType
                + "\n This is your location type: " + locationType
                + "\n this is the event name: " + eventName);

    }

    private void changeLocation() {
        World world = MountKabru.getCurrentGame().getWorld();
        Location[][] locations = MountKabru.getCurrentGame().getWorld().getLocations();
        Event[][] events = EventControl.createEvents();

        for (int i = 0; i < locations.length; i++) {
            for (int j = 0; j < locations[i].length - 1; j++) {
//                events[i][j] = locations[i][j].getEvent();
                System.out.println(locations[i][j].getEvent().getEventType());
            }
        }

        WorldControl.setEventsToLocations(world, events);

    }

}
