/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kabru.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author wibur
 */
public class Actor implements Serializable{
    
    
    
    //class instance variables
    private String name;
    private int maxHitPoints;
    private int currentHitPoints;
    private int maxManaPoints;
    private int currentManaPoints;
    private int defense;
    private int attack;
    private int spellAttack;
    private int xpGained;
    private int gold;
    
    private Event[] randomEvent;
    private Game game;

    public Actor() {
        
    }

    //        private String name;
//    private int hitPoints;
//    private int defence;
//    private int attack;
//    private int spellAttack;
//    private int chanceToHit;
//    private int gold;


    public Actor(String name, int maxHitPoints, int currentHitPoints, int defense, int attack, int spellAttack, int xpGained, int gold) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = currentHitPoints;
        this.defense = defense;
        this.attack = attack;
        this.spellAttack = spellAttack;
        this.xpGained = xpGained;
        this.gold = gold;
    }

    public Actor(String name, int maxHitPoints, int currentHitPoints, int maxManaPoints, int currentManaPoints, int defense, int attack, int spellAttack, int xpGained, int gold) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = currentHitPoints;
        this.maxManaPoints = maxManaPoints;
        this.currentManaPoints = currentManaPoints;
        this.defense = defense;
        this.attack = attack;
        this.spellAttack = spellAttack;
        this.xpGained = xpGained;
        this.gold = gold;
    }

    
    public Event[] getRandomEvent() {
        return randomEvent;
    }

    public void setRandomEvent(Event[] randomEvent) {
        this.randomEvent = randomEvent;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getMaxManaPoints() {
        return maxManaPoints;
    }

    public void setMaxManaPoints(int maxManaPoints) {
        this.maxManaPoints = maxManaPoints;
    }

    public int getCurrentManaPoints() {
        return currentManaPoints;
    }

    public void setCurrentManaPoints(int currentManaPoints) {
        this.currentManaPoints = currentManaPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpellAttack() {
        return spellAttack;
    }

    public void setSpellAttack(int spellAttack) {
        this.spellAttack = spellAttack;
    }
    

    public int getXpGained() {
        return xpGained;
    }

    public void setXpGained(int xpGained) {
        this.xpGained = xpGained;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (maxHitPoints != actor.maxHitPoints) return false;
        if (currentHitPoints != actor.currentHitPoints) return false;
        if (maxManaPoints != actor.maxManaPoints) return false;
        if (currentManaPoints != actor.currentManaPoints) return false;
        if (defense != actor.defense) return false;
        if (attack != actor.attack) return false;
        if (spellAttack != actor.spellAttack) return false;
        if (xpGained != actor.xpGained) return false;
        if (gold != actor.gold) return false;
        if (name != null ? !name.equals(actor.name) : actor.name != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(randomEvent, actor.randomEvent)) return false;
        return game != null ? game.equals(actor.game) : actor.game == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + maxHitPoints;
        result = 31 * result + currentHitPoints;
        result = 31 * result + maxManaPoints;
        result = 31 * result + currentManaPoints;
        result = 31 * result + defense;
        result = 31 * result + attack;
        result = 31 * result + spellAttack;
        result = 31 * result + xpGained;
        result = 31 * result + gold;
        result = 31 * result + Arrays.hashCode(randomEvent);
        result = 31 * result + (game != null ? game.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", maxHitPoints=" + maxHitPoints +
                ", currentHitPoints=" + currentHitPoints +
                ", maxManaPoints=" + maxManaPoints +
                ", currentManaPoints=" + currentManaPoints +
                ", defense=" + defense +
                ", attack=" + attack +
                ", spellAttack=" + spellAttack +
                ", xpGained=" + xpGained +
                ", gold=" + gold +
                ", randomEvent=" + Arrays.toString(randomEvent) +
                ", game=" + game +
                '}';
    }
}
