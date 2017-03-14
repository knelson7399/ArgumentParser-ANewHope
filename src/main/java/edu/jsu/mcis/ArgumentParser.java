package edu.jsu.mcis;

import java.lang.*;
import java.util.*;
import java.io.*;



public class ArgumentParser{
    final List<Argument> listArgs;
    private String programName;
    private String programDescription;
	private String help;
	private String message;

	public ArgumentParser() {
                    
        listArgs = new ArrayList<Argument>();
          
    }
	public void addArg(String name, String description, Argument.Type type) {
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
	public void parse(String[] arg) throws RuntimeException{ 
		String name = "";
		String extra = "";
		String less = "";		
		
		for(Argument k : listArgs){
			name += " " + k.getName();
		}  
		String message = "usage: java" + getProgramName() + name + "\n" + getProgramName() + ".java: error: unrecognized arguments: " ;
		for(int i = 0; i < arg.length; i++){			
			if(arg[i].equals("-h") || arg[i].equals("--help")){
				String description = "";
				
				help= "usage: java " + getProgramName() + name + "\n" + getProgramDescription() + "\npositional arguments:";
				for(Argument k : listArgs){
					description += "\n" + k.getDescription();
				}  
				help+=description;
				help = help.trim();
				throw new HelpMessageException(help);
			}
		}
		if (arg.length > listArgs.size()){
			for (int i = listArgs.size(); i < arg.length; i++){
				extra += arg[i] + " "  ;
			}
			message = message + extra;
			message = message.trim();
			throw new IllegalArgumentException(message);
		}
				
		else if (arg.length < listArgs.size()) {
			for (int i = listArgs.size(); i < arg.length; i++){
				less += arg[i] + " " ; 
			}
			message = message + less;
			message = message.trim();
			throw new IllegalArgumentException(message);
			
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
	public String getProgramDescription(){
		return programDescription;
	}
	public void setProgramDescription(String description){
		programDescription =description;
	}
	
	public void setProgramName(String name){
		programName = name;
	}	

	
	public String getMessage(){
		return message;
	}
	
	public String getHelpMessage(){
		return help;
	}
	
}