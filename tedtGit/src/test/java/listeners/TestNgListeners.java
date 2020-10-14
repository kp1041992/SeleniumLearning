package listeners;


import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Listeners(listeners.TestListeners.class)
public class TestNgListeners {

	@Test
	public void test1() {
		System.out.println("*************Test 1********");
	}

	@Test
	public void test2() {
		System.out.println("*************Test 2********");
		Assert.assertTrue(false);
	}

	@Test
	public void test3() {
		System.out.println("*************Test 3********");
		throw new SkipException("this is skipped");
	}

}
