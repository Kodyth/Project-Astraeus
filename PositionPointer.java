package astraeus_v1;
import java.util.*;

import javax.xml.crypto.Data;

import sun.java2d.d3d.D3DSurfaceData;

public class PositionPointer {
public double PositionPointerX(ArrayList<ArrayList<Data>> data){
	int locationOfLat;
	for(int i =0;i<(data.get(data.size()-1).size()-1);i++){
		if (data.get(data.size()-1).get(i).getType() == "latiitude)"){
			locationOfLat=i;
		}
	}
	
	double r= data.get(data.size()-1).get(locationOfLat).getValue();
	
	double result = 10*Math.cos(r-90);
return result;
}
public double PositionPointery(ArrayList<ArrayList<Data>> data){

	int locationOfLong;
	for(int i =0;i<(data.get(data.size()-1).size()-1);i++){
		if (data.get(data.size()-1).get(i).getType() == "longitude)"){
			locationOfLong=i;
		}
	}
	
	double s= data.get(data.size()-1).get(locationOfLong).getValue();
	

return (s+180);
}}
