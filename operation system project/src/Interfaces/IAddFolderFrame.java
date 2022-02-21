package Interfaces;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */
import Models.Folder;

public interface IAddFolderFrame {
	 /**
	  * @implNote adds folders to ArrayList<Folder> folderList
	  */
	void addFolder(Folder folder);
	
	 /**
	  * @implNote computes available free space and returns true 
	  * 	if new folder is appropriate for adding
	  */
	boolean isSpaceAvaible(int newFolderSize);
}
