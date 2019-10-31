Feature: Form automation
  As a user i want to navigate to homepage and fill the form

  Background:
    Given user opens url

  Scenario Outline: form submit
    When user fills "<firstName>" and  "<lastName>"
    And user selects gender
    And user fills "<Date of birth>" and "<address>" and "<email>" and  "<password>" and "<company>"
    And selects role
    And selects job expectations
    And selects ways of development
    And fills "<comment>"
    And clicks Submit
    Then success message is shown

    Examples:
      | firstName | lastName | Date of birth | address        | email            | password | company | comment |
      | Nargiza   | Pulatova | 01/01/2000    | 123 test ave   | abc@abc.com      | abc123   | forte   | test    |
      | Jon       | Walsh    | 10/03/2006    | 13 kenmore ave | aabcdefg@abc.com | haha     | charles | comment |