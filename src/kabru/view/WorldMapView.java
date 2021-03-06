
package kabru.view;

import kabru.control.WorldControl;
import kabru.model.Location;

import kabru.MountKabru;


/**
 *
 * @author wibur
 */
public class WorldMapView extends View {

    public WorldMapView() {
        super("\n   must follow example= '3 7' "
            + "\n "  
            + "\n         (1 1) - Return to town "
            + "\n  (1 2) - (1 7) - Plains         Hero Level: 1-10"
            + "\n  (2 1) - (2 7) - Jungle         Hero Level: 10-25"
            + "\n  (3 1) - (3 7) - Dark Forest    Hero Level: 25-40"
            + "\n  (4 1) - (4 7) - High Mountain  Hero Level: 40-50"
            + "\n"
            + "\n  (Q) - quit");
    }
    
    

    @Override
    public boolean doAction(String value) {
        
        String choice = value.toUpperCase(); //convert choice to upper case
        String[] valueArray = choice.split(" ");
        int row;
        int column;
        
        try {
            row = Integer.parseInt(valueArray[0]);
            column = Integer.parseInt(valueArray[1]);
        } catch (NumberFormatException nfe) {
            ErrorView.display("World Map View", "You entered the wrong number");
            return false;
        }
        
        if ((row < 1 || row > 4) || (column < 1 || column > 8)) {
        ErrorView.display("World Map View", "You have entered in the wrong number please try again.");
        return false;
        }
        
        if (row == 1 && column == 1) {
            return true;
        }
        
        //We need to call the setLocations function in the worldControl
        Location location = WorldControl.getLocation(row, column);
        MountKabru.getCurrentGame().getHero().setCurrentLocation(location);
        this.Adventure();
        if (MountKabru.getCurrentGame().isEndOfGame()){
                    return true;
                }
        
        return false;
    }

    
    
    private void Adventure() {
        AdventureView adventureView = new AdventureView();
        adventureView.display();
        
    }

}
