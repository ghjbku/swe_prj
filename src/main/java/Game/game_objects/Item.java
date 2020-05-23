package Game.game_objects;

import javax.xml.bind.annotation.*;

/**
 * Item class "model".
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlValue
    private String name;
    @XmlAttribute
    private int id;
    @XmlAttribute
    private int x, y;

    /**
     * default constructor.
     */
    public Item() {
    }

    /**
     * constructor that sets the parameters of the item.
     *
     * @param name name of the item.
     * @param id   id of the item.
     * @param x    x coordinate of the item.
     * @param y    y coordinate of the item.
     */
    public Item(String name, int id, int x, int y) {
        this.name = name;
        this.id = id;
    }

    /**
     * function that returns the item's name.
     *
     * @return items name.
     */
    public String getName() {
        return name;
    }

    /**
     * function that returns the item's id.
     *
     * @return item's id.
     */
    public int getid() {
        return id;
    }

    /**
     * method that sets the item's name.
     *
     * @param n the name to set to.
     */
    public void setname(String n) {
        name = n;
    }

    /**
     * method that sets the item's id.
     *
     * @param i the id to set to.
     */
    public void setid(int i) {
        id = i;
    }

    /**
     * method that sets the item's coord.
     *
     * @param value the value to set to.
     */
    public void setx(int value) {
        x = value;
    }

    /**
     * method that sets the item's coord.
     *
     * @param value the value to set to.
     */
    public void sety(int value) {
        y = value;
    }

}
