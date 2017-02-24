package edu.jsu.mcis;

import java.util.*;
import java.lang.*;
import java.io.*;

	
	public class genArg{
		protected Object value;
		protected String description;
		protected Type type;
		protected String name;
		public enum Type {BOOLEAN, FLOAT, INTEGER, STRING};
	

	public genArg(){
		value = "";
		description = "";
		type = Type.STRING;
		name = "";
	}

	public void setValue (Object value){
		this.value = value;
	}

	public <T> T getValue(){
		if (type == genArg.Type.INTEGER) return (T)(Integer.valueOf((String)value));		
		else if (type == genArg.Type.BOOLEAN) return (T)(Boolean.valueOf((String)value));
		else if (type == genArg.Type.FLOAT) return (T)(Float.valueOf((String)value));
		else if (type == genArg.Type.STRING) return (T)(String.valueOf((String)value));
		return (T)(String)value;
	}

	public void setType(Type type){
		this.type = type;
	}

	public Type getType(){
		return type;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}
	
	public void setName (String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

}
