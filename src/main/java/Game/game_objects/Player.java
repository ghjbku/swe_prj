package Game.game_objects;

import Game.Game;
import Game.game_objects.Item;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(propOrder = {"name", "items", "posx", "posy", "lastx", "lasty", "gender", "score", "fought"})
public class Player {
    private String name;
    private String gender = "female";
    private int posx = 29, posy = 47, score = 0, lastx = posx, lasty = posy;
    private ArrayList<Item> items = new ArrayList<Item>();
    private boolean fought = false;

    public Player() {
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Item getitem(int i) {
        return items.get(i);
    }

    public String getgender() {
        return gender;
    }

    public void setgender(String gend) {
        this.gender = gend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosx() {
        return posx;
    }


    public int getPosy() {
        return posy;
    }


    public void setPosx(int x) {
        this.posx = x;
    }


    public void setPosy(int y) {
        this.posy = y;
    }


    public int getLastx() {
        return lastx;
    }

    public int getLasty() {
        return lasty;
    }

    public void setLastx(int lastx) {
        this.lastx = lastx;
    }

    public void setLasty(int lasty) {
        this.lasty = lasty;
    }

    public int getscore() {
        return score;
    }


    public void setscore(int scr) {
        score = scr;
    }


    public boolean getFought() {
        return fought;
    }

    public void setFought(boolean value) {
        fought = value;
    }


}
