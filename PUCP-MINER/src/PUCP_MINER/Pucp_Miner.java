/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PUCP_MINER;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;


/**
 *
 * @author vijay
 */
public class Pucp_Miner {

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
            String output = "outputhuim_tdr.txt";
//		int min_utility = 100000;
           // Double ratioUserInput = 0.0001;
            
            // Applying the HUIMiner algorithm
            Integer minUtility=7207; 
            
            System.out.println(input);
            AlgoPUCPMiner huiminer = new AlgoPUCPMiner();
            huiminer.runAlgorithm(input, output, minUtility);
          //  huiminer.runAlgorithm(input, output, minUtility);
            
            huiminer.printStats();
        } 
    
  public static String fileToPath(String filename) throws UnsupportedEncodingException{
	       URL url=Pucp_Miner.class.getResource(filename);
               return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
		 
	}
    }
    

