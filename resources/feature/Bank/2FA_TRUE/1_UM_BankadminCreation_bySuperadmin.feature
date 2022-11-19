@2FT
Feature: Bank admin creation by super admin


  Background: 2FA_REQUIRED is true in the system
    Given a valid bank application
    When super admin enters a valid email ID and password <testcase>
    And clicks on the Login button
    Then super admin lands on the Dashboard page


  @superAdmin
  Scenario Outline: Create a bank admin by super admin when 2FA_REQUIRED is true in the system and super admin has opted in for 2FA
    When admin clicks on the User Management link from LHS <testcase>
    Then admin lands on the User Management summary page
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then bank admin is created successfully
    And super admin is navigated to the User Management summary screen
    And new bank admin should receive an email with the login password <testcase>
    Examples:
      | testcase |
      | DB-TC-10 |


  @optOut
  Scenario Outline: Create a bank admin by super admin when 2FA_REQUIRED is true in the system and super admin has opted out for 2FA
    When admin clicks on the User Management link from LHS <testcase>
    Then admin lands on the User Management summary page
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then bank admin is created successfully
    And super admin is navigated to the User Management summary screen
    And new bank admin should receive an email with the login password <testcase>
    Examples:
      | testcase |
      | DB-TC-34 |


#newly added
@1
  Scenario Outline: Verify that the super admin is able to create a bank admin successfully in the system when the 2_FACTOR_AUTH = Y in the system and the super admin has opted in for 2FA
    When admin clicks on the User Management link from LHS <testcase>
    Then admin lands on the User Management summary page
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then bank admin is created successfully
    And new bank admin should receive an email with the login password <testcase>
    When Admin enters OTP and clicks verify <testcase>
    Then bank admin is created successfully message
    And superadmin is navigated to the UserManagement summary screen<testcase>
    When enters bank admin Email Id in Email Id search criteria and click search <testcase>
    Then bank admin record of search match will be displayed in the result
    When select Bank Application in Application Name search criteria and click search
    Then all bank admin records of Bank Application will be displayed in the result
    When select authorized in Status search criteria and click search
    Then all authorized bank admin records will be displayed in the result
    Examples:
      | testcase |
      | DB-TC-10 |


  @2
  Scenario Outline: Verify that the super admin is able to create a bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the super admin has opted out from 2FA
    When admin clicks on the User Management link from LHS <testcase>
    Then admin lands on the User Management summary page
    And enters all the mandatory and optional fields <testcase>
    And clicks on Confirm button
    Then bank admin is created successfully
    And new bank admin should receive an email with the login password <testcase>
    When Admin enters OTP and clicks verify <testcase>
    Then bank admin is created successfully message
    And superadmin is navigated to the UserManagement summary screen<testcase>
    When enters bank admin Email Id in Email Id search criteria and click search <testcase>
    Then bank admin record of search match will be displayed in the result
    When select Bank Application in Application Name search criteria and click search
    Then all bank admin records of Bank Application will be displayed in the result
    When select authorized in Status search criteria and click search
    Then all authorized bank admin records will be displayed in the result
    Examples:
      | testcase |
      | DB-TC-34 |

  @3
  Scenario Outline: Verify that super admin can approve an add initiated bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FAVerify that super admin can approve an add initiated bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    Then login with bankadmin
    When bank admin logs into the application with valid email ID and password <testcase>
    Then bank admin lands on the Dashboard page
    Then create new user by admin <testcase>
    And superadmin is navigated to the UserManagement summary screen<testcase>
    When enters bank admin UnAuthorized user Email Id search criteria and click search <testcase>
    When select Unauthorized in Status search criteria and click search
    When clicks on one unauthorized record
    And super admin lands on confirmation screen and clicks on approve button
  #    Then super admin lands on OTP screen
#    When super admin enters OTP and clicks verify
    Then bank admin is created successfully
    And new bank admin should receive an email with the login password <testcase>
    And superadmin is navigated to the UserManagement summary screen<testcase>
    When enters bank admin Email Id in Email Id search criteria and click search <testcase>
    Then bank admin record of search match will be displayed in the result
    When select Bank Application in Application Name search criteria and click search
    Then all bank admin records of Bank Application will be displayed in the result
    When select authorized in Status search criteria and click search
    Then all authorized bank admin records will be displayed in the result
    Examples:
      | testcase  |
      | DB-TC-133 |

  @4
  Scenario Outline: Verify that super admin can approve an add initiated bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the admin has opted out from 2FA
    Then login with bankadmin
    When bank admin logs into the application with valid email ID and password <testcase>
    Then bank admin lands on the Dashboard page
    Then create new user by admin <testcase>
    And superadmin is navigated to the UserManagement summary screen<testcase>
    When enters bank admin UnAuthorized user Email Id search criteria and click search <testcase>
    When select Unauthorized in Status search criteria and click search
    When clicks on one unauthorized record
    And super admin lands on confirmation screen and clicks on approve button
    Then bank admin is created successfully
    And new bank admin should receive an email with the login password <testcase>
    And superadmin is navigated to the UserManagement summary screen<testcase>
    When enters bank admin Email Id in Email Id search criteria and click search <testcase>
    Then bank admin record of search match will be displayed in the result
    When select Bank Application in Application Name search criteria and click search
    Then all bank admin records of Bank Application will be displayed in the result
    When select authorized in Status search criteria and click search
    Then all authorized bank admin records will be displayed in the result
    Examples:
      | testcase  |
      | DB-TC-134 |

  @5
  Scenario Outline: Verify that the bank admin is able to reject an add initiated bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    Then login with bankadmin
    When bank admin logs into the application with valid email ID and password <testcase>
    Then bank admin lands on the Dashboard page
    Then create new user by admin <testcase>
    And superadmin is navigated to the UserManagement summary screen<testcase>
    When enters bank admin UnAuthorized user Email Id search criteria and click search <testcase>
    When select Unauthorized in Status search criteria and click search
    When clicks on one unauthorized record
    And super admin lands on confirmation screen and clicks on reject button
#    Then super admin lands on OTP screen
#    When super admin enters OTP and clicks verify
    Then bank admin is creation is rejected successfully message is displayed
    When enters bank admin Email Id in Email Id search criteria and click search <testcase>
    When select Bank Application in Application Name search criteria and click search
    Then all bank admin records of Bank Application will be displayed in the result
    When select authorized in Status search criteria and click search
    Then all authorized bank admin records will be displayed in the result
    Examples:
      | testcase  |
      | DB-TC-194 |

  @6
  Scenario Outline: Verify that the bank admin is able to reject an add initiated bank admin successfully in the system when 2_FACTOR_AUTH = Y in the system and the admin has opted out from 2FA
    Then login with bankadmin
    When bank admin logs into the application with valid email ID and password <testcase>
    Then bank admin lands on the Dashboard page
    Then create new user by admin <testcase>
    And superadmin is navigated to the UserManagement summary screen<testcase>
    When enters bank admin UnAuthorized user Email Id search criteria and click search <testcase>
    When select Unauthorized in Status search criteria and click search
    When clicks on one unauthorized record
    And super admin lands on confirmation screen and clicks on reject button
#    Then super admin lands on OTP screen
#    When super admin enters OTP and clicks verify
    Then bank admin is creation is rejected successfully message is displayed
    When enters bank admin Email Id in Email Id search criteria and click search <testcase>
    When select Bank Application in Application Name search criteria and click search
    Then all bank admin records of Bank Application will be displayed in the result
    When select authorized in Status search criteria and click search
    Then all authorized bank admin records will be displayed in the result
    Examples:
      | testcase  |
      | DB-TC-195 |