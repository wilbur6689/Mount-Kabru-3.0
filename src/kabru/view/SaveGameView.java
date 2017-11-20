/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabru.view;

import kabru.control.GameControl;
import kabru.MountKabru;

/**
 *
 * @author wibur
 */
public class SaveGameView extends View{

    public SaveGameView() {
        super("Enter the file name where you wish to save your game: ");
    }

    @Override
    public boolean doAction(String filePath) {
       

        try {
            GameControl.saveGame(MountKabru.getCurrentGame(), filePath);

        } catch (Exception e) {
            ErrorView.display("MainMenuView", e.getMessage());
            return false;
        }

       this.console.println("Your game was saved to " + filePath );
        
       return true;
    }
    
    
    
}
