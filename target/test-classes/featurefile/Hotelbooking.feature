Feature: Verify the adactin hotel booking app by booking rooms and print the order ID
@adactinglogin
  Scenario Outline: Verify the login functionality by giving valid username and password
		Given User is on Adactin login page
		When User enters "<username>" and "<password>"
		And User click the login button
		Then User enters in adactin login portal
		Then User verify the adactin login page
		Then User close the page
	Examples:
      |username  |password |	
	   	|ARAVINDRJ |aravinD  |
@hotelbookingdetails
   Scenario Outline: Verify the room booking functionality by giving the complete details
   	Given User is on Adactin login page
		When User enters "<username>" and "<password>"
		And User click the login button
		Then User enters in adactin login portal
    Given User is on Adactin login portal
    When User select the location 
    And User select the hotel name
    And User select the room type
    And User enter the number of rooms
    And User enter the checkin and checkout date
    And User select the number of persons
    And User click the search button
    Then User enter into the confirm page
    Then User close the page
	Examples:
      |username  |password |	
	   	|ARAVINDRJ |aravinD  | 
@bookingconfirm
  Scenario Outline: Verify the functionality of confirm page
    Given User is on Adactin login page
		When User enters "<username>" and "<password>"
		And User click the login button
		Then User enters in adactin login portal
    Given User is on Adactin login portal
    When User select the location 
    And User select the hotel name
    And User select the room type
    And User enter the number of rooms
    And User enter the checkin and checkout date
    And User select the number of persons
    And User click the search button
    Then User enter into the confirm page
    Given User is on confirm page
    When User select the cofirm button after verifying the booking details
    And User click the continue button
    Then User enter into payment portal
    Then User close the page
    
	Examples:
      |username  |password |	
	   	|ARAVINDRJ |aravinD  |
@paymentdetails    
  Scenario Outline: Verify the payment functionality to enter the valid credit card detail
    Given User is on Adactin login page
		When User enters "<username>" and "<password>"
	  And User click the login button
		Then User enters in adactin login portal
    Given User is on Adactin login portal
    When User select the location 
    And User select the hotel name
    And User select the room type
    And User enter the number of rooms
    And User enter the checkin and checkout date
    And User select the number of persons
    And User click the search button
    Then User enter into the confirm page
    Given User is on confirm page
    When User select the cofirm button after verifying the booking details
    And User click the continue button
	  Given User is on payment portal
	  And User enter the name of the credit card holder
	  And User enter billing address of credit card holder
	  And User enter the valid credit card number
	  And User select the credit card type
	  And User select the expiry date
	  And User enter the cvv number
	  And User click the book now button
	  Then User get the order ID
 Examples:
    |username  |password |	
	  |ARAVINDRJ |aravinD  |
        
