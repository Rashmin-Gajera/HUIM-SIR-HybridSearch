/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FHM_Miner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

/**
 *
 * @author Suresh
 */
public class FHM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        // TODO code application logic here
        
        // TODO code application logic here
        String strfile="chess.txt";
        String input = fileToPath(strfile);
		//String output = ".//outputhuim.txt";
String output = "outputhuim.txt";
//		int min_utility = 100000;  
		int MinUtility = 560731;
		
		// Applying the HUIMiner algorithm
		AlgoFHM huiminer = new AlgoFHM();
		huiminer.runAlgorithm(input, output, MinUtility);
		huiminer.printStats();

    }
    public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url =FHM.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}

    
}
