package com.actitime.pages;

import com.actitime.base.TestBase;

public class HomePage extends TestBase {


	public boolean validateHomePage() {
		return driver.getTitle().contains("actiTIME - Open Tasks");
	}
	

	
}
