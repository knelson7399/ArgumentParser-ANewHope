package edu.jsu.mcis;


public class HelpMessageException extends RuntimeException {
	private String help; 

    public HelpMessageException () {
		super ();
		
    }
	public HelpMessageException (String message) {
		super (message);
	}
	
}