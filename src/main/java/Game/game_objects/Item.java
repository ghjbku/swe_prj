package Game.game_objects;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlValue
    private String name;
    @XmlAttribute
    private int id;
    @XmlAttribute
    private int x, y;

    public Item() {
    }

    public Item(String name, int id, int x, int y) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public int getid() {
        return id;
    }

    public void setname(String n){name=n;}
    public void setid(int i){id=i;}
    public void setx(int value){x=value;}
    public void sety(int value){y=value;}

}
