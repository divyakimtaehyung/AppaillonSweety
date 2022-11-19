Feature: Workflow management feature for bank admin

  Background: 2FA_REQUIRED is True in the system
    Given a valid bank application
    When super admin logs into the application with valid email ID and password <testcase>
    Then lands on the Dashboard page
    When clicks on workflow management from LHS Menu
    Then lands on workflow management summary screen

  Scenario Outline: Verify that the bank admin can add initiate workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the bank admin has opted in for 2FA
    When admin clicks on add button<testcase>
    Then system lands on Workflow Management add initiate screen
    When enters valid details in all the mandatory fields and clicks on Save button
    Then admin lands on confirmation screen
    When admin clicks confirm
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with add initiated status
    Examples:
      | testcase |
      | DB-TC-127 |

  Scenario Outline: Verify that the bank admin can add initiate workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the bank admin has opted out from 2FA
    When admin clicks on add button<testcase>
    Then system lands on Workflow Management add initiate screen
    When enters valid details in all the mandatory fields and clicks on Save button
    Then admin lands on confirmation screen
    When admin clicks confirm
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with add initiated status
    Examples:
      | testcase |
      | DB-TC-128 |

  Scenario Outline: Verify that the bank admin can approve an add initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Add Initiated in Status field and click on Search button<testcase>
    Then system should list down the add initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click authorize
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-129 |

  Scenario Outline: Verify that the bank admin can approve an add initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted out from 2FA
    When selects Add Initiated in Status field and click on Search button<testcase>
    Then system should list down the add initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click authorize
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-130 |

  Scenario Outline: Verify that bank admin can reject an add initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Add Initiated in Status field and click on Search button<testcase>
    Then system should list down the add initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click Reject
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-136 |

  Scenario Outline: Verify that bank admin can reject an add initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Add Initiated in Status field and click on Search button<testcase>
    Then system should list down the add initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click Reject
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-137 |


  Scenario Outline: Verify that the bank admin can modify initiate workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the bank admin has opted in for 2FA
    When selects authorized in Status field and click on Search button<testcase>
    And clicks on the modify button for a record
    Then lands on the modification screen
    When enters valid data in the mandatory fields and clicks save
    Then lands on confirmation screen
    When admin clicks confirm
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the modified record
    Then record should be displayed with modify initiated status
    Examples:
      | testcase |
      | DB-TC-148 |

  Scenario Outline: Verify that the bank admin can modify initiate workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the bank admin has opted out for 2FA
    When selects authorized in Status field and click on Search button<testcase>
    And clicks on the modify button for a record
    Then lands on the modification screen
    When enters valid data in the mandatory fields and clicks save
    Then lands on confirmation screen
    When admin clicks confirm
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the modified record
    Then record should be displayed with modify initiated status
    Examples:
      | testcase |
      | DB-TC-149 |

  Scenario Outline: Verify that the bank admin can approve a modify initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Modify Initiated in Status field and click on Search button<testcase>
    Then system should list down the modify initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click authorize
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-150 |

  Scenario Outline: Verify that the bank admin can approve a modify initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted out from 2FA
    When selects Modify Initiated in Status field and click on Search button<testcase>
    Then system should list down the modify initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click authorize
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should be displayed with authorized status
    Examples:
      | testcase |
      | DB-TC-151 |

  Scenario Outline: Verify that the bank admin can reject a modify initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Modify Initiated in Status field and click on Search button<testcase>
    Then system should list down the modify initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click Reject
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-154 |

  Scenario Outline: Verify that the bank admin can reject a modify initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted out for 2FA
    When selects Modify Initiated in Status field and click on Search button<testcase>
    Then system should list down the modify initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters remarks and click Reject
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-155 |

  Scenario Outline: Verify that the bank admin can delete initiate workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the bank admin has opted in for 2FA
    When selects authorized in Status field and click on Search button<testcase>
    And clicks on the delete button for a record
    Then lands on the deletion screen
    When clicks delete button
    Then lands on confirmation screen
    When admin clicks confirm
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the modified record
    Then record should be displayed with delete initiated status
    Examples:
      | testcase |
      | DB-TC-160 |

  Scenario Outline: Verify that the bank admin can delete initiate workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the bank admin has opted out for 2FA
    When selects authorized in Status field and click on Search button<testcase>
    And clicks on the delete button for a record
    Then lands on the deletion screen
    When clicks delete button
    Then lands on confirmation screen
    When admin clicks confirm
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the modified record
    Then record should be displayed with delete initiated status
    Examples:
      | testcase |
      | DB-TC-161 |

  Scenario Outline: Verify that the bank admin can approve a delete initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Delete Initiated in Status field and click on Search button<testcase>
    Then system should list down the delete initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters invalid data remarks and click authorize
    Then remarks field should be highlighted in red colour
    When enters remarks and click authorize
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should not be displayed
    Examples:
      | testcase |
      | DB-TC-162 |

  Scenario Outline: Verify that the bank admin can approve a delete initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted out for 2FA
    When selects Delete Initiated in Status field and click on Search button<testcase>
    Then system should list down the delete initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters invalid data remarks and click authorize
    Then remarks field should be highlighted in red colour
    When enters remarks and click authorize
    Then admin displayed with successful message and DB should be updated
    When clicks ok and lands on summary screen searches the added record
    Then record should not be displayed
    Examples:
      | testcase |
      | DB-TC-163 |

  Scenario Outline: Verify that the bank admin can reject a delete initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Delete Initiated in Status field and click on Search button<testcase>
    Then system should list down the delete initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters invalid data remarks and click Reject
    Then remarks field should be highlighted in red colour
    When enters remarks and click Reject
    Then lands on  OTP screen
    When enters OTP from mail and clicks verify
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-166 |

  Scenario Outline: Verify that the bank admin can reject a delete initiated workflow mapping successfully when 2_FACTOR_AUTH = Y in the system and the admin has opted in for 2FA
    When selects Delete Initiated in Status field and click on Search button<testcase>
    Then system should list down the delete initiated record
    When click on the record
    Then lands on the confirmation screen
    When enters invalid data remarks and click Reject
    Then remarks field should be highlighted in red colour
    When enters remarks and click Reject
    Then admin displayed with rejection message and DB should be updated
    When clicks ok and lands on summary screen searches the record
    Then record should be displayed with rejected by authorizer status
    Examples:
      | testcase |
      | DB-TC-167 |