package edu.jsu.mcis;

import static org.junit.Assert.*;
import org.junit.*;


public class HelpTest {
	private ArgumentParser pa;
	private Argument ga;
	
	@Before
	public void setUp(){
		pa = new ArgumentParser();
		ga = new Argument();
	}
	
	@Test (expected= HelpMessageException.class)
	public void TestUsageMessage(){
		ga.setName("-h");
		pa.addArg(ga);
		String[] args = {"-h"};
		pa.parse(args);
		Argument temp = new Argument();
		temp = pa.getArg("-h");
		System.out.println(temp);
		assertEquals("-h", temp.getValue());
	}

	@Test (expected = HelpMessageException.class)
	public void TestLongFormUsageMessage(){
		ga.setName("--help");
		pa.addArg(ga);
		String[] args = {"--help"};
		pa.parse(args);
		Argument temp = new Argument();
		temp = pa.getArg("--help");
		System.out.println(temp);
		assertEquals("--help", temp.getValue());
	}
}