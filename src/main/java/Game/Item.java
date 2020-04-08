package Game;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlValue
    private String name;
    @XmlAttribute
    private int id;

    public Item(){}

    public Item(String name,int id){
    this.name=name;
    this.id=id;
    }

    public String getName(){
        return name;
    }
}
