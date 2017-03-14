package edu.jsu.mcis;


public class HelpMessageException extends RuntimeException {
	private String help; 

    public HelpMessageException () {
		super ();
		//help = "usage: java VolumeCalculator length width height\nCalcuate the volume of a box.\npositional arguments:\nlength the length of the box (float)\nwidth the width of the box(float)\nheight the height of the box(float)";
    }
	public HelpMessageException (String message) {
		super (message);
	}
	/*
	@Override
	private String getMessage(){
		return help;
	}*/
    
   /*Bobbie Notes:
		Do not have the help variable
		Have a function inside of ArgumentParser build a message for you so you can use the HelpMessageException(String message)
		List of things needed in the function (ArgumentParser):
			empty string
			add "java" + programName
			loop through the args and get names for those
			programDescription + "positional arguments:"
			loop through and get the descriptions for the args
	  Refactoring:
		Merge message systems together? Maybe
	*/
}