package astraeus_v1;
import java.util.*;


public class BarLengthForData {
	public double DataToBarLength(ArrayList<ArrayList<Data>> data , String Datatype, int barLength){
		int locationOfinfo;
		for(int i =0;i<(data.get(data.size()-1).size()-1);i++){
			if (data.get(data.size()-1).get(i).getType() == Datatype){
				locationOfinfo=i;
			}
		}
		
		double rawlength = data.get(data.size()-1).get(locationOfinfo).getValue();
		return((rawlength/barLength)*100);
	}
}
