 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package HUI_Miner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;


/**
 *
 * @author vijay
 */
public class Hui_Miner {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
       
            // TODO code applicsoation logic here
            // TODO code application logic here
            String strfile="foodmart.txt";
            String input = fileToPath(strfile);
            //String output = ".//outputhuim.txt";
            String output = "outputhuim.txt";
//		int min_utility = 100000;
           // Double ratioUserInput = 0.0001;
            
            // Applying the HUIMiner algorithm
            Integer minUtility=7207; 
            System.out.println(input);
            
            AlgoHUIMiner huiminer = new AlgoHUIMiner();
            huiminer.runAlgorithm(input, output, minUtility);
          //  huiminer.runAlgorithm(input, output, minUtility);
            
            huiminer.printStats();
        } 
    
  public static String fileToPath(String filename) throws UnsupportedEncodingException{
	       URL url=Hui_Miner.class.getResource(filename);
               return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
		 
	}
    }
    

