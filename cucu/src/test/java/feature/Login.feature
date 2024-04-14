Feature: My Learing Of Login Automation

  Background: 
    Given User Navigate To Learining Page
    #And User Enter The Name As "student"

  Scenario Outline: Login Should Be Success
    Given User Enter The Password As "Password123"
    When User Click Submit Button
    Then Login Should Be Success

  Scenario Outline: Login Should Be Fail
    Given User Enter The Password As "<password>"
    When User Click Submit Button
    But Login Should Be Failure
    #Examples: 
    #|username|password|
      #| student  | Password123   |
      #| student  | wrongpassword |
