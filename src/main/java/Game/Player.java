package Game;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(propOrder = {"name","items"})
public class Player {
    private String name;
    private ArrayList<Item> items=new ArrayList<Item>();

    public Player(){}

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Item> getItems() {
        return items;
    }


    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

}
