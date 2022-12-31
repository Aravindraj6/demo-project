package org.prj;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)	
@CucumberOptions(features ="C:\\Users\\DELL\\eclipse-workspace\\Project\\src\\test\\resources\\featurefile\\Hotelbooking.feature",
                 glue="org.bok",monochrome=true)
                 //,tags={"@adactinglogin","@hotelbookingdetails"})
                 

public class HotelBooking {
	
	
}