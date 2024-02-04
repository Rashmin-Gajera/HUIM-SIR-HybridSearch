/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mHUI_Miner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import static test.Main.fileToPath;
import mHUI_Miner.MHUIMiner;

/**
 *
 * @author Suresh
 */
public class MHUIMiner {

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
//		Double ratioUserInput = 0.002;
		
		// Applying the HUIMiner algorithm
		AlgomHUIMiner huiminer = new AlgomHUIMiner();
		huiminer.runAlgorithm(input, output, min_utility);
		huiminer.printStats();

    }
    public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url =MHUIMiner.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}

    
}
