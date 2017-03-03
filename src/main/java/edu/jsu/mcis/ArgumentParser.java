package edu.jsu.mcis;

import java.lang.*;
import java.util.*;
import java.io.*;


public class ArgumentParser{
	private List<Argument> listArgs;
    private String programName;
    private String programDescription;
	private String help;
	private String message;

	public ArgumentParser() {
                    
        listArgs = new ArrayList<Argument>();
          
    }
	public void addArg(String name, String description, Argument.Type type){
        Argument temp = new Argument();
        temp.setName(name);
        temp.setDescription(description);
        temp.setType(type);
		System.out.println(temp);
		addArg(temp);
    }
	
	public void addArg(Argument arg){
		listArgs.add(arg);
	}
	
	public void parse(String[] arg){
		if(listArgs.size()!=arg.length()){
			getErrorMessage(arg);
		}
		else {
			for(int i=0; i<arg.length; i++){
				listArgs.get(i).setValue(arg[i]);
			}	
		}		
	}
		
	public Argument getArg(String name){
		for(int i=0; i<listArgs.size(); i++){
			if(name.equals(listArgs.get(i).getName())){
				return listArgs.get(i);
			}
		}
		return null;
	}	
	public int getNumArguments(){
		return listArgs.size();
	}
	public String getProgramName(){
		return programName;
	}
	
	public void setProgramName(String name){
		programName = name;
	}	
	private void getErrorMessage(String[] arg){
		String message = "usage: java";  
		String name = "";
		String extra = "";
		
		
		for(Argument k : listArgs){
			name += " " + k.getName();
		}         
		if (arg.length > listArgs.size()){
			for (int i = listArgs.size(); i < arg.length; i++){
				extra += arg[i] + " "  ;
			}
		}
				
		message = message + getProgramName() + name + "\n" + getProgramName() + ".java: error: unrecognized arguments: " + extra;
		message = message.trim();
		throw new IllegalArgumentException (message);
	}
	
	public String getMessage(){
		return message;
	}
	
	public void helpMessage(){
		if(listArgs.equals("-h")){
                help = "usage: java VolumeCalculator length width height\nCalcuate the volume of a box.\npositional arguments:\nlength the length of the box (float)\nwidth the width of the box(float)\nheight the height of the box(float)";
				help = help.trim();
				throw new IllegalArgumentException (help);
		}
	
	}
	public String getHelpMessage(){
		return help;
	}
	
}