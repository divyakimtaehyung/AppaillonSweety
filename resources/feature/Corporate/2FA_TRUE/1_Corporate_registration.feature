@2FAT
Feature: Customer registration

  Background: 2FA_REQUIRED is true in the system
    Given a valid corporate application

  @DB-TC-38 @DB-TC-39
  Scenario Outline: Verify that a customer is able to register successfully when 2_FACTOR_AUTH = Y in the system
    When user clicks on the Sign Up link
    And user lands on Sign Up page
	And enters a valid Email ID and Country code & Mobile number <testcase>
    And clicks on the Sign Up button
    Then user lands on OTP screen
    And user should receive an email with the OTP
    When user enters the OTP
    And clicks on the Verify button
    Then user is created successfully <messagecode>
    And user is navigated to the Login screen
    Examples:
        | testcase | messagecode |
#        | DB-TC-38 | CF_001 |
#        | DB-TC-39 | CF_001 |
#        | DB-TC-39-1 | CF_001 |
        | DB-TC-39-2 | CF_001 |
#        | DB-TC-39-3 | CF_001 |



