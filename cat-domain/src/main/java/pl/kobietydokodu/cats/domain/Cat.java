package pl.kobietydokodu.cats.domain;
import java.util.Date;
/**
 * Created by Karolke on 24.06.2016.
 */
public class Cat {

    private String name;
    private String ownerName;
    private Date birthDate;
    private Double weight;


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }



    public Cat(String name, String ownerName, Date date, double weight){
        this.name = name;
        this.ownerName = ownerName;
        this.birthDate = date;
        this.weight = weight;
    }
    public Cat(){

    }

    public void introduce(){
        System.out.println("Cat name: " + this.name + "\nowner name: " + this.ownerName
                + "\nweight: " + this.weight + "\nbirthdate: " + this.birthDate);
    }

}
