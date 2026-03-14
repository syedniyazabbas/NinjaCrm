package org_crm_ninja_test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.ExcelUtility;
import object_repository.CampaignPage;
import object_repository.CreateCampaignPage;
import object_repository.HomePage;

public class CreateCampaignsTest extends BaseClass {

	ExcelUtility eu = new ExcelUtility();

	@Test
	public void createCampaigns(ITestContext context) throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage hp = new HomePage(driver);
		hp.clickCampaignLink();
		CampaignPage cp = new CampaignPage(driver);
		cp.clickCreateCampBtn();
		CreateCampaignPage form = new CreateCampaignPage(driver);
		
	String[] data=	eu.getDataFromExcelFile("createcampaign", 1);
	
	data[1]=data[1]+ju.getRandomString();
	System.out.println(Arrays.toString(data));
	
	 form.createCampaign(data[1], data[2], data[3], data[4], data[5], data[6]);
	 
	 cp.closeSuccessAlert();
//Verification
	String generatedid= cp.getGeneratedIdText();
	HashMap<String, String> mapId=new HashMap<String, String>();
	mapId.put("Campaignid", generatedid);
	
    context.setAttribute("ids", mapId);
	System.out.println("New id is: "+generatedid);
	String actualCampName= cp.getCreatedCampNameText();
	Assert.fail();
	Reporter.log("Verific success", true);
	
	
	}
	@Test(dependsOnMethods = "createCampaigns")
	public void dummy()
	{
		System.out.println("Dummy test");
	}
}
