package mHUI_Miner;


/**
 * This is an implementation of an Item as used by the AlgoSimba class.
 * 
 * @see AlgoSimba
 * @author Prashant Barhate, modified by Alex Peng
 * 
 */

public class Item {

	private int itemID = 0;
	private int utility = 0;

	// public Item(int id) {
	// this.itemID = id;
	// }

	public Item(int id, int utility) {
		this.itemID = id;
		this.utility = utility;

	}

	/**
	 * method to get utility
	 */
	public int getUtility() {
		return utility;
	}

	/**
	 * method to get particular item
	 */
	public int getItemID() {
		return itemID;
	}
}
