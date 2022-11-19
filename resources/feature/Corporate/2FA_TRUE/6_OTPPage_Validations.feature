@2FAT @otp
Feature: Validating the OTP functionalities in the process of corporate Login

  Background: 2FA_REQUIRED is true in the system
    Given a valid corporate application
    When user in Login screen

  @DB-TC-45
  Scenario Outline: Verify that once OTP expires, the customer should receive an email on click on Resend OTP link and the customer should be able to login into the application using the OTP in the same session
    And  user enters valid Email ID and Password <testcase>
    And clicks on Login button
    And OTP sent message should appear <messagecode1>
    Then user lands on OTP screen
    When clicks on Resend OTP after timer becomes zero
    Then system should send OTP to registered mobile number and email ID <messagecode2>
    When user enters the OTP
    And clicks on the Verify button
    Then user lands on the Dashboard page
    Examples:
        | testcase | messagecode1 |  messagecode2 |
        | DB-TC-45 | CF_003       | CF_027      |

  @DB-TC-46
  Scenario Outline: Verify that during login, OTP verification is required after entering a valid email ID and password of a customer when 2_FACTOR_AUTH = Y in the system and the customer has opted in for 2FA
    And  user enters valid Email ID and Password <testcase>
    And clicks on Login button
    Then OTP sent message should appear <messagecode1>
    Then user lands on OTP screen
    And user should receive an email with the OTP
    When user enters the OTP
    And clicks on the Verify button
    Then user lands on the Dashboard page
    Examples:
      | testcase | messagecode1 |
      | DB-TC-46 | CF_003       |


  @DB-TC-47
  Scenario Outline: Verify that during login, OTP verification is not required after entering a valid email ID and password of a customer when 2_FACTOR_AUTH = Y in the system and the customer has opted out from 2FA
    And opted out user enters valid Email ID and Password <testcase>
    And clicks on Login button
    And user lands on the Dashboard page
    Examples:
      | testcase |
      | DB-TC-47 |


  @DB-TC-52
  Scenario Outline: Verify that customer is redirected to the login page when the customer clicks on the Resend OTP link consecutively the no. of times
    And user enters valid Email ID and Password <testcase>
    And clicks on Login button
    Then user lands on OTP screen
    Then OTP sent message should appear <messagecode1>
    When clicks on Resend OTP link for n times <messagecode2>
    Then resend otp limit reached message should display <messagecode3>
    Then user is navigated to the Login screen
    Examples:
      | testcase | messagecode1 |  messagecode2 |  messagecode3 |
      | DB-TC-52 | CF_003       | CF_027      |  CF_014      |

  @DB-TC-53
  Scenario Outline: Verify that the customer is redirected to the login page when the user enters the wrong OTP consecutively for n no. of times
    And user enters valid Email ID and Password <testcase>
    And clicks on Login button
    Then user lands on OTP screen
    Then OTP sent message should appear <messagecode1>
    When user enters invalid OTP for n times <messagecode2>
    And clicks on the Verify button
    Then max otp retries reached message should display <messagecode3>
    Then user is navigated to the Login screen
    Examples:
      | testcase | messagecode1 |  messagecode2 |  messagecode3 |
      |  DB-TC-53 | CF_003       | CF_013      | CF_014      |




