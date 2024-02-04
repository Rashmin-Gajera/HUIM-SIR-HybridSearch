package mHUI_Miner_hybridSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a UtilityList as used by the AlgoSimba algorithm.
 *
 * @see UtilityTuple
 * @see AlgoSimba
 * @author Philippe Fournier-Viger, modified by Alex Peng
 */
public class UtilityList {
	final Integer itemID;
	long sumIutils = 0; // the sum of item utilities
	long sumRutils = 0; // the sum of remaining utilities
	// contains all the utilityTuples of an item
	List<UtilityTuple> uLists = new ArrayList<UtilityTuple>();

	/**
	 * Constructor.
	 * 
	 * @param item
	 *            the item that is used for this utility list
	 */
	public UtilityList(Integer itemID) {
		this.itemID = itemID;
	}
	
	/**
	 * Constructor.
	 * 			used when the itemID is not important
	 * 
	 */
	public UtilityList() {
		this.itemID = null;
	}
	

	/**
	 * Method to add a utility tuple to this utility list and update the sums at the
	 * same time.
	 */
	public void addTuple(UtilityTuple uTuple) {
		sumIutils += uTuple.getIutils();
		sumRutils += uTuple.getRutils();
		uLists.add(uTuple);
	}

	/**
	 * Get the support of the itemset represented by this utility-list
	 * 
	 * @return the support as a number of trnsactions
	 */
	public int getSupport() {
		return uLists.size();
	}
}