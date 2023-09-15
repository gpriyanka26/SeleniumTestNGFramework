package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFailedDemo {
	
	@Test
	public void test1() {
		
		System.out.println("I am inside test1");
	}
	
	@Test
	public void test2() {
		
		System.out.println("I am inside test2");
		int i = 1/0;
		System.out.println("Test 2 Failed");
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyser.class)
	public void test3() {
		
		System.out.println("I am inside test3");
		Assert.assertTrue(false);
		System.out.println("Test 3 Failed");
	}

}
