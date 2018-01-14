#Author: your.email@your.domain.com
Feature: Register user on IMDB
  I want to test user registration on IMDB
	
	Background:
		Given "<browser>" is opened
  		And I am on HomePage
  
  Scenario: Register user on IMDB with test data
    When I click on <Other Sign in options>
    And I click on <Create a New Account>
	  And Fill all the details
    Then I verify that user is logged in
    When I click LogOut option in UserMenu
    Then I verify user is logged out
  
#  Scenario: Logout already logged in user
#  		When I click LogOut option in UserMenu
#  		Then I verify user is logged out