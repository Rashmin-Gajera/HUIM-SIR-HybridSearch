package FHM_Miner;

// this class represent an item and its utility in a transaction
class PairItemUtility{
	int item = 0;
	int utility = 0;
	
	public String toString() {
		return "[" + item + "," + utility + "]";
	}
}