package com.kms.katalon.keyword.select2

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import groovy.transform.CompileStatic
import com.kms.katalon.core.annotation.Keyword

public class Utils {
	static WebDriver driver = DriverFactory.getWebDriver()
	
	/**
	 * Click on select2 text box.
	 *
	 * @param to The select2 box object that tagged as "select" in the document.
	 */
	@CompileStatic
	@Keyword
	static clickOnSelect2(TestObject to) {
		findContainer(to).click()
	}

	/**
	 * Find the container class after the select element.
	 *
	 * @param to The select2 box object that tagged as "select" in the document.
	 * @return The WebElement that seen as container class after the select element.
	 */
	@CompileStatic
	@Keyword
	static WebElement findContainer(TestObject to) {
		WebElement select2Element = WebUiCommonHelper.findWebElement(to, 60)
		String subContainerClass ="./following-sibling::*[contains(@class,'container')]"
		return select2Element.findElement(By.xpath(subContainerClass))
	}
	
	/**
	 * Select the result after filling text search to select2 text box.
	 *
	 * @param option The label of option need to select.
	 * @param subContainerOpenClass The Xpath string of the container class.
	 */
	@CompileStatic
	@Keyword
	static selectResult(String option, String subContainerOpenClass) {
		String resultClass = "//li[contains(@class,'select2-results') and normalize-space(text())='" + option + "']"
		WebElement result = driver.findElement(By.xpath(subContainerOpenClass + resultClass))
		result.click()
	}

	/**
	 * Enter text search to the select2 text box.
	 *
	 * @param option The label of option need to search.
	 * @return The Xpath string of the container class.
	 */
	@CompileStatic
	@Keyword
	static String enterText(String option) {
		String subContainerOpenClass = "//*[contains(@class,'container--open')]"
		WebElement searchBox =  driver.findElement(By.xpath(subContainerOpenClass + "//input"))
		searchBox.sendKeys(option)
		return subContainerOpenClass
	}
}
