package com;

import java.text.ParseException;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.steps.InboxSteps;
import com.steps.LogInSteps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom("Resources/DifferentStartAndEndDatesReq.csv")

public class InboxTest {
	
	 @Managed(uniqueSession = true)
	    public WebDriver webdriver;
	 
	 @ManagedPages(defaultUrl = "http://192.168.1.68:9090")
	    public Pages pages;
	 
	 @Steps
	 public InboxSteps inboxSteps;
	 
	 @Steps
	 public LogInSteps logInSteps;
	 
	 String startDate,endDate,name;
	 
	 //@Test
	 public void verify_that_inbox_requests_number_displayed_is_the_same_as_in_the_table(){
		 logInSteps.is_the_login_page();
		 logInSteps.entersUsername("dana.zaharia");
		 logInSteps.entersPassword("danna");
		 logInSteps.clickLogIn();
		 logInSteps.clickVacation();
		 inboxSteps.go_to_inbox();
		 Assert.assertEquals("expected requests number is different!!!", inboxSteps.get_inbox_requests_number(), inboxSteps.get_table_requests_number());
	 }
	 
	 //@Test
	 public void verify_that_approve_button_works_for_selected_request() throws ParseException{
		 logInSteps.is_the_login_page();
		 logInSteps.entersUsername("dana.zaharia");
		 logInSteps.entersPassword("danna");
		 logInSteps.clickLogIn();
		 logInSteps.clickVacation();
		 inboxSteps.go_to_inbox();
		 //Assert.assertEquals("expected requests number is different!!!", inboxSteps.get_inbox_requests_number(), inboxSteps.get_table_requests_number());
		 inboxSteps.select_request("Anca Oprean", "14/05/2015");
		 inboxSteps.click_approve_button();
		 inboxSteps.check_if_selected_request_was_approved("Anca Oprean", "14/05/2015"); 
		 
	 }
	 
	 @Test
	 public void verify_that_the_workdays_number_from_table_is_correct() throws ParseException{
		 logInSteps.is_the_login_page();
		 logInSteps.entersUsername("dana.zaharia");
		 logInSteps.entersPassword("danna");
		 logInSteps.clickLogIn();
		 logInSteps.clickVacation();
		 inboxSteps.go_to_inbox();
		 Assert.assertEquals("expected requests number is different!!!", inboxSteps.get_inbox_requests_number(), inboxSteps.get_table_requests_number());
		 inboxSteps.check_if_number_of_workdays_is_correct(startDate, endDate, name);
	 }

}
