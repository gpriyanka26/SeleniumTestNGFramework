package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {
	
	@Test(dependsOnGroups = {"sanity"})
	public void test1() {

		System.out.println("I am inside test1");
	}
	
	@Test(groups = {"sanity"})
	public void test2() {

		System.out.println("I am inside test2");
	}
	
	@Test
	public void test3() {

		System.out.println("I am inside test3");
	}
	
	
}
