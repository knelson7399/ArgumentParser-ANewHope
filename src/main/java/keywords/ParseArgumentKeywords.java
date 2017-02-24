
package keywords;
import edu.jsu.mcis.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ParseArgumentKeywords {
	parseArgument pa;
	boolean error; 
	//List<String> absurdArgs;
	
	public void StartVolumeCalculatorWithArguments(String[] args){
		pa = new parseArgument();
		error = false;
		pa.setProgramName("VolumeCalculator");
		pa.addArgs("length", "", genArg.Type.STRING);
		pa.addArgs("width", "", genArg.Type.STRING);
		pa.addArgs("height", "", genArg.Type.STRING);
		try{
			pa.parseArgs(args);
		}
		catch(IllegalArgumentException e){
			error = true;
		}
	}
	
	public String getWidth(){
		return pa.getArg("width").getValue();
	}
	
	public String getHeight(){
		return pa.getArg("height").getValue();
	}
	
	public String getLength(){
		return pa.getArg("length").getValue();
	}
	
	public String getProgramOutput(){
		if (error == true){
			return pa.getMessage();
		}
		else{
			int length = Integer.parseInt(getLength());
			int width = Integer.parseInt(getWidth());
			int height = Integer.parseInt(getHeight());
			
			int volume = length*width*height;
			
			return Integer.toString(volume);
		}
		
	}
	public void StartAbsurdProgramWithArguments(String[] args){
		pa = new parseArgument();
		error = false;
		/*absurdArgs = new ArrayList<String>();
		for(int i = 0; i < args.length; i++){
			absurdArgs.add(args[i]);
		}*/
		
		pa.addArgs("pet", "", genArg.Type.STRING);
		pa.addArgs("number", "", genArg.Type.STRING);
		pa.addArgs("rainy", "", genArg.Type.STRING);
		pa.addArgs("bathrooms", "", genArg.Type.STRING);
		
		try{
			pa.parseArgs(args);
		}
		catch(IllegalArgumentException e){
			error = true;
		}
	}
	public String getPet(){
		return pa.getArg("pet").getValue();
	}
	public String getNumber(){
		return pa.getArg("number").getValue();
	}
	public String getRainy(){
		return pa.getArg("rainy").getValue();
	}
	public String getBathrooms(){
		return pa.getArg("bathrooms").getValue();
	}
	
	
	
}

	
	
	