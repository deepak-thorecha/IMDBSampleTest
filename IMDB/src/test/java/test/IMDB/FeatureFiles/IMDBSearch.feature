#Author: deepak.thorecha@gmail.com
Feature: Seach features
  I want to check for search functionalities
	
  Scenario Outline: Keyword Search from IMDB homepage
  		Given "<browser>" is opened
  		And I am on HomePage
    When I select "<option>" in dropdown
	  And Enter search keyword as "<srchKey>"
    Then I verify the "<verifyText>" in results

    Examples: 
      | browser	| option 			| srchKey  			| verifyText 										|
      | CHROME	| TV Episodes 	| Walking Dead 	| Walking Dead (2014) (TV Episode)	|
      | FF			| TV Episodes 	| Walking Dead 	| Walking Dead (2014) (TV Episode)	|

    Scenario Outline: Most Popular TV Shows Search from IMDB homepage
  		Given "<browser>" is opened
  		And I am on HomePage
    When I click <Most Popular TV Shows> in <Movies, TV, & ShowTime’s> submenu
	  And Click on "<title>"
    Then I verify that creator name is "<creator>" on details
    
    Examples:
    		| browser	| title 									| creator 				|
    		| CHROME		| The Walking Dead (2010)	| Frank Darabont	|