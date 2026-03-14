package org_crm_ninja_test;



import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.ExcelUtility;
import object_repository.CampaignChildWindowPage;
import object_repository.ContactCreatedPage;
import object_repository.ContactsPage;
import object_repository.CreateContactPage;
import object_repository.HomePage;

public class CreateContactsTest extends BaseClass {
	ExcelUtility eu = new ExcelUtility();
	
	@Test
	public void createContacts(ITestContext context) throws EncryptedDocumentException, IOException, InterruptedException {
		HashMap<String, String> mapId=(HashMap<String, String>)context.getAttribute("ids");
		String id=mapId.get("Campaignid");
		    System.out.println(id);
		HomePage hp=new HomePage(driver);
		hp.clickContactLink();
		ContactsPage cp=new ContactsPage(driver);
		cp.clickCreateContactLink();
		
	String []data=eu.getDataFromExcelFile("createcontacts", 1);
	data[1]=data[1]+ju.getRandomString();
	data[4]=data[4]+ju.getRandomString();
	data[5]=data[5]+ju.getRandom4DigitNumber();
	
	
	data[6]=ju.getRandomString()+data[6];
	
	
		CreateContactPage form=new CreateContactPage(driver);
		form.fillDetails(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
		CampaignChildWindowPage child=new CampaignChildWindowPage(driver);
		String Pid=child.openCampaignWIndow();
		child.selectionbyid(id);
		

		driver.switchTo().window(Pid);
		form.getSubmitBtn().click();
		Thread.sleep(2000);
		ContactCreatedPage ccp=new ContactCreatedPage(driver);
		ccp.closeSuccessAlert();
		
//Verification
	String cid=	ccp.getCreatedContactId();
	System.out.println(cid);
	mapId.put("contactId", cid);
	context.setAttribute("ids", mapId);
	
	String actualname=ccp.getActualOrgName();
	System.out.println(actualname);
	System.out.println("expected name "+ data[0]);
	Assert.assertEquals(actualname, data[0],"Test Failed");
	Reporter.log("2ndVerific success", true);
		
				
		
		
		
	}

}
