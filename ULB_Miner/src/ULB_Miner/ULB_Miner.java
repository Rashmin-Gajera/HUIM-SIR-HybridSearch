/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ULB_Miner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
/**
 *
 * @author vijay
 */
public class ULB_Miner {

    /**
     * @param args the command line arguments
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        // TODO code application logic here
        String strfile="chess.txt";
        String input = fileToPath(strfile);
		//String output = ".//outputhuim.txt";
String output = "outputhuim.txt";
//		int min_utility = 100000;  
		//Integer ratioUserInput = 30;
                int minUtility=560731
;
                        
		// Applying the HUIMiner algorithm
		AlgoULBMiner huiminer = new AlgoULBMiner();
                huiminer.runAlgorithm(input, output, minUtility);
				huiminer.printStats();
    }
    public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url =ULB_Miner.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
    
    }
    

