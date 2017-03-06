package edu.jsu.mcis;


public class HelpMessageException extends RuntimeException {
	private String help; 

    public HelpMessageException () {
		super ();
		String help = "usage: java VolumeCalculator length width height\nCalcuate the volume of a box.\npositional arguments:\nlength the length of the box (float)\nwidth the width of the box(float)\nheight the height of the box(float)";
    }
	public HelpMessageException (String message) {
		super (message);
	}
	public String getHelpMessage(){
		return help;
	}
    
   
}