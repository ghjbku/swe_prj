package Game.game_objects;

import Game.Game;
import Game.game_objects.Item;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

/**
 * The Player class "model".
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(propOrder = {"name", "items", "posx", "posy", "lastx", "lasty", "gender", "score", "fought", "wellevent_done", "signevent_done"})
public class Player {
    private String name;
    private String gender = "female";
    private int posx = 5, posy = 25, score = 0, lastx = posx, lasty = posy;
    private ArrayList<Item> items = new ArrayList<Item>();
    private boolean fought = false;
    private boolean signevent_done = false;
    private boolean wellevent_done = false;

    /**
     * default constructor.
     */
    public Player() {
    }

    /**
     * sets the player's inventory with the parameter.
     *
     * @param items the items to put into the inventory.
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * gets the player's inventory.
     *
     * @return items of the inventory.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * returns the item that is placed in the corresponding slot that the function got as param.
     *
     * @param i index of the slot.
     * @return an item.
     */
    public Item getitem(int i) {
        return items.get(i);
    }

    /**
     * returns the gender of the player.
     *
     * @return the gender of the player.
     */
    public String getgender() {
        return gender;
    }

    /**
     * sets the gender of the player.
     *
     * @param gend the gender of the player.
     */
    public void setgender(String gend) {
        this.gender = gend;
    }

    /**
     * returns the name of the player.
     *
     * @return the name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the player.
     *
     * @param name the name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * returns the x coord of the player.
     *
     * @return the x coord of the player.
     */
    public int getPosx() {
        return posx;
    }

    /**
     * returns the y coord of the player.
     *
     * @return the y coord of the player.
     */
    public int getPosy() {
        return posy;
    }

    /**
     * sets the x coord of the player.
     *
     * @param x the x coord of the player.
     */
    public void setPosx(int x) {
        this.posx = x;
    }

    /**
     * sets the y coord of the player.
     *
     * @param y the y coord of the player.
     */
    public void setPosy(int y) {
        this.posy = y;
    }

    /**
     * returns the lastx coord of the player.
     *
     * @return the lastx coord of the player.
     */
    public int getLastx() {
        return lastx;
    }

    /**
     * returns the lasty coord of the player.
     *
     * @return the lasty coord of the player.
     */
    public int getLasty() {
        return lasty;
    }

    /**
     * sets the lastx coord of the player.
     *
     * @param lastx the lastx coord of the player.
     */
    public void setLastx(int lastx) {
        this.lastx = lastx;
    }

    /**
     * sets the lasty coord of the player.
     *
     * @param lasty the lasty coord of the player.
     */
    public void setLasty(int lasty) {
        this.lasty = lasty;
    }

    /**
     * returns the player's score.
     *
     * @return score value.
     */
    public int getscore() {
        return score;
    }

    /**
     * sets the player's score.
     *
     * @param scr score value.
     */
    public void setscore(int scr) {
        score = scr;
    }

    /**
     * returns if the player fought yet.
     *
     * @return fought variable.
     */
    public boolean getFought() {
        return fought;
    }

    /**
     * returns if the player did the event yet.
     *
     * @return the signevent_done variable.
     */
    public boolean getSignevent_done() {
        return signevent_done;
    }

    /**
     * returns if the player did the event yet.
     *
     * @return the wellevent_done variable.
     */
    public boolean getWellevent_done() {
        return wellevent_done;
    }

    /**
     * sets the player's fought variable.
     *
     * @param value the true or false value to set.
     */
    public void setFought(boolean value) {
        fought = value;
    }

    /**
     * sets the player's signevent_done variable.
     *
     * @param value the true or false value to set.
     */
    public void setSignevent_done(boolean value) {
        signevent_done = value;
    }

    /**
     * sets the player's wellevent_done variable.
     *
     * @param value the true or false value to set.
     */
    public void setWellevent_done(boolean value) {
        wellevent_done = value;
    }


}
