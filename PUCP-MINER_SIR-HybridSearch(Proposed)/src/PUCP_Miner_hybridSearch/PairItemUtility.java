package PUCP_Miner_hybridSearch;

// this class represent an item and its utility in a transaction
class PairItemUtility{
	int item = 0;
	int utility = 0;
	
	public String toString() {
		return "[" + item + "," + utility + "]";
	}
}