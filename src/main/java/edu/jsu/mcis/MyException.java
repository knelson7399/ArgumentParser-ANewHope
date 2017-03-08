package customExceptions;

public class MyException extends Exception{
	String t = "YO!!";
	
    public MyException(String exc)
    {
        super(exc);
    }
    public String getMessage()
    {
        return t;
    }
}