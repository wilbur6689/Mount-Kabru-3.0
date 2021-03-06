/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabru.view;

import kabru.control.GameControl;
import kabru.model.Player;
import kabru.exceptions.GameControlException;

import kabru.MountKabru;

/**
 *
 * @author Phill
 */
public class MainMenuView extends View {

    public MainMenuView() {
        super("\n   N - Start a new game"
            + "\n   L - Load Game"
            + "\n   H - Get Help on how to play the game"
            + "\n   Q - Quit"
            + "\n------------------------------------------");
    }

    private String promptMessage;

    @Override
    public boolean doAction(String value) {

        value = value.toUpperCase(); //convert choice to upper case

        switch (value) {
            case "N": // create and start a new game
                this.startNewGame();
                break;
            case "L": // load players game
                this.loadGame();
                break;
            case "H": //help menu
                this.displayHelpMenu();
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");

        }
        return false;
    }

    private void startNewGame() {
        //Create a new game
        try {
            Player player = MountKabru.getPlayer();
            GameControl.createNewGame(player);
        } catch (GameControlException me) {
            this.console.println(me.getMessage());

        }
        // display next view
        NewCharView newCharView = new NewCharView();
        newCharView.display();
    }

    private void loadGame() {
        new LoadGameView().display();
    }

    private void displayHelpMenu() {

        // create helpHelpMenuView object
        HelpMenuView helpMenuView = new HelpMenuView();

        //display the help menu view
        helpMenuView.display();
    }

}
