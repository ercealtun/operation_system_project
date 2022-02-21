package Interfaces;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */
import Models.Folder;

public interface IDeleteFolderFrame {

	 /**
	  * @implNote removes selected folder object from ArrayList<Folder> folderList
	  * 	and add same object to ArrayList<Folder> deletedFolderList.
	  */
	void deleteFolder(int folderIndex, Folder folder);
	
	 /**
	  * @implNote returns any folder object with corresponding folder name.
	  */
	Folder findFolder(String folderName);
	
	 /**
	  * @implNote returns index of any folder object with corresponding folder name.
	  */
	int findFolderIndex(String folderName);
	
	 /**
	  * @implNote gathers folder names from ArrayList<Folder> folderList and
	  * 	assigns them to new string array, finally returns that string array.
	  */
	String[] listToArray();
}
