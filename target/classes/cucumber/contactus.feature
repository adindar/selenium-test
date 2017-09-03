Feature: Contact Us Page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services!!

Scenario: Valid Submission 
	Given I am on the QAWorks Site 
	Then I try to contact QAWorks with the following information 
		| name     | email                | message                                   |
		| j.Bloggs | j.Bloggs@qaworks.com | please contact me I want to find out more |
		
Scenario Outline: Invalid Submission
	Given I am on the QAWorks Site
	And I try to contact QAWorks with the following information
		| name   | email   | message   |
		| <name> | <email> | <message> |
	Then I can see the following message "<errorMessage>" 
	Examples:
		| name     | email                | message | errorMessage             |
		|          | j.Bloggs@qaworks.com | test    | Your name is required    |
		| j.Bloggs |                      | test    | Please type your email   |
		| j.Bloggs | j.Bloggs@qaworks.com |         | Please type your message |