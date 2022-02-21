package Models;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */

/*
 * Folder model class.
 */
public class Folder {

	public String name;
	public int size;
	public String createDate;
	
    public Folder(String name, int size, String createDate) {
        this.name = name;
        this.size = size;
        this.createDate = createDate;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
