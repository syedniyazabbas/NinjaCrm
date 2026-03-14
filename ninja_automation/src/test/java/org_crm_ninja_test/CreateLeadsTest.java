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
import object_repository.CreateLeadPage;
import object_repository.HomePage;
import object_repository.LeadSuccessPage;
import object_repository.LeadsPage;

public class CreateLeadsTest extends BaseClass
{
	ExcelUtility eu = new ExcelUtility();
	
	@Test
	public void createLead(ITestContext context) throws EncryptedDocumentException, IOException, InterruptedException
	{
		HashMap<String, String> mapId=(HashMap<String, String>)context.getAttribute("ids");
		String id=mapId.get("Campaignid");
		    System.out.println(id);
		HomePage hp=new HomePage(driver);
		hp.clickLeadLink();
		LeadsPage lp=new LeadsPage(driver);
		lp.clickLeadCreateBtn();
	String[] data=	eu.getDataFromExcelFile("createleads", 1);
	data[0]=data[0]+ju.getRandomString();
	data[6]=data[6]+ju.getRandom4DigitNumber();
	data[7]=ju.getRandomString()+data[7];
		CreateLeadPage form=new CreateLeadPage(driver);
		
		form.fillDetails(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9], data[10],
				data[11], data[12], data[13], data[14], data[15], data[16], data[17]);
		Thread.sleep(2000);
		
			
		CampaignChildWindowPage child=new CampaignChildWindowPage(driver);
		String Pid=child.openCampaignWIndow();
		Reporter.log(Pid,true);
		child.selectionbyid(id);
		
		driver.switchTo().window(Pid);
		
		form.clickSubmit();
		Thread.sleep(4000);
		
		LeadSuccessPage lsp=new LeadSuccessPage(driver);
		lsp.closeSuccessAlert();
		String leadId=lsp.getCreatedLeadId();
		mapId.put("LeadId", leadId);
		context.setAttribute("ids", mapId);
		
		String displayedCId=lsp.getActualCampaignId();
		
		Assert.assertEquals(displayedCId, id,"Test Failed");
		Reporter.log("Verification success 3", true);
	}
	
	
	
	
	

}
