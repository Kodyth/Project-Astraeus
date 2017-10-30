package astraeus_v1;
import java.io.FileWriter;
import java.io.IOException;
import Data;
import java.util.*;

public class FileIO {
	



	    public static void generateCsvFileAll(String fileName, ArrayList<ArrayList<Data>> data)
	    {
	           try
	           {
	                FileWriter writer = new FileWriter(fileName);

	                writer.append("Datatype");
	                writer.append(',');
	                writer.append("Value");
	                writer.append('\n');
	                for(int i=0;i<(data.size()-1);i++){
	                for (int j=0;j<(data.get(i).size()-1);j++) {
	                     writer.append(data.get(i).get(j).getType());
	                     writer.append(',');
	                     writer.append(data.get(i).get(j).getValue());
	                     writer.append('\n');
	                }}

	                writer.flush();
	                writer.close();
	           } catch(IOException e) {
	                 e.printStackTrace();
	           } 
	      }
	    public static void generateCsvFileSelect(String fileName, ArrayList<ArrayList<javax.xml.crypto.Data>> data,String datatype){
	    	int dataloc;
	    	for(int i =0;i<(data.get(0).size()-1);i++){
	    		if (data.get(0).get(i).getType() == datatype){
	    			dataloc=i;
	    		}
	    	}
	    	try
	           {
	                FileWriter writer = new FileWriter(fileName);

	                writer.append("Datatype");
	                writer.append(',');
	                writer.append("Value");
	                writer.append('\n');
	                for(int i=0;i<(data.size()-1);i++){
	                
	                     writer.append(data.get(i).get(dataloc).getType());
	                     writer.append(',');
	                     writer.append(data.get(i).get(dataloc).getValue());
	                     writer.append('\n');
	                }

	                writer.flush();
	                writer.close();
	           } catch(IOException e) {
	                 e.printStackTrace();
	           } 
	    }
	 }

