package Interfaces;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */
import Models.User;

public interface ILockFrame {
	
	/**
	  * @implNote reads user strings from Users.txt and creates new User objects, and 
	  * 	adds them to ArrayList<User> userList.
	  */
	void readUsers();
	
	/**
	  * @implNote checks if selected user's password matches with collected password string.
	  */
	boolean loginConfiguration(User user, String password);
	
	/**
	  * @implNote returns any User object with corresponding user name.
	  */
	User findUser(String username);
	
	/**
	  * @implNote gathers user names from ArrayList<User> folderList and
	  * 	assigns them to new string array, finally returns that string array.
	  */
	String[] listToArray();
	
	/**
	  * @implNote checks if there is a user with same user name.
	  */
	boolean isUserExist(String username);
}
