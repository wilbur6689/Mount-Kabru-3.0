
package java.view;

import java.control.GameControl;
import java.exceptions.GameControlException;
import java.model.Player;


/**
 *
 * @author wibur
 */
public class StartProgramView extends View {

    public StartProgramView() { 
            super("\n"
                + "\n" 
                + "\n______________________________________________________" 
                + "\n|****************************************************|" 
                + "\n|    88     888                __                    |" 
                + "\n|   88888  888888          ___/**\\             88    |"
                + "\n|    88888888888          /*******\\          88888   |"
                + "\n|   8888888888888        /*********\\       88888888  |"
                + "\n|                       /           \\                |"
                + "\n|             __       /             \\___            |"
                + "\n|            /  \\     /                  \\           |"
                + "\n|           /    \\___/                    \\          |"
                + "\n|       ___/                               \\______   |"
                + "\n|      /                                          \\__|"
                + "\n|     /       ~~Welcome to Mount Kabru!!!!!~~        |" 
                + "\n|    /  This game will challange your skills through |" 
                + "\n|   /   patience, knowledge, and a little bit of luck|"  
                + "\n|****************************************************|"
                + "\n|----------------------------------------------------|"
                + "\n"
                + "\n"
                + "\n Please enter your name: ");}


    @Override
    public boolean doAction(String playersName) {

        Player player = null;

        try {
            // Call createPlayer() control function
            player = GameControl.createPlayer(playersName);
            }
            catch (GameControlException me){
                this.console.println(me.getMessage());
            }
            if (player == null) { //if unsuccessful
                this.console.println("\nError creating the player.");
                return false;
            }


            this.displayNextView(player);

            return true;

        }


       
    private void displayNextView(Player player) {
        this.console.println("\n ====================================="
                + "\n Welcome to the game " + player.getName()
                + "\n We hope you have a lot of fun!"
                + "\n ====================================="
        );

        //Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();

        //Display the main menu view
        mainMenuView.display();
    }
    
}
