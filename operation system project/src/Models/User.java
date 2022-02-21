package Models;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */

/*
 * User model class.
 */
public class User { 
	
	public String name, password;
	
    public User(String name, String password) {
        this.name = name;
        this.password = password;

    }

    public String toString(){

        return this.name+" "+this.password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return password;
    }

    public void setSurname(String surname) {
        this.password = surname;
    }

}
