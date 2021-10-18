Feature: Flipkart Tests
  
  Background: 		
  Given user open Flipkart url

	@flipkart
  Scenario: Test Flipkart Title
    Then user check title is Flipkart.com

	@flipkart
  Scenario: Search Flipkart Test
    When user search ipad on Flipkart
    Then ipad is visible on Flipakrt
