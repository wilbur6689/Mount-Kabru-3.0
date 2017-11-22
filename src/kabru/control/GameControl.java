
package kabru.control;

import kabru.model.Actor;
import kabru.model.Hero;

import kabru.exceptions.GameControlException;
import kabru.model.Game;
import kabru.model.Inventory;
import kabru.model.Player;
import kabru.model.World;
import kabru.MountKabru;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author wibur
 */
public class GameControl {

    public static Player createPlayer(String name) throws GameControlException {

        if (name == null) {
            throw new GameControlException("The name variable was null.");
        }

        Player player = new Player();
        player.setName(name);
        MountKabru.setPlayer(player); //save the player  
        return player;
    }

    public static void createNewGame(Player player) throws GameControlException {

        if (player == null) {
            throw new GameControlException("The player variable was null.");
        }

        Game game = new Game();
        MountKabru.setCurrentGame(game);

        game.setPlayer(player);

        //create a list of monsters
        Actor[][] actors = ActorControl.createActors();
        game.setActors(actors);

        World world = WorldControl.createWorld();
        game.setWorld(world);

    }

    public static void saveGame(Game game, String fileName) throws GameControlException {

        String filePath = "saveGames\\" + fileName;
        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);

            output.writeObject(game); //write game to object File
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        } 
            
        
    }

    public static void loadGame(String fileName) throws GameControlException {

        String filePath = "saveGames\\" + fileName;
        Game game = null;
        try (FileInputStream fips = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(fips);

            game = (Game) input.readObject(); //read the game object from file
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }

        MountKabru.setCurrentGame(game);
    }

    public static void raiseTheLevel() {

        //get the class of the hero
        String heroClass = MountKabru.getCurrentGame().getHero().getHeroClassType();

        if (heroClass.equals("Warrior")) {

            //do stuff for warrior
            //get before stats (with getters) that you want to change(health, str,level)
            int beforeHealth = MountKabru.getCurrentGame().getHero().getMaxHitPoints();
            int beforeStrength = MountKabru.getCurrentGame().getHero().getStrength();
            int beforeLvlUp = MountKabru.getCurrentGame().getHero().getLevelOfHero();
            int beforeXpToNextLevel = MountKabru.getCurrentGame().getHero().getXpToNextLevel();

            //add stuff and set them to new variables
            int afterHealth = beforeHealth + 40;
            int afterStrength = beforeStrength + 2;
            int afterLvlUp = beforeLvlUp + 1;
            int afterXpToNextLevel = beforeXpToNextLevel + beforeHealth + 100;
            //set the new variables to the hero stats with a "setter"

            MountKabru.getCurrentGame().getHero().setMaxHitPoints(afterHealth);
            MountKabru.getCurrentGame().getHero().setCurrentHitPoints(afterHealth);
            MountKabru.getCurrentGame().getHero().setStrength(afterStrength);
            MountKabru.getCurrentGame().getHero().setLevelOfHero(afterLvlUp);
            MountKabru.getCurrentGame().getHero().setXpToNextLevel(afterXpToNextLevel);

        } else if (heroClass.equals("Wizard")) {
            //do stuff for Wizard
            //get before stats (with getters) that you want to change(health, Mana,level)

            int beforeHealth = MountKabru.getCurrentGame().getHero().getMaxHitPoints();
            int beforeMana = MountKabru.getCurrentGame().getHero().getMaxManaPoints();
            int beforeLvlUp = MountKabru.getCurrentGame().getHero().getLevelOfHero();
            int beforeXpToNextLevel = MountKabru.getCurrentGame().getHero().getXpToNextLevel();

            //add stuff and set them to new variables
            int afterHealth = beforeHealth + 50;
            int afterMana = beforeMana + 2;
            int afterLvlUp = beforeLvlUp + 1;
            int afterXpToNextLevel = beforeXpToNextLevel + 200;
            //set the new variables to the hero stats with a "setter"

            MountKabru.getCurrentGame().getHero().setMaxHitPoints(afterHealth);
            MountKabru.getCurrentGame().getHero().setCurrentHitPoints(afterHealth);
            MountKabru.getCurrentGame().getHero().setCurrentManaPoints(afterMana);
            MountKabru.getCurrentGame().getHero().setMaxManaPoints(afterMana);
            MountKabru.getCurrentGame().getHero().setLevelOfHero(afterLvlUp);
            MountKabru.getCurrentGame().getHero().setXpToNextLevel(afterXpToNextLevel);
        } else {
            //do stuff for the Paladin
            //get before stats (with getters) that you want to change(health, Mana, and str,level)

            int beforeHealth = MountKabru.getCurrentGame().getHero().getMaxHitPoints();
            int beforeStrength = MountKabru.getCurrentGame().getHero().getStrength();
            int beforeMana = MountKabru.getCurrentGame().getHero().getMaxManaPoints();
            int beforeLvlUp = MountKabru.getCurrentGame().getHero().getLevelOfHero();
            int beforeXpToNextLevel = MountKabru.getCurrentGame().getHero().getXpToNextLevel();
            //add stuff and set them to new variables

            int afterHealth = beforeHealth + 50;
            int afterStrength = beforeStrength + 1;
            int afterMana = beforeMana + 1;
            int afterLvlUp = beforeLvlUp + 1;
            int afterXpToNextLevel = beforeXpToNextLevel + 200;

            //set the new variables to the hero stats with a "setter"
            MountKabru.getCurrentGame().getHero().setMaxHitPoints(afterHealth);
            MountKabru.getCurrentGame().getHero().setCurrentHitPoints(afterHealth);
            MountKabru.getCurrentGame().getHero().setStrength(afterStrength);
            MountKabru.getCurrentGame().getHero().setLevelOfHero(afterLvlUp);
            MountKabru.getCurrentGame().getHero().setCurrentManaPoints(afterMana);
            MountKabru.getCurrentGame().getHero().setMaxManaPoints(afterMana);
            MountKabru.getCurrentGame().getHero().setXpToNextLevel(afterXpToNextLevel);
        }

    }

}
