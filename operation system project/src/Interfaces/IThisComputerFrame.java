package Interfaces;
/**
 * @author Erce Altun 
 * @author Ahmet Ýloðlu
 * 
 */
public interface IThisComputerFrame {

	/**
	  * @implNote computes total used capacity and returns to the result.
	  */
	int totalusedCapacity();
	
	/**
	  * @implNote computes total used capacity percent and returns to the result.
	  */
	int computePercent(int usedCap, int totalCap);
}
