package webdriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * An abstract class that describes the basic tests application contains
 * methods for logging and field tests settings (options)
 */

public abstract class BaseTest extends BaseEntity {


	@BeforeTest
	public void windowsMaximize() {
		browser.maximize();
	}
	/**
	 * To override.
	 */
	public abstract void runTest();

	/**
	 * Test
	 * @throws Throwable Throwable
	 */
	@Test
	public void xTest() throws Throwable {
		Class<? extends BaseTest> currentClass = this.getClass();
		
		try {
			logger.logTestName(currentClass.getName());
			browser.navigate(Browser.getBaseUrl());
			runTest();
			logger.logTestEnd(currentClass.getName());
		} catch (Throwable e) {
			
				logger.warn("");
				logger.warnRed(getLoc("loc.test.failed"));
				logger.warn("");
				logger.fatal(e.getMessage());
			}
		
	}

	/**
	 * Format logging
	 * @param message Message
	 * @return Message
	 */
	protected String formatLogMsg(final String message) {
		return message;
	}

}
