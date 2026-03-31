Feature: Facebook feature


  @facebook @Regression
  Scenario: Login into facebook
    Given User is hits the facebook url
    When user is on facebook login page
    Then user is displayed with "UserName" and "Password" textbox


    @Amazon @Regression
    Scenario: Go to amazon and search for Iphone
      Given User hits the amazon url
       When User see the search text box
      Then User enter "Iphone"
      And get all the options shown in the suggestions

  @Amazon1 @Regression
  Scenario: Go to amazon and search for Iphone
    Given User hits the amazon url
    When User see the search text box
    Then User enter "Key ="

  @Amazon @Regression
  Scenario: Go to amazon and search for Iphone
    Given User hits the amazon url
    When User see the search text box
    Then User enter "Iphone"
    And click on search button
