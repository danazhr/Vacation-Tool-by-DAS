package com;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.LogInSteps;
import com.steps.NewVacationReqSteps;


@RunWith(ThucydidesRunner.class)
public class NewVacationReqTest {
	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	public Pages pages;
	
	@Steps 
	public NewVacationReqSteps newVacationReqSteps;
	
	@Steps
	 public LogInSteps logIn;
	
	@Test
	 public void go_to_new_request(){
		logIn.is_the_login_page();
		logIn.entersUsername("dana.zaharia");
		logIn.entersPassword("danna");
		logIn.clickLogIn();
		logIn.clickVacation();
		newVacationReqSteps.click_newVacationReq();
		 
	}
	

}
