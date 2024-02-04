package test;

import mHUI_Miner.TransactionStatsGenerator;

public class TranStatsMain {

	public static void main(String[] args) {
		String inputFile = "path to the input file";
		String fileName = "path to the ouput file"; //if the file does not exist, a new file will be created
		try{
			TransactionStatsGenerator transDBStats = new TransactionStatsGenerator(); 
			transDBStats.getStats(inputFile, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
