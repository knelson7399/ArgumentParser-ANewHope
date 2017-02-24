
package edu.jsu.mcis;

import static org.junit.Assert.*;
import org.junit.*;


public class VolumeCalculatorTest {
	private parseArgument pa;
	private genArg ga;
	
	
	@Before
	public void setUp(){
		pa = new parseArgument();
		ga = new genArg();
	}
	
	@Test
	public void testgenArg(){
		ga.setName("length");
		ga.setDescription("box length");
		ga.setType(genArg.Type.INTEGER);
		ga.setValue("7");
		assertEquals("length", ga.getName());
		assertEquals("box length", ga.getDescription());
		assertEquals(genArg.Type.INTEGER, ga.getType());
		assertEquals(7, ga.getValue());
	}
	
	@Test	
	public void addArgsMultArguments(){
		pa.addArgs("Parser", "", genArg.Type.INTEGER);
		assertEquals(pa.getlistSize(), 1);
		pa.addArgs("Parser1","", genArg.Type.FLOAT);
		assertEquals(pa.getlistSize(), 2);
	}
	@Test
	public void addArgsGenArg(){
		ga.setName("length");
		pa.addArgs(ga);
		assertEquals(pa.getlistSize(), 1);
	}
	@Test
	public void parseArgs(){
		genArg ga2 = new genArg();
		ga2.setName("Parser2");
		ga.setName("length");
		pa.addArgs(ga);
		pa.addArgs(ga2);
		String[] args = {"val1", "val2"};
		pa.parseArgs(args);
		genArg temp = new genArg();
		temp = pa.getArg("length");
		assertEquals("val1", temp.getValue());
		temp = pa.getArg("Parser2");
		assertEquals("val2", temp.getValue());
	}
	@Test (expected= IllegalArgumentException.class)
	public void TooManyArgs(){
		genArg ga2 = new genArg();
		ga2.setName("Parser2");
		ga.setName("length");
		pa.addArgs(ga);
		pa.addArgs(ga2);
		String[] args = {"val1", "val2", "val3"};
		pa.parseArgs(args);
		genArg temp = new genArg();
		temp = pa.getArg("length");
		assertEquals("val1", temp.getValue());
		
	}	
	@Test (expected= IllegalArgumentException.class)
	public void TooFewArgs(){
		genArg ga2 = new genArg();
		ga2.setName("Parser2");
		ga.setName("length");
		pa.addArgs(ga);
		pa.addArgs(ga2);
		String[] args = {"val1"};
		pa.parseArgs(args);
		genArg temp = new genArg();
		temp = pa.getArg("length");
		assertEquals("val1", temp.getValue());
	}	
}
