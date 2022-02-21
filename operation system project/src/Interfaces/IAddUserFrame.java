package Interfaces;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */
import Models.User;

public interface IAddUserFrame {
	 /**
	  * @implNote creates new user object and returns it.
	  */
	User createUser(String username, String password);
	
	 /**
	  * @implNote adds new user to ArrayList<User> userList 
	  * 	and calls 'writeFile(User user)'.
	  */
	void saveUser(User user);
	
	 /**
	  * @implNote checks if there is a user with same user name
	  * 	before add new user.
	  */
	boolean isUserExist(String username);
	
	 /**
	  * @implNote writes new User object to Users.txt.
	  */
	void writeFile(User user);
}
