@2FAT @signup
Feature: Fields validation while Corporate User creation

  Background: 2FA_REQUIRED is true in the system
    Given a valid corporate application
    When user clicks on the Sign Up link
    And user lands on Sign Up page

  @DB-TC-49
  Scenario Outline: Verify that 'Email ID' is a mandatory field & unique across tenants and accepts alphanumeric with special characters(! # $ @ & + - / = ? ^ _ { |) up to 250 characters while creating a bank admin
    But user enter no data Email ID field
    And user enters all the mandatory and optional fields <testcase>
    And clicks on the Sign Up button
    Then system should highlight the Email ID field <messagecode1>
    And system should not accept more than 100 characters in Email ID field
    And system should allow invalid special characters to enter in Email ID field <messagecode2>
    When user enters already registered Email ID
    Then error message should display <messagecode3>
    Examples:
      | testcase | messagecode1 |  messagecode2 |  messagecode3 |
      | DB-TC-49 | CF_009       | CF_010      | CF_011     |

  @DB-TC-50
  Scenario Outline: Verify that 'Country Code' is a mandatory field and pre-defined codes should populate
    And user enters all the mandatory and optional fields <testcase>
    But predefined Country Codes should be present
    Examples:
      | testcase  |
      | DB-TC-50 |

  @DB-TC-51
  Scenario Outline: Verify that 'Mobile Number' is a mandatory field & unique across tenants and accepts only numeric up to 15 digits
    But user enters no data in Mobile Number field
    And user enters all the mandatory and optional fields <testcase>
    And clicks on the Sign Up button
    Then system should highlight the Mobile Number field <messagecode1>
    And system should not accept more than 15 characters in Mobile Number field
    And system should not accept spaces Mobile Number field
    When user enters already registered Mobile Number
    And error message should display <messagecode2>
    Examples:
      | testcase | messagecode1 |  messagecode2 |
      | DB-TC-51 | CF_012       | CF_011      |











