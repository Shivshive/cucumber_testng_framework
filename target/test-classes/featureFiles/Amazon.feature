Feature: Amazon Tests
  
  Background: 		
  Given user open amazon url

	@amazon
  Scenario: Test Amazon Title
    Then user check title is amazon.in

	@amazon
  Scenario: Search Test
    When user search ipad
    Then ipad is visible
