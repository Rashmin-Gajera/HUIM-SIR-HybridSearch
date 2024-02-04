/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mHUI_Miner_hybridSearch;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import static test.Main.fileToPath;
import mHUI_Miner_hybridSearch.MHUIMiner_SIR;

/**
 *
 * @author Suresh
 */
public class MHUIMiner_SIR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        // TODO code application logic here
        
        // TODO code application logic here
        String strfile="foodmart.txt";
        String input = fileToPath(strfile);
		//String output = ".//outputhuim.txt";
        String output = "outputhuim.txt";
		int min_utility = 7207;  
//		Double ratioUserInput = 6.0;
		System.out.println(input);
		// Applying the HUIMiner algorithm
		AlgomHUIMiner_hybridSearch huiminer = new AlgomHUIMiner_hybridSearch();
		huiminer.runAlgorithm(input, output, min_utility);
		huiminer.printStats();

    }
    public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url =MHUIMiner_SIR.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}

    
}