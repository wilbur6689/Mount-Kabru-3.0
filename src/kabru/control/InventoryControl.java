package kabru.control;

import kabru.model.Item;
import kabru.model.Inventory;

import kabru.MountKabru;

/**
 * Created by badgerwaves on 2/10/16.
 */
public class InventoryControl {
    
    
    public static Inventory createInventory() {
        
        
        Inventory inventory = new Inventory(Item.bareHands, Item.clothes, Item.lameMagic);
        
        
         MountKabru.getCurrentGame().getHero().setInventory(inventory);
         int attack = MountKabru.getCurrentGame().getHero().getInventory().getWeaponSlot().getAttackValue();
         int defense = MountKabru.getCurrentGame().getHero().getInventory().getWeaponSlot().getDefenseValue();
         int spellAttack = MountKabru.getCurrentGame().getHero().getInventory().getSpellSlot().getSpellAttackValue();
         MountKabru.getCurrentGame().getHero().setAttack(attack);
         MountKabru.getCurrentGame().getHero().setDefense(defense);
         MountKabru.getCurrentGame().getHero().setSpellAttack(spellAttack);
         
        
        return inventory;
    }
    
    public static String[] viewInventory() {
        
        String[] inventory = new String[5];
        
        inventory[0] = MountKabru.getCurrentGame().getHero().getInventory().getWeaponSlot().getName();
        inventory[1] = MountKabru.getCurrentGame().getHero().getInventory().getArmorSlot().getName();
        inventory[4] = MountKabru.getCurrentGame().getHero().getInventory().getSpellSlot().getName();

        return inventory;
    }
    
    
}
