import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl('https://select2.org/getting-started/basic-usage')

//---------------------------------check single select2 box-------------------------------------------------------------------
CustomKeywords.'com.kms.katalon.keyword.select2.Select2.selectOptionByLabel'(findTestObject('Select2/select_single'), 'Hawaii')
CustomKeywords.'com.kms.katalon.keyword.select2.Select2.getAllOptionsLabel'(findTestObject('Select2/select_single'))
CustomKeywords.'com.kms.katalon.keyword.select2.Select2.getSelectedOptionsLabel'(findTestObject('Select2/select_single'))

//---------------------------------check multiple select2 box-------------------------------------------------------------------
CustomKeywords.'com.kms.katalon.keyword.select2.Select2.getAllOptionsLabel'(findTestObject('Object Repository/Select2/select_multi'))
List<String> a= ["Alaska", "Hawaii"]
CustomKeywords.'com.kms.katalon.keyword.select2.Select2.selectManyOptionsByLabel'(findTestObject('Object Repository/Select2/select_multi'), a)
CustomKeywords.'com.kms.katalon.keyword.select2.Select2.getSelectedOptionsLabel'(findTestObject('Object Repository/Select2/select_multi'))
List<String> b= ["Alaska"]
CustomKeywords.'com.kms.katalon.keyword.select2.Select2.removeOptions'(findTestObject('Object Repository/Select2/select_multi'), b)