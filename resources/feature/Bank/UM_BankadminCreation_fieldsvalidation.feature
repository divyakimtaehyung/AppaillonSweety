@J1
Feature: Fields validation while bank admin creation by super admin

  Background: 2FA_REQUIRED is true in the system
    Given a valid bank application
    When super admin enters a valid email ID and password <testcase>
    And clicks on the Login button
    Then super admin lands on the Dashboard page


  @fullname
  Scenario Outline: Verify that 'Full Name' is a mandatory field and accepts only alphabets with spaces up to 250 characters and no special characters allowed while creating a bank admin
    When admin clicks on the User Management link from LHS <testcase>
    Then click add new user button
    But enters no data in Full Name field <testcase>
    And clicks on save button
    Then system should highlight the Full Name field in red color
    And system should not allow to enter special characters in Full Name field <testcase>
    And system should not allow to enter numbers in Full Name field <testcase>
    Examples:
      | testcase |
      | DB-TC-2  |


  @email
  Scenario Outline: Verify that 'Email ID' is a mandatory field & unique across tenants and accepts alphanumeric with special characters(! # $ @ & + - / = ? ^ _ { |) up to 250 characters while creating a bank admin
    When admin clicks on the User Management link from LHS <testcase>
    Then click add new user button
    But enters no data in Email ID field <testcase>
    And clicks on save button
    Then system should highlight the EmailID field in red color
    And system should not allow to enter more than 250 characters in Email ID field <testcase>
    And system should not allow to enter special characters in Email ID field <testcase>
    Examples:
      | testcase |
      | DB-TC-3  |


  @app
  Scenario Outline: Verify that 'Application Name' is a mandatory field and pre-defined values should populate
    When admin clicks on the User Management link from LHS <testcase>
    Then click add new user button
    But predefined Application name should be present
    Examples:
      | testcase |
      | DB-TC-4  |

  @countrycode
  Scenario Outline: Verify that 'Country Code' is a mandatory field and pre-defined codes should populate
    When admin clicks on the User Management link from LHS <testcase>
    Then click add new user button
    But predefined Country Code should be present

    Examples:
      | testcase |
      | DB-TC-5  |

  @mobileNum
  Scenario Outline: Verify that 'Mobile Number' is a mandatory field & unique across tenants and accepts only numeric up to 15 digits
    When admin clicks on the User Management link from LHS <testcase>
    Then click add new user button
    But enters no data in Mobile Number field <testcase>
    And clicks on save button
    Then system should highlight the MobileNumber field in red color
    And system should not allow to enter more than 15 characters in Mobile Number field <testcase>
    And system should not allow to spaces Mobile Number field <testcase>
    And system should display an error message as User already exists in the system when entered an already registered mobile number
    Examples:
      | testcase |
      | DB-TC-6  |


  @role
  Scenario Outline: Verify that 'Role ID' is a mandatory field and pre-defined roles should populate
    When admin clicks on the User Management link from LHS <testcase>
    Then click add new user button
    But predefined Role ID should be present
    Examples:
      | testcase |
      | DB-TC-7  |


  @upload
  Scenario Outline: Verify that 'User Photo' is optional while creating a bank admin
    When admin clicks on the User Management link from LHS <testcase>
    And enters all the mandatory and optional fields <testcase>
    But uploads invalid file format in User Photo field
    Then error message should be displayed
    Examples:
      | testcase |
      | DB-TC-8  |


  @cancel
  Scenario Outline: Verify the functionality of the Cancel button while creating a bank admin
    When admin clicks on the User Management link from LHS <testcase>
    And enters all the mandatory and optional fields <testcase>
    And clicks on Cancel button
    Then admin lands on the User Management summary page
    And clicks on Add button from User Management summary screen
    Then lands on User addition screen
    Then click add new user button
    And Previously entered data should get cleared from the User details section
    Examples:
      | testcase |
      | DB-TC-9  |


  @logout
  Scenario Outline: Verify that bank admin is able to logout from the application successfully
    When super admin clicks on logout
    Then displayed with logout pop up
    When clicks on Cancel
    Then super admin lands on the Dashboard page
    When super admin clicks on logout
    Then displayed with logout pop up
    When clicks on Ok
    Then user lands on Login page
    Examples:
      | testcase |
      | DB-TC-28 |



      #undeveloped features
#  Scenario Outline: Verify that super admin is able to search all the available products by providing Product code as the search criteria
#    When super admin logs into the application with valid email ID and password
#    Then super admin lands on the Dashboard page
#    When clicks on the product Management link from Quick link
#    Then super admin lands product management summary screen
#    And select a Product Code from the list
#    And clicks on Search button
#    When clicks on a product
#    Then super admin should be navigated to the View page of the particular product
#    Examples:
#    DB-TC-61
#
#      #undeveloped features
#  Scenario Outline: Verify that 'Operational unit' is a mandatory field and pre-defined values should populate
#    And enters all the mandatory and optional fields
#    But enters no data in Operational unit field
#    And clicks on Confirm button
#    Then system should highlight the Operational unit field in red color
#    Examples:
#    DB-TC-20
#
#





